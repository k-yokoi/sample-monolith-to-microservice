package net.k_yokoi.sample.monolith.to.microservice.chat.app.web.security;

import java.util.Locale;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.user.UserResource;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.user.User;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.repository.user.CredentialUserRepository;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.service.portal.PortalOrchestrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    MessageSource messageSource;

    @Autowired
    PortalOrchestrationService portalOrchestrationService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        try {
            UserResource userResource = portalOrchestrationService.findOneByLoginId(userName);
            List<GrantedAuthority> authorities = null;
            if(userResource.isAdmin()){
                authorities = AuthorityUtils.createAuthorityList( "ROLE_ADMIN", "ROLE_USER" );
            }else{
                authorities = AuthorityUtils.createAuthorityList( "ROLE_USER" );
            }
            return CustomUserDetails.builder()
                    .userResource(userResource)
                    .authorities(authorities)
                    .build();
        }catch (BusinessException e){
            throw new UsernameNotFoundException(messageSource.getMessage(
                    "BE0001", null, Locale.getDefault()), e);
        }
    }

}

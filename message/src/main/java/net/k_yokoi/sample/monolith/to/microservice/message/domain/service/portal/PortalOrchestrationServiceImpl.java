package net.k_yokoi.sample.monolith.to.microservice.message.domain.service.portal;

import java.util.Locale;
import java.util.Objects;
import net.k_yokoi.sample.monolith.to.microservice.message.app.model.portal.PortalInformation;
import net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.user.UserResourceMapper;
import net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.user.UserResource;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.user.User;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.user.CredentialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class PortalOrchestrationServiceImpl implements PortalOrchestrationService {

    @Autowired
    MessageSource messageSource;

    @Autowired
    CredentialUserRepository userRepository;

    @Override
    public PortalInformation getPortalInformation(String userId) {
        User user = userRepository.findByUserId(Long.parseLong(userId));
        if(Objects.isNull(user)){
            String errorCode = "BE0001";
            System.err.println(errorCode +  messageSource.getMessage(
                    errorCode, new String[]{userId.toString()}, Locale.getDefault()).toString());
        }

        return PortalInformation.builder()
                .userResource(UserResourceMapper.mapWithCredentials(user))
                .build();
    }

    @Override
    public UserResource findOneByLoginId(String loginId) throws BusinessException {
        User user = userRepository.findByLoginId(loginId);
        if(Objects.isNull(user)){
            String errorCode = "BE0002";
            throw new BusinessException(errorCode, messageSource.getMessage(
                    errorCode, new String[]{loginId}, Locale.getDefault()));
        }
        return UserResourceMapper.mapWithCredentials(user);
    }

}

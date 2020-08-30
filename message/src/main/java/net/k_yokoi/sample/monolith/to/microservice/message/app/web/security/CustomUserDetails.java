package net.k_yokoi.sample.monolith.to.microservice.message.app.web.security;

import java.util.Collection;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.user.UserResource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@AllArgsConstructor
@Builder
@Data
public class CustomUserDetails implements UserDetails {

    private final UserResource userResource;
    private final Collection<GrantedAuthority> authorities;

    @Override
    public String getPassword() {
//        return "{noop}test";
        return userResource.getCredentialResources().stream()
                .filter(userResource -> Objects.equals(
                        "PASSWORD", userResource.getCredentialType()))
                .findFirst().get().getCredentialKey();
    }

    @Override
    public String getUsername() {
//        return "test";
        return userResource.getLoginId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Collection<GrantedAuthority> getAuthorities(){
        return authorities;
    }

}
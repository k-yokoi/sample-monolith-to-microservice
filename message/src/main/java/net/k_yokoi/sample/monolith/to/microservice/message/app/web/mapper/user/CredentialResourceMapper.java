package net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.user;

import java.util.List;
import java.util.stream.Collectors;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.user.CredentialResource;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.user.Credential;

public interface CredentialResourceMapper {

    public static CredentialResource map(Credential credential){
        return CredentialResource.builder()
                .userId(credential.getUserId())
                .credentialType(credential.getCredentialType())
                .credentialKey(credential.getCredentialKey())
                .validDate(credential.getValidDate())
                .build();
    }

    public static List<CredentialResource> map(List<Credential> credentials){
        return credentials.stream().map(CredentialResourceMapper::map)
                .collect(Collectors.toList());
    }

}

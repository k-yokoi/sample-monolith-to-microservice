package net.k_yokoi.sample.monolith.to.microservice.chat.common.model.user;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CredentialResource implements Serializable {

    private long userId;
    private String credentialType;
    private String credentialKey;
    private Timestamp validDate;

}

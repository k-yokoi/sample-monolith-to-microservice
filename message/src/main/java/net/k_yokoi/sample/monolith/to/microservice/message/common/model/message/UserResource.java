package net.k_yokoi.sample.monolith.to.microservice.message.common.model.message;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserResource implements Serializable {

    private long userId;
    private String firstName;
    private String familyName;
    private String displayName;
    private String imageFilePath;

}

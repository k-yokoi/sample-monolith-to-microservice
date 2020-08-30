package net.k_yokoi.sample.monolith.to.microservice.message.app.model.portal;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.user.UserResource;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PortalInformation implements Serializable {

    private UserResource userResource;

}

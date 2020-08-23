package net.k_yokoi.sample.monolith.to.microservice.chat.app.model.portal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.user.UserResource;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PortalInformation implements Serializable {

    private UserResource userResource;

}

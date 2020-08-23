package net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class UserGroupRelationPK implements Serializable {


    private long userId;

    private String groupId;

}

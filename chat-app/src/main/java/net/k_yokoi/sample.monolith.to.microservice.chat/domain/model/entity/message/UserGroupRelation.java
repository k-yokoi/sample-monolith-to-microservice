package net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Entity
@IdClass(UserGroupRelationPK.class)
public class UserGroupRelation {

    @Id
    private long userId;
    @Id
    private String groupId;
    private Date lastUpdatedAt;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}

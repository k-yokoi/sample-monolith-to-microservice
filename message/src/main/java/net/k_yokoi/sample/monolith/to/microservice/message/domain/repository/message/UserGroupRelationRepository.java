package net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message;

import java.util.List;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.UserGroupRelation;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.UserGroupRelationPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupRelationRepository
        extends JpaRepository<UserGroupRelation, UserGroupRelationPK> {

    List<UserGroupRelation> findByUserId(Long userId);

    List<UserGroupRelation> findByGroupId(String groupId);

}

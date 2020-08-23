package net.k_yokoi.sample.monolith.to.microservice.chat.domain.repository.message;

import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.UserGroupRelation;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.UserGroupRelationPK;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface UserGroupRelationRepository
        extends JpaRepository<UserGroupRelation, UserGroupRelationPK> {

    List<UserGroupRelation> findByUserId(Long userId);

    List<UserGroupRelation> findByGroupId(String groupId);

}

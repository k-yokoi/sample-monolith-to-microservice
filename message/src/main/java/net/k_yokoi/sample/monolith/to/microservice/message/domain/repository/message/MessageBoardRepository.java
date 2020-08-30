package net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message;

import java.util.List;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.MessageBoard;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.MessageBoardPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageBoardRepository extends JpaRepository<MessageBoard, MessageBoardPK> {

    List<MessageBoard> findByGroupId(String groupId);

    List<MessageBoard> findByMessageBoardId(String messageBoardId);

}

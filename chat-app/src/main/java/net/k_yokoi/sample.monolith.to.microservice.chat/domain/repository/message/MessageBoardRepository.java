package net.k_yokoi.sample.monolith.to.microservice.chat.domain.repository.message;

import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.MessageBoard;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.MessageBoardPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MessageBoardRepository extends JpaRepository<MessageBoard, MessageBoardPK> {

    List<MessageBoard> findByGroupId(String groupId);

    List<MessageBoard> findByMessageBoardId(String messageBoardId);

}

package net.k_yokoi.sample.monolith.to.microservice.chat.domain.repository.message;

import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.Message;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.MessagePK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, MessagePK> {

    List<Message> findByMessageBoardId(String messageBoardId);

}

package net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message;

import java.util.List;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.Message;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.MessagePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, MessagePK> {

    List<Message> findByMessageBoardId(String messageBoardId);

}

package net.k_yokoi.sample.monolith.to.microservice.chat.app.model.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.UserResource;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.User;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Message {

    private String messageBoardId;
    private UserResource userResource;
    private String comment;

}

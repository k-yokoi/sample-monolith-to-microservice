package net.k_yokoi.sample.monolith.to.microservice.message.app.model.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.UserResource;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Message {

    private String messageBoardId;
    private UserResource userResource;
    private String comment;

}

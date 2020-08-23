package net.k_yokoi.sample.monolith.to.microservice.chat.app.model.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.MessageBoardResource;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatPortalInformation {

    private List<MessageBoardResource> messageBoardResources;

}

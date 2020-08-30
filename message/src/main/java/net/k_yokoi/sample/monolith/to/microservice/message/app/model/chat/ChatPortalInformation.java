package net.k_yokoi.sample.monolith.to.microservice.message.app.model.chat;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.MessageBoardResource;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatPortalInformation {

    private List<MessageBoardResource> messageBoardResources;

}

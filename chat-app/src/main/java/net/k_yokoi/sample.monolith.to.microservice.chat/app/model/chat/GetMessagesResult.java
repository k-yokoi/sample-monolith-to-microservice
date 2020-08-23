package net.k_yokoi.sample.monolith.to.microservice.chat.app.model.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.MessageResource;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GetMessagesResult {

    List<MessageResource> messageResources;

}

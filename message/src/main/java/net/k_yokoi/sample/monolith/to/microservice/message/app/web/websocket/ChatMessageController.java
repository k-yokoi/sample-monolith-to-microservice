package net.k_yokoi.sample.monolith.to.microservice.message.app.web.websocket;

import java.util.List;
import net.k_yokoi.sample.monolith.to.microservice.message.app.model.chat.Message;
import net.k_yokoi.sample.monolith.to.microservice.message.app.model.chat.MessageMapper;
import net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.UserResource;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.service.chat.ChatOrchestrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ChatMessageController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    ChatOrchestrationService chatOrchestrationService;

    @MessageMapping("/messages/{messageBoardId}")
    public void addMessageAndPushToSubsribers(
            @DestinationVariable String messageBoardId,
            @RequestBody Message message){
        System.out.println("websocket");
        chatOrchestrationService.postMessage(
                MessageMapper.mapToResource(message));
        try{
            List<UserResource> userResources = chatOrchestrationService
                    .getUsersBelongToGroupRelatedMessageBoard(messageBoardId);

            message.setUserResource(chatOrchestrationService
                    .getUser(Long.toString(
                            message.getUserResource().getUserId())));
            String imageKey = message.getUserResource().getImageFilePath();
            String imageUrl = "static/img/" + imageKey;
            message.getUserResource().setImageFilePath(imageUrl);
            userResources.stream().forEach(userResource -> {
                simpMessagingTemplate.convertAndSend(
                        new StringBuilder()
                                .append("/topic/user-")
                        .append(userResource.getUserId())
                        .toString(), message);
            });
        } catch (BusinessException e){
            // No operations.
        }
    }

}

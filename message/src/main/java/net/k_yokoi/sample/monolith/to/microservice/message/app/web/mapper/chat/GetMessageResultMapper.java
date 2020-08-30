package net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.chat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.k_yokoi.sample.monolith.to.microservice.message.app.model.chat.GetMessagesResult;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.MessageResource;
import org.springframework.stereotype.Component;

@Component
public class GetMessageResultMapper {

        public GetMessagesResult map(List<MessageResource> messageResources){
        Map<String, String> presignedUrlCache = new HashMap<>();
        return GetMessagesResult.builder()
                .messageResources(messageResources.stream()
                        .map(messageResource -> {
                            String imageKey = messageResource
                                    .getUserResource().getImageFilePath();
                            String imageUrl = "static/img/" + imageKey;
                            messageResource.getUserResource()
                                    .setImageFilePath(imageUrl);
                            return  messageResource;
                        })
                        .collect(Collectors.toList()))
                .build();
    }

}

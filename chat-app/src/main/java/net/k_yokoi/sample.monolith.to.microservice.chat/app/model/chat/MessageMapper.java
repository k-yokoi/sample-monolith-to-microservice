package net.k_yokoi.sample.monolith.to.microservice.chat.app.model.chat;

import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.MessageResource;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.UserResource;

public interface MessageMapper {

    public static MessageResource mapToResource(Message message){
        return MessageResource.builder()
                .messageBoardId(message.getMessageBoardId())
                .userResource(UserResource.builder()
                        .userId(Long.valueOf(message.getUserResource().getUserId()))
                        .build())
                .comment(message.getComment())
                .build();
    }




}

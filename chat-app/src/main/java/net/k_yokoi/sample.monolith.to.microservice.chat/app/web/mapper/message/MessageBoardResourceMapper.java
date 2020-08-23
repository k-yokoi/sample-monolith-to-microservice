package net.k_yokoi.sample.monolith.to.microservice.chat.app.web.mapper.message;

import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.MessageBoardResource;

import java.util.List;
import java.util.stream.Collectors;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.MessageBoard;

public interface MessageBoardResourceMapper {

    public static MessageBoardResource map(MessageBoard messageBoard){
        return MessageBoardResource.builder()
                .messageBoardId(messageBoard.getMessageBoardId())
                .groupId(messageBoard.getGroupId())
                .title(messageBoard.getTitle())
                .build();
    }

    public static List<MessageBoardResource> map(List<MessageBoard> messageBoardResources){
        return messageBoardResources.stream().map(
                MessageBoardResourceMapper::map).collect(Collectors.toList());
    }

}

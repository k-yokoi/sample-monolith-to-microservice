package net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.message;

import java.util.List;
import java.util.stream.Collectors;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.MessageBoardResource;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.MessageBoard;

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

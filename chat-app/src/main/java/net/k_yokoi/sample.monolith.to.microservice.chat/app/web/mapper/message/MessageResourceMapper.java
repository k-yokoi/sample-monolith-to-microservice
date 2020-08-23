package net.k_yokoi.sample.monolith.to.microservice.chat.app.web.mapper.message;

import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message.MessageResource;

import java.util.List;
import java.util.stream.Collectors;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.dto.MessageDTO;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.Message;

public interface MessageResourceMapper {

    public static MessageResource map(MessageDTO messageDTO) {
        return MessageResource.builder()
                .messageBoardId(messageDTO.getMessage().getMessageBoardId())
                .createdAt(messageDTO.getMessage().getCreatedAt())
                .comment(messageDTO.getMessage().getComment())
                .userResource(UserResourceMapper.map(messageDTO.getUser()))
                .imagePath(messageDTO.getMessage().getImagePath())
                .videoPath(messageDTO.getMessage().getVideoPath())
                .likeCount(messageDTO.getMessage().getLikeCount())
                .build();
    }

    public static List<MessageResource> map(List<MessageDTO> messageDTOList){
        return messageDTOList.stream().map(MessageResourceMapper::map)
                .collect(Collectors.toList());
    }

    public static Message mapToEntity(MessageResource messageResource){
        return Message.builder()
                .messageBoardId(messageResource.getMessageBoardId())
                .createdAt(messageResource.getCreatedAt())
                .comment(messageResource.getComment())
                .userId(messageResource.getUserResource().getUserId())
                .imagePath(messageResource.getImagePath())
                .videoPath(messageResource.getVideoPath())
                .likeCount(messageResource.getLikeCount())
                .build();
    }

}


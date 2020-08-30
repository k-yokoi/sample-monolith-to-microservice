package net.k_yokoi.sample.monolith.to.microservice.message.domain.service.chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.message.MessageBoardResourceMapper;
import net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.message.MessageResourceMapper;
import net.k_yokoi.sample.monolith.to.microservice.message.app.web.mapper.message.UserResourceMapper;
import net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.util.DateUtils;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.MessageBoardResource;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.MessageResource;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.UserResource;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.dto.MessageDTO;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.Message;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.MessageBoard;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.User;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.UserGroupRelation;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message.MessageBoardRepository;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message.MessageRepository;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message.UserGroupRelationRepository;
import net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChatOrchestrationServiceImpl implements ChatOrchestrationService {

    @Autowired
    MessageBoardRepository messageBoardRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserGroupRelationRepository userGroupRelationRepository;

    @Override
    public List<MessageBoardResource> getMessageBoardResources(String userId) {
        List<UserGroupRelation> userGroupRelations =
                userGroupRelationRepository.findByUserId(Long.valueOf(userId));
        List<MessageBoard> messageBoards = new ArrayList<>();
        userGroupRelations.stream().forEach(userGroupRelation ->{
            messageBoards.addAll(messageBoardRepository.findByGroupId(
                    userGroupRelation.getGroupId()
            ));
        });
        return MessageBoardResourceMapper.map(messageBoards);
    }

    @Override
    public List<MessageResource> getMessageResources(
        String messageBoardId) throws BusinessException {
        List<Message> messages = messageRepository.findByMessageBoardId(messageBoardId);
        Map<Long, Optional<User>> userCache = new HashMap<>();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        messages.stream().forEach(message -> {
            Optional<User> optionalUser;
            if(userCache.containsKey(message.getUserId())){
                optionalUser = userCache.get(message.getUserId());
            }else {
                optionalUser = userRepository.findById(message.getUserId());
                if(optionalUser.isPresent()){
                    userCache.put(message.getUserId(), optionalUser);
                }else {
                    Optional<User> anonymous = Optional.of(
                            User.builder().displayName("Anonymous").build());
                    userCache.put(message. getUserId(), anonymous);
                }
            }
            messageDTOList.add(MessageDTO.builder()
                    .message(message).user(optionalUser.get()).build());
        });
        return MessageResourceMapper.map(messageDTOList);
    }

    @Override
    public MessageResource postMessage(MessageResource messageResource) {
        Message message = MessageResourceMapper.mapToEntity(messageResource);
        message.setMessageBoardId(message.getMessageBoardId());
        message.setCreatedAt(DateUtils.now());
        message.setComment(message.getComment());
        message.setUserId(message.getUserId());
        message.setImagePath(message.getImagePath());
        message.setVideoPath(message.getVideoPath());
        message.setLastUpdatedAt(DateUtils.nowDate());
        messageRepository.save(message);

        return MessageResourceMapper.map(MessageDTO.builder().message(message)
                .user(userRepository.findById(message.getUserId()).get())
                .build());
    }

    @Override
    public List<UserResource> getUsersBelongToGroupRelatedMessageBoard(
            String messageBoardId) throws BusinessException{
        List<MessageBoard> optionalMessageBoard =
                messageBoardRepository.findByMessageBoardId(messageBoardId);
        List<User> users = new ArrayList<>();
        if(!optionalMessageBoard.isEmpty()){
            List<UserGroupRelation> userGroupRelations =
                    userGroupRelationRepository.findByGroupId(
                            optionalMessageBoard.get(0).getGroupId());
            // TODO : Use Map instead of many queries.
            userGroupRelations.stream().forEach(userGroupRelation -> {
                users.add(userRepository.findById(userGroupRelation.getUserId()).get());
            });
        }else throw new BusinessException("BE0001",messageBoardId);
        return UserResourceMapper.map(users);
    }

    @Override
    public UserResource getUser(String userId) throws BusinessException{
        Optional<User> optionalUser = userRepository.findById(Long.parseLong(userId));
        if(optionalUser.isPresent()){
            return UserResourceMapper.map(optionalUser.get());
        }else throw new BusinessException("BE0002", userId.toString());
    }

}

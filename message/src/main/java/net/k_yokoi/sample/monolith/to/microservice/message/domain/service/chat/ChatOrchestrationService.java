package net.k_yokoi.sample.monolith.to.microservice.message.domain.service.chat;

import java.util.List;
import net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.MessageBoardResource;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.MessageResource;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.message.UserResource;

public interface ChatOrchestrationService {

    public List<MessageBoardResource>
        getMessageBoardResources(String userId);

    public List<MessageResource> getMessageResources(
            String messageBoardId) throws BusinessException;

    public MessageResource postMessage(MessageResource messageResource);

    public List<UserResource> getUsersBelongToGroupRelatedMessageBoard(
            String messageBoardId) throws BusinessException;

    public UserResource getUser(String userId) throws BusinessException;

}

package net.k_yokoi.sample.monolith.to.microservice.chat.domain.service.portal;

import net.k_yokoi.sample.monolith.to.microservice.chat.app.model.portal.PortalInformation;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.chat.common.model.user.UserResource;

public interface PortalOrchestrationService {

    public PortalInformation getPortalInformation(String userId);

    UserResource findOneByLoginId(String userName) throws BusinessException;
}

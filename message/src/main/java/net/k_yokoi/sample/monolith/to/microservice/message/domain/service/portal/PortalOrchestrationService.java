package net.k_yokoi.sample.monolith.to.microservice.message.domain.service.portal;

import net.k_yokoi.sample.monolith.to.microservice.message.app.model.portal.PortalInformation;
import net.k_yokoi.sample.monolith.to.microservice.message.common.apinfra.exception.BusinessException;
import net.k_yokoi.sample.monolith.to.microservice.message.common.model.user.UserResource;

public interface PortalOrchestrationService {

    public PortalInformation getPortalInformation(String userId);

    UserResource findOneByLoginId(String userName) throws BusinessException;
}

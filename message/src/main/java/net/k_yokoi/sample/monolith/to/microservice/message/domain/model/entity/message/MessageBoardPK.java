package net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class MessageBoardPK implements Serializable {

    private String messageBoardId;
    private String groupId;
}

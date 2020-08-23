package net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message;

import java.io.Serializable;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Embeddable
public class MessagePK implements Serializable {


    private String messageBoardId;

    private String createdAt;

}

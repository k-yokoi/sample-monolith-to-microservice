package net.k_yokoi.sample.monolith.to.microservice.message.common.model.message;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MessageBoardResource implements Serializable {

    private String messageBoardId;
    private String groupId;
    private String title;

}

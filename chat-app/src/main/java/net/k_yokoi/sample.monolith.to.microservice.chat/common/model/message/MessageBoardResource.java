package net.k_yokoi.sample.monolith.to.microservice.chat.common.model.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MessageBoardResource implements Serializable {

    private String messageBoardId;
    private String groupId;
    private String title;

}

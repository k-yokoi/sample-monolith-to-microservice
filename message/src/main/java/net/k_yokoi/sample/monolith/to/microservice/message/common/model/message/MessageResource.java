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
public class MessageResource implements Serializable {

    private String messageBoardId;
    private String createdAt;
    private String comment;
    private String imagePath;
    private String videoPath;
    private int likeCount;
    private UserResource userResource;

}

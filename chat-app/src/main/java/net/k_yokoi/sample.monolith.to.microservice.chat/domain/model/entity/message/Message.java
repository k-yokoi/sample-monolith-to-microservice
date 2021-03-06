package net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@IdClass(MessagePK.class)
public class Message implements Serializable {

    @Id
    private String messageBoardId;
    @Id
    private String createdAt;
    private String comment;
    private long userId;
    private String imagePath;
    private String videoPath;
    private int likeCount;
    private Date lastUpdatedAt;

    public String getMessageBoardId() {
        return messageBoardId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

}

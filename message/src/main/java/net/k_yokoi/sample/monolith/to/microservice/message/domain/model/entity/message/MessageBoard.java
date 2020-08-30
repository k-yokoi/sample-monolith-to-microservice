package net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@IdClass(MessageBoardPK.class)
public class MessageBoard implements Serializable {

    @Id
    private String messageBoardId;
    @Id
    private String groupId;
    private String title;
    private Date lastUpdatedAt;

}

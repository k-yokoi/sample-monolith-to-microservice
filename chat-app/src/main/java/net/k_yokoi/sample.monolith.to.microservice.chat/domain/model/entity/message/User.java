package net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User implements Serializable {

    @Id
    private Long userId;
    private String firstName;
    private String familyName;
    private String displayName;
    private String imageFilePath;
    private Date lastUpdatedAt;

}

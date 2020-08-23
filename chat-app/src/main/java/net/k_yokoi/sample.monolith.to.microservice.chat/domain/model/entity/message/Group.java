package net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Entity
@Table(name = "GROUP_TABLE")
public class Group implements Serializable {

    @Id
    private String groupId;
    private String groupName;
    private Date lastUpdatedAt;

}

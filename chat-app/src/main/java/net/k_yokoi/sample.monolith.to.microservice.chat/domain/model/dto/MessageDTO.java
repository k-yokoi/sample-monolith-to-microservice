package net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.Message;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.User;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MessageDTO {

    private Message message;
    private User user;

}
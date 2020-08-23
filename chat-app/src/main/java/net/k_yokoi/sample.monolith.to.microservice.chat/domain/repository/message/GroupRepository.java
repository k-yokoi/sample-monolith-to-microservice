package net.k_yokoi.sample.monolith.to.microservice.chat.domain.repository.message;


import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, String> {
}

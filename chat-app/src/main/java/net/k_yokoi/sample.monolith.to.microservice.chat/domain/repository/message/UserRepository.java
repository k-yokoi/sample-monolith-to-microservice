package net.k_yokoi.sample.monolith.to.microservice.chat.domain.repository.message;

import java.util.List;
import net.k_yokoi.sample.monolith.to.microservice.chat.domain.model.entity.message.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

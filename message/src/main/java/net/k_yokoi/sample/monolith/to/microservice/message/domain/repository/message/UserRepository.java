package net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.message;

import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.message.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

package net.k_yokoi.sample.monolith.to.microservice.message.domain.repository.user;

import net.k_yokoi.sample.monolith.to.microservice.message.domain.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CredentialUserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM usr u LEFT JOIN FETCH u.credentialsByUserId where u.userId = :userId")
    User findByUserId(@Param("userId") long userId);

    @Query("SELECT u FROM usr u LEFT JOIN FETCH u.credentialsByUserId where u.loginId = :loginId")
    User findByLoginId(@Param("loginId") String loginId);

}

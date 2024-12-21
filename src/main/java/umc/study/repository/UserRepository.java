package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.common.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

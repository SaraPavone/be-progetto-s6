package sarapavo.be_progetto_s6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sarapavo.be_progetto_s6.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}

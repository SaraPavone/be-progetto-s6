package sarapavo.be_progetto_s6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sarapavo.be_progetto_s6.entities.Roles;
import sarapavo.be_progetto_s6.entities.User;

import java.util.List;
import java.util.Optional;


public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findByRole(Roles role);
}

package sarapavo.be_progetto_s6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sarapavo.be_progetto_s6.entities.Event;
import sarapavo.be_progetto_s6.entities.Reservation;
import sarapavo.be_progetto_s6.entities.User;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);

    List<Reservation> findByEvent(Event event);

    long countByEvent(Event event);
}

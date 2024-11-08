package sarapavo.be_progetto_s6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sarapavo.be_progetto_s6.entities.Event;
import sarapavo.be_progetto_s6.entities.User;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByOrganizer(User organizer);

    List<Event> findByNumberOfPeopleGreaterThan(int numberOfPeople);
}

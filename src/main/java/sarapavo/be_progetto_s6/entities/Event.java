package sarapavo.be_progetto_s6.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String title;
    private String description;
    private Date date;
    private String location;
    private int numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "organizerId")
    private User user;

    public Event(User user, int numberOfPeople, String location, Date date, String description, String title) {
        this.user = user;
        this.numberOfPeople = numberOfPeople;
        this.location = location;
        this.date = date;
        this.description = description;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", user=" + user +
                '}';
    }
}

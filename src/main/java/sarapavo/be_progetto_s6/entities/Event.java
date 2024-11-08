package sarapavo.be_progetto_s6.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;
    private String title;
    private String description;
    private Date date;
    private String location;
    private int numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private User organizer;

    public Event(@NotEmpty(message = "Il titolo è obbligatorio!") @Size(min = 2, max = 40, message = "Il titolo deve essere compreso tra 2 e 40 caratteri!") String organizer, @NotEmpty(message = "La descrizione è obbligatoria!") @Size(min = 2, max = 300, message = "La descrizione deve essere compresa tra 2 e 300 caratteri!") String numberOfPeople, @NotEmpty(message = "La data é obbligatioria!") @Email(message = "La data inserita non è valida") Date location, @NotEmpty(message = "La location è obbligatoria!") @Size(min = 2, max = 40, message = "Il nome della location deve essere compreso tra 2 e 40 caratteri!") String date, @NotEmpty(message = "Il numero massimo di partecipanti è obbligatorio!") int description, @NotEmpty(message = "l'id dell'organizzatore è obbligatorio!") User title) {
        this.organizer = organizer;
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
                ", user=" + +
                '}';
    }
}

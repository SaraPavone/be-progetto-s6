package sarapavo.be_progetto_s6.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import sarapavo.be_progetto_s6.entities.User;

import java.util.Date;

public record NewEventDTO(
        @NotEmpty(message = "Il titolo è obbligatorio!")
        @Size(min = 2, max = 40, message = "Il titolo deve essere compreso tra 2 e 40 caratteri!")
        String title,

        @NotEmpty(message = "La descrizione è obbligatoria!")
        @Size(min = 2, max = 300, message = "La descrizione deve essere compresa tra 2 e 300 caratteri!")
        String description,

        @NotEmpty(message = "La data é obbligatioria!")
        @Email(message = "La data inserita non è valida")
        Date date,

        @NotEmpty(message = "La location è obbligatoria!")
        @Size(min = 2, max = 40, message = "Il nome della location deve essere compreso tra 2 e 40 caratteri!")
        String location,

        @NotEmpty(message = "Il numero massimo di partecipanti è obbligatorio!")
        int numberOfPeople,

        @NotEmpty(message = "l'id dell'organizzatore è obbligatorio!")
        User organizerId
) {
}

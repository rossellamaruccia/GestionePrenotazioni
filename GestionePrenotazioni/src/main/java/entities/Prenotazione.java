package entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "utente_id")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    private LocalDate data_prenotazione;
    private LocalDate data_fine_prenotazione;

    public Prenotazione() {
    }

    public Prenotazione(Utente utente, Postazione postazione) {
        this.utente = utente;
        this.postazione = postazione;
        //TODO: aggiungere controlli sulle date di prenotazione
        this.data_prenotazione = LocalDate.now();
        this.data_fine_prenotazione = data_prenotazione.plusDays(1);
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", utente=" + utente +
                ", postazione=" + postazione +
                ", data_prenotazione=" + data_prenotazione +
                ", data_fine_prenotazione=" + data_fine_prenotazione +
                '}';
    }
}

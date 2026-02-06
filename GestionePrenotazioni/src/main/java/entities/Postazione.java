package entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Postazione {
    @OneToMany(mappedBy = "postazione_id")
    List<Prenotazione> prenotazioni;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    private tipoPostazione tipoPostazione;
    private int nMaxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;

    public Postazione() {
    }

    public Postazione(tipoPostazione tipoPostazione, int nMaxOccupanti, Edificio edificio) {
        this.tipoPostazione = tipoPostazione;
        this.nMaxOccupanti = nMaxOccupanti;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione{" +
                "id=" + id +
                ", descrizione='" + descrizione + '\'' +
                ", tipoPostazione=" + tipoPostazione +
                ", nMaxOccupanti=" + nMaxOccupanti +
                ", edificio=" + edificio +
                '}';
    }
}

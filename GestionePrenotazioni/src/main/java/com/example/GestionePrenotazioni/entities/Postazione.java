package com.example.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
public class Postazione {
    @OneToMany(mappedBy = "postazione")
    List<Prenotazione> prenotazioni;
    //se nella lista prenotazioni di una postazione c'è una prenotazione con data = LocalDate.now allora la postazione è occupata
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private tipoPostazione tipoPostazione;
    private int nMaxOccupanti;
    @ManyToOne
    @JoinColumn(name = "edificio")
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

package com.example.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @ManyToOne
    @JoinColumn(name = "utente")
    private Utente utente;
    @ManyToOne
    @JoinColumn(name = "postazione")
    private Postazione postazione;

    private LocalDate dataPrenotazione;

    public Prenotazione() {
    }

    public Prenotazione(Utente utente, Postazione postazione) {
        this.utente = utente;
        this.postazione = postazione;
        //TODO: aggiungere controlli sulle date di prenotazione
        this.dataPrenotazione = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", utente=" + utente +
                ", postazione=" + postazione +
                ", data_prenotazione=" + dataPrenotazione +
                '}';
    }
}

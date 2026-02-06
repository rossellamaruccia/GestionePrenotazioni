package com.example.GestionePrenotazioni.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "utenti")
@Getter
@Setter
public class Utente {
    @OneToMany(mappedBy = "utente")
    List<Prenotazione> prenotazioni;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    private String username;
    private String nome_completo;
    private String email;

    public Utente() {
    }

    public Utente(String username, String nome_completo, String email) {
        this.username = username;
        this.nome_completo = nome_completo;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nome_completo='" + nome_completo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Utente;
import com.example.GestionePrenotazioni.repositories.UtenteRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    private UtenteRep utenteRep;

    @Autowired
    public UtenteService(UtenteRep utenteRep) {
        this.utenteRep = utenteRep;
    }

    public void save(Utente utente) {
        utenteRep.save(utente);
    }
}

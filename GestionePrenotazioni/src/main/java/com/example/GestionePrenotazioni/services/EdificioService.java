package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Edificio;
import com.example.GestionePrenotazioni.repositories.EdificioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EdificioService {
    private EdificioRep edificioRep;

    @Autowired
    public EdificioService(EdificioRep edificioRep) {
        this.edificioRep = edificioRep;
    }

    public void save(Edificio edificio) {
        edificioRep.save(edificio);
    }

}

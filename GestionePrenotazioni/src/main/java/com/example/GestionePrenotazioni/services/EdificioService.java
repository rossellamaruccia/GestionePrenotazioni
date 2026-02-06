package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Edificio;
import com.example.GestionePrenotazioni.repositories.EdificioRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
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

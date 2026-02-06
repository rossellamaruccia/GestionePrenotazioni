package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.repositories.PrenotazioneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    private PrenotazioneRep prenotazioneRep;

    @Autowired
    public PrenotazioneService(PrenotazioneRep prenotazioneRep) {
        this.prenotazioneRep = prenotazioneRep;
    }
}

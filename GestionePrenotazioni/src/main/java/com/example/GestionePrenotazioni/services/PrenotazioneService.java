package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Prenotazione;
import com.example.GestionePrenotazioni.exceptions.NotPossibleException;
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

    public void save(Prenotazione prenotazione) {
        if (!prenotazioneRep.existsByPostazioneAndDataPrenotazione(prenotazione.getPostazione(), prenotazione.getDataPrenotazione()) ||
                !prenotazioneRep.existsByUtenteAndDataPrenotazione(prenotazione.getUtente(), prenotazione.getDataPrenotazione())) {
            prenotazioneRep.save(prenotazione);
        } else {
            throw new NotPossibleException(prenotazione);
        }
    }
}

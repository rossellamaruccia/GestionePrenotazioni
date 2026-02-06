package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Postazione;
import com.example.GestionePrenotazioni.entities.Prenotazione;
import com.example.GestionePrenotazioni.exceptions.NotPossibleException;
import com.example.GestionePrenotazioni.repositories.PostazioneRep;
import com.example.GestionePrenotazioni.repositories.PrenotazioneRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {
    private PrenotazioneRep prenotazioneRep;
    private PostazioneRep postazioneRep;

    @Autowired
    public PrenotazioneService(PrenotazioneRep prenotazioneRep, PostazioneRep postazioneRep) {
        this.prenotazioneRep = prenotazioneRep;
        this.postazioneRep = postazioneRep;
    }

    public void save(Prenotazione prenotazione) {
        if (!prenotazioneRep.existsByPostazioneAndDataPrenotazione(prenotazione.getPostazione(), prenotazione.getDataPrenotazione()) ||
                !prenotazioneRep.existsByUtenteAndDataPrenotazione(prenotazione.getUtente(), prenotazione.getDataPrenotazione()) ||
                this.controllaData(prenotazione)) {
            prenotazioneRep.save(prenotazione);
            System.out.println("Prenotazione salvata correttamente");
        } else {
            throw new NotPossibleException(prenotazione);
        }
    }

    public boolean controllaData(Prenotazione prenotazione) {
        Postazione posto = prenotazione.getPostazione();
        List<Prenotazione> listaPrenotazioni = posto.getPrenotazioni();
        for (Prenotazione prenotazione1 : listaPrenotazioni) {
            if (prenotazione.getDataPrenotazione().equals(prenotazione1.getDataPrenotazione())) {
                return true;
            }
        }
        return false;
    }
}

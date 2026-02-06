package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.entities.Postazione;
import com.example.GestionePrenotazioni.exceptions.NotFoundException;
import com.example.GestionePrenotazioni.repositories.PostazioneRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class PostazioneService {
    private PostazioneRep postazioneRep;

    @Autowired
    public PostazioneService(PostazioneRep postazioneRep) {
        this.postazioneRep = postazioneRep;
    }

    public void save(Postazione postazione) {
        postazioneRep.save(postazione);
    }

    public void modificaDescrizione(Long id, String nuova_desc) {
        Optional<Postazione> selected = postazioneRep.findById(id);

        if ((selected.isPresent())) {
            Postazione post = selected.get();
            post.setDescrizione(nuova_desc);
            postazioneRep.save(post);
        } else {
            throw new NotFoundException("postazione non trovata");
        }
    }
}

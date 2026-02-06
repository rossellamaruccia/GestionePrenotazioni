package com.example.GestionePrenotazioni.services;

import com.example.GestionePrenotazioni.repositories.PostazioneRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PostazioneService {
    private PostazioneRep postazioneRep;

    @Autowired
    public PostazioneService(PostazioneRep postazioneRep) {
        this.postazioneRep = postazioneRep;
    }

}

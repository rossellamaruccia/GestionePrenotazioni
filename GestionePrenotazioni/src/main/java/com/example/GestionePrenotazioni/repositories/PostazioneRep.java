package com.example.GestionePrenotazioni.repositories;

import com.example.GestionePrenotazioni.entities.Postazione;
import com.example.GestionePrenotazioni.entities.tipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRep extends JpaRepository<Postazione, Long> {

    List<Postazione> findByTipoPostazioneAndEdificio(tipoPostazione tipo, String edificio);
}

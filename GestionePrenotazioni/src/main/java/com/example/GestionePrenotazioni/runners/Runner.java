package com.example.GestionePrenotazioni.runners;

import com.example.GestionePrenotazioni.GestionePrenotazioniApplication;
import com.example.GestionePrenotazioni.entities.Postazione;
import com.example.GestionePrenotazioni.entities.Prenotazione;
import com.example.GestionePrenotazioni.entities.Utente;
import com.example.GestionePrenotazioni.exceptions.NotFoundException;
import com.example.GestionePrenotazioni.services.EdificioService;
import com.example.GestionePrenotazioni.services.PostazioneService;
import com.example.GestionePrenotazioni.services.PrenotazioneService;
import com.example.GestionePrenotazioni.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private final EdificioService edificioService;
    private final UtenteService utenteService;
    private final PrenotazioneService prenotazioneService;
    private final PostazioneService postazioneService;

    public Runner(EdificioService edificioService, UtenteService utenteService, PrenotazioneService prenotazioneService, PostazioneService postazioneService) {
        this.edificioService = edificioService;
        this.utenteService = utenteService;
        this.prenotazioneService = prenotazioneService;
        this.postazioneService = postazioneService;
    }

    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniApplication.class);
        try {
//            Edificio pdc = (Edificio) ctx.getBean("palazzoDellaCarovana");
//            Edificio pdcg = (Edificio) ctx.getBean("palazzoDeiCongressi");
//            Edificio ar = (Edificio) ctx.getBean("anfiteatroRomano");
//            edificioService.save(pdc);
//            edificioService.save(pdcg);
//            edificioService.save(ar);
//
//            Postazione small = (Postazione) ctx.getBean("small");
//            postazioneService.save(small);
//
//            Postazione medium = (Postazione) ctx.getBean("medium");
//            postazioneService.save(medium);
//
            Postazione big = (Postazione) ctx.getBean("big");
//            postazioneService.save(big);
//
            Utente rosmaru = (Utente) ctx.getBean("rosmaru");
//            utenteService.save(rosmaru);
//
//            Utente alesmaru = (Utente) ctx.getBean("alesmaru");
//            utenteService.save(alesmaru);
//
//            Utente miri = (Utente) ctx.getBean("miri");
//            utenteService.save(miri);
//
//            Prenotazione p1 = new Prenotazione(miri, big);
//            prenotazioneService.save(p1);

            //provo controllo sulla postazione
            Prenotazione p2 = new Prenotazione(rosmaru, big);
            prenotazioneService.save(p2);


        } catch (NotFoundException e) {
            System.err.println(e.getMessage());
        } finally {
            ctx.close();
        }
    }
}

package com.example.GestionePrenotazioni.entities;

import com.example.GestionePrenotazioni.repositories.EdificioRep;
import com.example.GestionePrenotazioni.repositories.PostazioneRep;
import com.example.GestionePrenotazioni.repositories.UtenteRep;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {
    private EdificioRep edificioRep;
    private UtenteRep utenteRep;
    private PostazioneRep postazioneRep;

    AppConfig(EdificioRep edificioRep, UtenteRep utenteRep, PostazioneRep postazioneRep) {
        this.edificioRep = edificioRep;
        this.utenteRep = utenteRep;
        this.postazioneRep = postazioneRep;
    }

    @Primary
    @Bean
    public Edificio palazzoDellaCarovana() {
        return new Edificio("Palazzo della Carovana", "piazza dei Cavalieri 1", "Pisa");
    }

    @Primary
    @Bean
    public Postazione small() {
        Edificio pdc = edificioRep.findByNome("Palazzo della Carovana");
        return new Postazione(tipoPostazione.PRIVATO, 50, pdc);
    }

    @Bean
    public Edificio palazzoDeiCongressi() {
        return new Edificio("Palazzo dei Congressi", "via Giacomo Matteotti 1", "Pisa");
    }


    @Bean
    public Postazione medium() {
        Edificio pdcg = edificioRep.findByNome("Palazzo dei Congressi");
        return new Postazione(tipoPostazione.SALA_RIUNIONI, 100, pdcg);
    }

    @Bean
    public Edificio anfiteatroRomano() {
        return new Edificio("Anfiteatro Romano", "Piazza Sant'Oronzo", "Lecce");
    }


    @Bean
    public Postazione big() {
        Edificio ar = edificioRep.findByNome("Anfiteatro Romano");
        return new Postazione(tipoPostazione.OPEN_SPACE, 350, ar);
    }

    @Primary
    @Bean
    public Utente rosmaru() {
        return new Utente("rosmaru", "Rossella Maruccia", "rosmaru@email.com");
    }

    @Bean
    public Utente alesmaru() {
        return new Utente("alesmaru", "Alessandro Maruccia", "alesmaru@email.com");
    }

    @Bean
    public Utente miri() {
        return new Utente("miri", "Miriam Torregrossa", "miritorre@email.com");
    }


    @Primary
    @Bean
    public Prenotazione p3() {
        Utente rosmaru = utenteRep.findByUsername("rosmaru");
        Postazione posto = postazioneRep.findByNMaxOccupanti(50);
        return new Prenotazione(rosmaru, posto);
    }
}

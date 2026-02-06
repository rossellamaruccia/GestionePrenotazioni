package com.example.GestionePrenotazioni.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Primary
    @Bean
    public Edificio palazzoDellaCarovana() {
        return new Edificio("Palazzo della Carovana", "piazza dei Cavalieri 1", "Pisa");
    }

    @Primary
    @Bean
    public Postazione small() {
        return new Postazione(tipoPostazione.PRIVATO, 50, palazzoDellaCarovana());
    }

    @Bean
    public Edificio palazzoDeiCongressi() {
        return new Edificio("Palazzo dei Congressi", "via Giacomo Matteotti 1", "Pisa");
    }


    @Bean
    public Postazione medium() {
        return new Postazione(tipoPostazione.SALA_RIUNIONI, 100, palazzoDeiCongressi());
    }

    @Bean
    public Edificio anfiteatroRomano() {
        return new Edificio("Anfiteatro Romano", "Piazza Sant'Oronzo", "Lecce");
    }


    @Bean
    public Postazione big() {
        return new Postazione(tipoPostazione.OPEN_SPACE, 350, anfiteatroRomano());
    }

}

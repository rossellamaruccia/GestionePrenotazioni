package com.example.GestionePrenotazioni.exceptions;

import com.example.GestionePrenotazioni.entities.Prenotazione;

public class NotPossibleException extends RuntimeException {
    public NotPossibleException(Prenotazione prenotazione) {
        super(
                "Non è possibile effettuare la prenotazione."
        );
    }
}

package it.unicam.cs.ids2223.programmafedelta.model.utenti;

public enum TipoUtente {

    /**
     * Utente amministratore
     */
    AMMINISTRATORE(0),

    /**
     * Utente cliente
     */
    CLIENTE(1),

    /**
     * Utente cassiere
     */
    CASSIERE(2),

    /**
     * Utente manager
     */
    MANAGER(3),

    /**
     * Utente proprietario
     */
    PROPRIETARIO(4);

    private final int codice;

    TipoUtente(int codice){
        this.codice = codice;
    }

    public int getCodice(){
        return codice;
    }
}

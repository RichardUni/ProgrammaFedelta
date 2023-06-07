package it.unicam.cs.ids2223.programmafedelta.model.utenti;

/**
 * Elenco dei tipi di utente presenti nel sistema
 */

public enum TipoUtente {

    /**
     * Utente amministratore.
     */
    AMMINISTRATORE(0),

    /**
     * Utente cliente.
     */
    CLIENTE(1),

    /**
     * Utente cassiere.
     */
    CASSIERE(2),

    /**
     * Utente proprietario.
     */

    PROPRIETARIO(3),

    /**
     * Utente manager.
     */

    MANAGER (4);

    private final int code;

    TipoUtente(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TipoUtente cercaTipoUtente(int uCode){
        switch (uCode){
            case 0 : return TipoUtente.AMMINISTRATORE;
            case 1 : return TipoUtente.CLIENTE;
            case 2 : return TipoUtente.CASSIERE;
            case 3 : return TipoUtente.PROPRIETARIO;
            case 4 : return TipoUtente.MANAGER;
            default: return null;
        }
    }
}

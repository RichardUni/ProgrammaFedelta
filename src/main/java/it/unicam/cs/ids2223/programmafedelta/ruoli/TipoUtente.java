package it.unicam.cs.ids2223.programmafedelta.ruoli;

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

    public static TipoUtente cercaTipoUtente(int codiceUtente){
        switch (codiceUtente){
            case 0 : return AMMINISTRATORE;
            case 1 : return CLIENTE;
            case 2 : return CASSIERE;
            case 3 : return PROPRIETARIO;
            case 4 : return MANAGER;
            default: return null;
        }
    }
}

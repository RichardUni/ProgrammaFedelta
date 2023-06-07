package it.unicam.cs.ids2223.programmafedelta.ruoli;

/**
 * Enum dei vari tipi di utente autenticati nella piattaforma
 */
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
    public static TipoUtente cercaTipoUtente(int codice){
        switch (codice){
            case 0 : return TipoUtente.AMMINISTRATORE;
            case 1 : return TipoUtente.CLIENTE;
            case 2 : return TipoUtente.CASSIERE;
            case 3: return TipoUtente.MANAGER;
            case 4: return TipoUtente.PROPRIETARIO;
            default: return null;
        }
    }

}

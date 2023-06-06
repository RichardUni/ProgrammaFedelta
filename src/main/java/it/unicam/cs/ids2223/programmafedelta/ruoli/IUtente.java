package it.unicam.cs.ids2223.programmafedelta.ruoli;

/**
 * Interfaccia per l'utente autenticato nel sistema
 */

public interface IUtente {
    /**
     * Permette di ottenere lo username dell'utente autenticato.
     * @return username dell'utente autenticato.
     */
    String getUsername();

    /**
     * Permette di ottenere l'email dell'utente autenticato.
     * @return la stringa dell'email dell'utente autenticato.
     */
    String getEmail();

    /**
     * Permette di ottenere il tipo dell'utente autenticato.
     * @return <code>UtenteType</code> dell'utente autenticato.
     */
    TipoUtente getTipo();

    int getIdUtente();

    String getPassword();

}

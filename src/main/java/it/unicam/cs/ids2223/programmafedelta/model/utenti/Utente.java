package it.unicam.cs.ids2223.programmafedelta.model.utenti;

public interface Utente {

    /**
     * recupera l'id dell'utente
     * @return id utente scelto
     */
    int getId();

    /**
     * recupera il tipo dell'utente
     * @return tipo utente scelto
     */
    TipoUtente getTipo();

    /**
     * recupera mail
     * @return email utente scelto
     */
    String getMail();

    String getUsername();

}
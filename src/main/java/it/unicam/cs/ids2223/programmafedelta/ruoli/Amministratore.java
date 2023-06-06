package it.unicam.cs.ids2223.programmafedelta.ruoli;

public class Amministratore extends UtenteAutenticato implements IUtente {
    /**
     * Crea un utente autenticato come {@code Amministratore}.
     * @param idUtente user id dell'{@code Amministratore}.
     * @param username username dell'{@code Amministratore}.
     * @param email email dell'{@code Amministratore}.
     * @param psw password dell'{@code Amministratore}.
     */
    public Amministratore(int idUtente, String username, String email, String psw) {
        super(idUtente, username, email, psw, TipoUtente.AMMINISTRATORE);
    }
}

package it.unicam.cs.ids2223.programmafedelta.ruoli;

public class Cliente extends UtenteAutenticato implements IUtente {

    /**
     * Crea un utente autenticato come {@code Cliente}.
     * @param idUtente user id dell'{@code Cliente}.
     * @param username username dell'{@code Cliente}.
     * @param email email dell'{@code Cliente}.
     * @param psw password dell'{@code Cliente}.
     */
    public Cliente(int idUtente, String username, String email, String psw) {
        super(idUtente, username, email, psw, TipoUtente.CLIENTE);
    }

}

package it.unicam.cs.ids2223.programmafedelta.ruoli;

public class Cassiere extends UtenteAutenticato implements IUtente {

    /**
     * Crea un utente autenticato come {@code Cassiere}.
     * @param idUtente user id dell'{@code Cassiere}.
     * @param username username dell'{@code Cassiere}.
     * @param email email dell'{@code Cassiere}.
     * @param psw password dell'{@code Cassiere}.
     */
    public Cassiere(int idUtente, String username, String email, String psw) {
        super(idUtente, username, email, psw, TipoUtente.CASSIERE);
    }

}

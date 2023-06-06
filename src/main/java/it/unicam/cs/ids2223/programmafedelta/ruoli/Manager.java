package it.unicam.cs.ids2223.programmafedelta.ruoli;

public class Manager extends UtenteAutenticato implements IUtente {

    /**
     * Crea un utente autenticato come {@code Manager}.
     *
     * @param idUtente user id dell'{@code Manager}.
     * @param username username dell'{@code Manager}.
     * @param email    email dell'{@code Manager}.
     * @param psw      password dell'{@code Manager}.
     */
    public Manager(int idUtente, String username, String email, String psw) {
        super(idUtente, username, email, psw, TipoUtente.MANAGER);
    }
}
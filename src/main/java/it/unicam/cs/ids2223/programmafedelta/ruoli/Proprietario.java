package it.unicam.cs.ids2223.programmafedelta.ruoli;

public class Proprietario extends UtenteAutenticato implements IUtente {

    /**
     * Crea un utente autenticato come {@code Proprietario}.
     *
     * @param idUtente user id dell'{@code Proprietario}.
     * @param username username dell'{@code Proprietario}.
     * @param email    email dell'{@code Proprietario}.
     * @param psw      password dell'{@code Proprietario}.
     */
    public Proprietario(int idUtente, String username, String email, String psw) {
        super(idUtente, username, email, psw, TipoUtente.PROPRIETARIO);
    }
}
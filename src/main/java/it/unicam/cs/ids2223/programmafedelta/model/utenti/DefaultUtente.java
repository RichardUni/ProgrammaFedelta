package it.unicam.cs.ids2223.programmafedelta.model.utenti;

public class DefaultUtente implements Utente{

    private int idUtente;
    private String username;
    private String email;
    private TipoUtente tipoUtente;

    /**
     * Login
     * @param idUtente
     * @param tipoUtente
     * @param email
     * @param username
     */
    public DefaultUtente(int idUtente, TipoUtente tipoUtente, String email, String username) {
        this.idUtente = idUtente;
        this.tipoUtente = tipoUtente;
        this.email = email;
        this.username = username;
    }


    /**
     * SignIn
     * @param tipoUtente
     * @param username
     * @param email
     */
    public DefaultUtente(TipoUtente tipoUtente, String username, String email) {
        this.tipoUtente = tipoUtente;
        this.email = email;
        this.username = username;
    }


    @Override
    public int getId() {
        return this.idUtente;
    }

    @Override
    public TipoUtente getTipo() {
        return this.tipoUtente;
    }

    @Override
    public String getMail() {
        return this.email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "DefaultUtente{" +
                "idUtente=" + idUtente +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", tipoUtente=" + tipoUtente +
                '}';
    }
}

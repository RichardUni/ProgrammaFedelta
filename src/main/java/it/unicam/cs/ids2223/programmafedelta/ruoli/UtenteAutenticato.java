package it.unicam.cs.ids2223.programmafedelta.ruoli;

import java.util.Objects;

public class UtenteAutenticato implements IUtente {
    private final int idUtente;
    private final String username;
    private final String password;
    private final String email;
    private final TipoUtente tipoUtente;

    /**
     * Crea un utente autenticato.
     * @param uid
     * @param username username dell'utente autenticato.
     * @param email email dell'utente autenticato.
     * @param tipoUtente tipo di utente autenticato.
     */
    public UtenteAutenticato(int uid, String username, String email, String password, TipoUtente tipoUtente) {
        this.idUtente = uid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tipoUtente = tipoUtente;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public TipoUtente getTipo() {
        return tipoUtente;
    }

    @Override
    public int getIdUtente() {
        return idUtente;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtenteAutenticato that = (UtenteAutenticato) o;
        return Objects.equals(getUsername(), that.getUsername()) &&
                Objects.equals(getEmail(), that.getEmail()) &&
                tipoUtente == that.tipoUtente;
    }


    @Override
    public String toString() {
        return "UtenteAutenticato{" +
                "idUtente=" + idUtente +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tipoUtente=" + tipoUtente +
                '}';
    }
}

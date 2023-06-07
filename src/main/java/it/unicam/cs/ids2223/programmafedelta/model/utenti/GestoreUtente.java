package it.unicam.cs.ids2223.programmafedelta.model.utenti;

import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.persistenza.DBUtente;
import it.unicam.cs.ids2223.programmafedelta.persistence.DBManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Set;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class GestoreUtente {

    Utente utente;
    private static GestoreUtente instance = null;
    private Set<Utente> gruppoUtenti;

    public GestoreUtente(final DBManager dbManager) {
    }

    public GestoreUtente(){
    }

    public static GestoreUtente getInstance() {
        if (instance == null) instance = new GestoreUtente();
        return instance;
    }

    /**
     * Restituisce tutti gli <code>Utenti</code> a seconda del predicato fornito.
     * @param u predicato sugli utenti.
     * @return insieme degli <code>Utenti</code> che rispettano il predicato fornito.
     */
    public Set<Utente> getUtenti(Predicate<Utente> u) {
        return gruppoUtenti.stream().filter(u).collect(Collectors.toSet());
    }

    private final String insertQuery = "INSERT INTO public.utenti_registrati (username, email, password, user_type)	" +
            "VALUES ( {0}, {1}, {2}, {3}, {4} ) ;";


    private final String sql_select =  "SELECT * FROM public.utenti_registrati" +
            " WHERE email= {0} AND password= {1} ";


    /**
     * verifica le informazioni e se corrette vengono inserisce nel DB
     * @param username
     * @param email
     * @param password
     * @throws SQLException nel caso ci sia un problema oppure se mail o username fossero già presenti
     */
    public void sign_in(final String username,final String email, final String password) throws SQLException {
        Pattern pattern = Pattern.compile("\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\", Pattern.CASE_INSENSITIVE");
        if(pattern.matcher(email).matches()) {
            Logger.getAnonymousLogger().log(Level.WARNING, "email non valida -> "+email);
        }else {
            final Object[] token = {
                    "'" + username + "'",
                    "'" + email + "'",
                    "'" + Math.abs(password.hashCode()) + "'",
                    TipoUtente.CASSIERE.getCodice()
            };
            final String format = MessageFormat.format(insertQuery, token);
            int id = DBManager.getInstance().insert_update_delete_query(format);
            if (id == -1) {
                Logger.getAnonymousLogger().log(Level.WARNING, "username o email non valide");
                throw new SQLException();
            }else{
                Logger.getAnonymousLogger().log(Level.INFO, "id generato: "+id);
            }
        }
    }


    public Utente log_in(String mail, String password) throws NullPointerException, SQLException {
        final String hash_pass = String.valueOf(Math.abs(password.hashCode()));
        final Object[] token = {"'"+mail+"'" , "'"+hash_pass+"';" };
        final String format = MessageFormat.format(sql_select, token);
        ResultSet resultSet = DBManager.getInstance().select_query(format);

        if(resultSet!=null) {
            utente = new DBUtente().genera(resultSet);
        }
        if(utente == null) {
            throw new NullPointerException();
        }
        else return utente;
    }

    public void log_out(){
        utente = null;
    }

    public void cambia_mail(String vecchia_mail,String nuova_mail,String pass){
    }

    public void cambia_pass(String vecchia, String nuova){
    }

    public void show() {
        Logger.getAnonymousLogger().log(Level.INFO, utente.toString());
    }
}
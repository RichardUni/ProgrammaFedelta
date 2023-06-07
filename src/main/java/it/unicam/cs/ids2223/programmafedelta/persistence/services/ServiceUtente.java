package it.unicam.cs.ids2223.programmafedelta.persistence.services;

import it.unicam.cs.ids2223.programmafedelta.model.Piattaforma;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.TipoUtente;
import it.unicam.cs.ids2223.programmafedelta.ruoli.IUtente;
import it.unicam.cs.ids2223.programmafedelta.ruoli.UtenteAutenticato;

import java.text.MessageFormat;
import java.util.*;

/**
 * Singleton Service class per operazioni di persistenza riguardanti gli utenti.
 */

public class ServiceUtente extends AbstractService<IUtente> {

    private static ServiceUtente instance = null;

    private final String table_name = "public.utenti_registrati";
    private final String pk_name = "idUtente";
    private final String col_names = "username, psw, email, tipoUtente";
    private final String col_values = "VALUES ( {0} , {1} , {2} , {3} )";
    private final String select_base_query = "SELECT " + pk_name + ", " + col_names + " FROM " + table_name;
    private final String insert_query = "INSERT INTO " + table_name + " (" + col_names + ") " + col_values + ";";

    private ServiceUtente() {
    }

    public static ServiceUtente getInstance() {
        if (instance == null)
            instance = new ServiceUtente();
        return instance;
    }

    /**
     * Recupera tutti gli utenti registrati dal database del tipo dato.
     *
     * @param tipoUtente tipo dell'{@code IUtente}.
     * @return {@code Set} di {@link IUtente} che sono di tipo {@code tipoUtente}.
     */
    public Set<IUtente> getUsers(TipoUtente tipoUtente) {
        return parseDataResult(
                getDataResult(select_base_query + " WHERE tipoUtente = " + tipoUtente.getCode() + ";"));
    }

    /**
     * Recupera, se disponibile nel database, l'utente il cui {@code username} &egrave quello dato.
     *
     * @param username username dell'utente che si sta cercando.
     * @return un'{@code Optional} che descrive l'{@link IUtente} cercato,
     * altrimenti un {@code Optional} vuoto se la ricerca dello username nel database non ha avuto successo.
     */
    private Optional<IUtente> fetchThroughUsername(String username) {
        return parseDataResult(
                getDataResult(select_base_query + " WHERE username = '" + username + "';"))
                .stream().findFirst();
    }

    /**
     * Recupera, se disponibile nel database, l'utente la cui {@code email} &egrave quella data.
     *
     * @param email indirizzo email dell'utente che si sta cercando.
     * @return un'{@code Optional} che descrive l'{@link IUtente} cercato,
     * altrimenti un {@code Optional} vuoto se la ricerca dell'email nel database non ha avuto successo.
     */
    private Optional<IUtente> fetchThroughEmail(String email) {
        return parseDataResult(
                getDataResult(select_base_query + " WHERE email = '" + email + "';"))
                .stream().findFirst();
    }

    /**
     * Controlla se l'email data &egrave gi&agrave stata registrata ad un profilo.
     *
     * @param email email ricercata.
     * @return {@code true} se &egrave gi&agrave stata registrata, altrimenti false.
     */
    public boolean isAlreadySignedIn(String email) {
        return fetchThroughEmail(email).isPresent();
    }

    public boolean isAlreadyTaken(String username) {
        return fetchThroughUsername(username).isPresent();
    }

    /**
     * Effettua l'autenticazione dell'{@code IUtente} con le credenziali inserite.
     * Se l'operazione ha successo, viene impostato il gestore del tipo di utente giusto nella {@code Piattaforma}.
     *
     * @param username username dell'{@code IUtente}.
     * @param password password dell'{@code IUtente}.
     */
    public void login(String username, String password) throws AuthenticationErrorException {
        Set<IUtente> resultSet = parseDataResult(
                getDataResult(select_base_query + " WHERE username = '" + username +
                        "' AND password = '" + password + "'"));
        if (!resultSet.isEmpty()) {
            IUtente utente = resultSet.stream().findFirst().get();
            UtenteAutenticato utenteAutenticato = new UtenteAutenticato(utente.getIdUtente(), utente.getUsername(),
                    utente.getEmail(), utente.getPassword(),
                    utente.getTipo());
            Piattaforma.getInstance().setControllerUtente(utenteAutenticato);
        } else {
            logger.warning("Authentication error: couldn't log in.\n");
            throw new AuthenticationErrorException();
        }
    }

    /**
     * Effettua la registrazione dell'utente con le credenziali e informazioni fornite.
     *
     * @param username   username dell'utente.
     * @param email      email dell'utente.
     * @param password   password dell'utente.
     * @param tipoUtente {@link TipoUtente} dell'utente da registrare.
     */
    public void signIn(String username, String email, String password, TipoUtente tipoUtente) {
        int idUtente = getGeneratedKey(MessageFormat.format(insert_query, "'" + username + "'", "'" + email + "'",
                "'" + password + "'", tipoUtente.getCode()));
        UtenteAutenticato utenteAutenticato = new UtenteAutenticato(idUtente, username, email, password, tipoUtente);
        Piattaforma.getInstance().setControllerUtente(utenteAutenticato);
    }

    @Override
    public Set<IUtente> parseDataResult(TreeMap<String, HashMap<String, String>> users) {
        Set<IUtente> resultSet = new HashSet<>();
        int idUtente, tipoUtente = 2;
        String username = "", email = "", password = "";

        for (Map.Entry<String, HashMap<String, String>> firstEntry : users.entrySet()) {
            idUtente = Integer.parseInt(firstEntry.getKey());
            HashMap<String, String> others = firstEntry.getValue();
            for (Map.Entry<String, String> secondEntry : others.entrySet()) {
                String key = secondEntry.getKey();
                String val = secondEntry.getValue();
                switch (key) {
                    case "username":
                        username = val;
                        break;
                    case "email":
                        email = val;
                        break;
                    case "password":
                        password = val;
                        break;
                    case "tipoUtente":
                        tipoUtente = Integer.parseInt(val);
                        break;
                    default:
                        break;
                }
            }
            resultSet.add(new UtenteAutenticato(idUtente, username, email, password, TipoUtente.cercaTipoUtente(tipoUtente)));
        }
        return resultSet;
    }
}

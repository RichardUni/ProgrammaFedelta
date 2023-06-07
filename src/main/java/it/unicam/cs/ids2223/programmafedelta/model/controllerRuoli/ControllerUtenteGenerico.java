package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.model.Piattaforma;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.TipoUtente;
import it.unicam.cs.ids2223.programmafedelta.persistence.services.AuthenticationErrorException;
import it.unicam.cs.ids2223.programmafedelta.persistence.services.ServiceUtente;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Gestore dell'utente non registrato al sistema.
 */
public class ControllerUtenteGenerico implements ControllerUtente {

    protected IView<String> view;
    protected List<String> menuItems;
    private Logger logger = Logger.getLogger(Piattaforma.class.getName());

    private ServiceUtente serviceUtente = ServiceUtente.getInstance();

    public ControllerUtenteGenerico(IView<String> view) {
        this.view = view;
        menuItems = new ArrayList<>();
        impostaMenu();
    }

    @Override
    public void mainMenu() {
        int scelta;
        do {
            view.message("\nMENU PRINCIPALE", menuItems);
            scelta = view.fetchChoice("Inserisci l'indice dell'operazione desiderata", menuItems.size());
        } while (switchMenu(scelta));
    }

    protected boolean switchMenu(int scelta) {
        boolean loop = true;
        switch (scelta) {
            case 1:
                login();
                loop = false;
                break;
            case 2:
                exit();
                loop = false;
                break;
            default:
                logger.info("Input non valido");
        }
        return loop;
    }

    private void login() {
        do {
            view.message("\nAUTENTICAZIONE\nScegliere operazione:");
            int choice = view.fetchChoice("1) LogIn\n2) SignIn\n3) Torna al menù principale", 3);
            if (choice == 2) signIn();
            else if (choice == 3) return;
            else {
                view.message("\nLOGIN");
                String username = view.ask("Inserire username:");
                String password = view.ask("Inserire password:");
                try { serviceUtente.login(username, password); break; } catch (AuthenticationErrorException ignored) {}
            }
        } while (true);
    }

    private void signIn() {
        String email;
        boolean backtrack = false;
        view.message("\nREGISTRAZIONE");
        do {
            email = view.ask("Inserire la email: ");
            if (!serviceUtente.isAlreadySignedIn(email))
                break;
            else {
                logger.info("Email già presente");
                view.message("Vuoi tornare all'autenticazione? [Y,n]");
                backtrack = view.fetchBool();
            }
        } while (!backtrack);
        if (backtrack) return;
        String username;
        do {
            username = view.ask("Scegliere lo username: ");
            if (!serviceUtente.isAlreadyTaken(username))
                break;
            else {
                logger.info("Lo username scelto è già registrato ad un profilo nel sistema con un'altra email.");
                view.message("Vuoi tornare all'autenticazione? [Y,n]");
                backtrack = view.fetchBool();
            }
        } while (!backtrack);
        if (backtrack) return;
        String password;
        while (true) {
            password = view.ask("Inserisci la password: ");
            if (view.ask("Reinserisci la password: ").equals(password)) break;
            else logger.info("Le password inserite non sono uguali: reinserirle nuovamente");
        }
        TipoUtente tipoUtente = TipoUtente.cercaTipoUtente(
                view.fetchChoice("Scegliere il tipo di utente:\n1) Cliente\n2) Cassiere\n3) Proprietario\n4) Manager.", 4));

        serviceUtente.signIn(username, email, password, tipoUtente);
    }

    protected void exit() {
        view.message("Sessione terminata");
        System.exit(0);
    }



    private void impostaMenu() {
        menuItems.add("1) Accedi al sistema");
        menuItems.add("2) Termina sessione");
    }
}

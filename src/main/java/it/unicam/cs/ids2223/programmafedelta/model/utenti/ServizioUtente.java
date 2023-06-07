package it.unicam.cs.ids2223.programmafedelta.model.utenti;

import it.unicam.cs.ids2223.programmafedelta.model.system.Service;
import it.unicam.cs.ids2223.programmafedelta.persistence.DBManager;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

import java.sql.SQLException;

public class ServizioUtente<U extends Utente> implements Service<Utente> {

    private IView<String> cliView;
    private DBManager dbManager;


    public ServizioUtente(IView iView, DBManager dbManager) {
        this.cliView = iView;
        this.dbManager = dbManager;
    }

    public void signup() {
        GestoreUtente gestoreUtente = new GestoreUtente(dbManager);
        while (true) {
            cliView.message("Operazione di registrazione. Inserire il comando exit per uscire");

            String username = cliView.ask("Inserire username");
            if (username.equals("exit")) break;

            String mail = cliView.ask("Inserire mail");
            if (mail.equals("exit")) break;

            retry:
            {
                String password = cliView.ask("Inserire password");
                String passwordR = cliView.ask("Inserire nuovamente la password immessa");
                if (password.equals(passwordR)) {
                    try {
                        gestoreUtente.sign_in(username, mail, password);
                    } catch (SQLException e) {
                        cliView.message("Si è verificato un errore durante la creazione");
                    }
                    cliView.message("Utente creato con successo");
                    break;
                } else {
                    cliView.ask("Password non accettata");
                    break retry;
                }
            }
        }
    }


    public Utente login() {
        GestoreUtente gestoreUtente = new GestoreUtente(dbManager);
        while (true) {
            cliView.message("Operazione di log in. Inserire il comando exit per uscire");
            String mail = cliView.ask("Inserire mail");
            if (mail.equals("exit")) return null;
            String password = cliView.ask("Inserire password");
            try {
                return gestoreUtente.log_in(mail, password);
            } catch (NullPointerException | SQLException sqlException) {
                System.err.println("Utente non trovato");
            }
        }
    }


    @Override
    public Utente menu() {
        while (true) {
            cliView.message("Cambia password");
            cliView.message("Cambia Mail");
            switch (cliView.ask("Cosa si vuole modificare?")) {
                case "cambia password":
                    break;
                case "cambia mail":
                    break;
            }
            break;
        }
        return null;
    }
}
package it.unicam.cs.ids2223.programmafedelta.model;

import it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli.*;
import it.unicam.cs.ids2223.programmafedelta.persistence.PGManager;
import it.unicam.cs.ids2223.programmafedelta.ruoli.*;
import it.unicam.cs.ids2223.programmafedelta.view.CLIView;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

import java.util.logging.*;


public class Piattaforma {
    private static Piattaforma instance;
    private static ControllerUtente controllerUtente;
    private IView<String> cli_view;

    private Piattaforma()  {
        setupLogger();
        PGManager.getInstance().testConnection();
    }

    public static Piattaforma getInstance() {
        if (instance == null)
            instance = new Piattaforma();
        return instance;
    }

    public void setControllerUtente(IUtente utente) {
        int utenteId = utente.getIdUtente();
        String username = utente.getUsername();
        String email = utente.getEmail();
        String password = utente.getPassword();
        switch (utente.getTipo()) {
            case AMMINISTRATORE:
                controllerUtente = new ControllerAmministratore(cli_view, new Amministratore(utenteId, username, email, password));
                break;
            case CASSIERE:
                controllerUtente = new ControllerCassiere(cli_view, new Cassiere(utenteId, username, email, password));
                break;
            case CLIENTE:
                controllerUtente = new ControllerCliente(cli_view, new Cliente(utenteId, username, email, password));
                break;
            case MANAGER:
                controllerUtente = new ControllerManager(cli_view, new Manager(utenteId, username, email, password));
                break;
            case PROPRIETARIO:
                controllerUtente = new ControllerProprietario(cli_view, new Proprietario(utenteId, username, email, password));
                break;
        }
    }

    public void init() {
        cli_view = new CLIView();
        controllerUtente = new ControllerUtenteGenerico(cli_view);
        while (true) {
            controllerUtente.mainMenu();
        }
    }

    public void resetControllerUtente() {
        controllerUtente = new ControllerUtenteGenerico(cli_view);
    }

    private void setupLogger() {
        Logger logger = Logger.getLogger(Piattaforma.class.getName());
        logger.setUseParentHandlers(false);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        ch.setFormatter(new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
        logger.addHandler(ch);
    }
}

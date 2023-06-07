package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.model.Piattaforma;
import it.unicam.cs.ids2223.programmafedelta.ruoli.UtenteAutenticato;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

/**
 * Gestore per un utente autenticato
 */
public class ControllerUtenteAutenticato extends ControllerUtenteGenerico implements ControllerUtente {

    protected UtenteAutenticato utente;

    public ControllerUtenteAutenticato(IView<String> view, UtenteAutenticato utente) {
        super(view);
        this.utente = utente;
        impostaMenu();
    }

    @Override
    protected boolean switchMenu(int scelta) {
        boolean loop;
        switch (scelta) {
            case 1:
                logOut();
                loop = false;
                break;
            case 2:
                exit();
                loop = false;
                break;
            default:
                loop = super.switchMenu(scelta);
        }
        return loop;
    }

    private void logOut() {
        view.message("Fine sessione");
        Piattaforma.getInstance().resetControllerUtente();
    }

    @Override
    protected void exit() {
        logOut();
        System.exit(0);
    }

    private void impostaMenu() {
        menuItems.remove(0);
        menuItems.add(0, "1) Log out");
    }

    public UtenteAutenticato getLoggedUser() {
        return utente;
    }

}
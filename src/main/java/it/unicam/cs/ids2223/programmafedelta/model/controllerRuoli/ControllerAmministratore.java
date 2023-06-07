package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.ruoli.Amministratore;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

public class ControllerAmministratore  extends ControllerUtenteAutenticato implements ControllerUtente{


    public ControllerAmministratore(IView<String> view, Amministratore amministratore) {
        super(view, amministratore);
        impostaMenu();
    }



    private void impostaMenu() {
        menuItems.add("1) Elimina Utente");
        menuItems.add("2) Modifica Utente");
        menuItems.add("3) Elimina Negozio");
    }
}

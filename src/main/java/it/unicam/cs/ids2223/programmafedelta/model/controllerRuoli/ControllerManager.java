package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.ruoli.Manager;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

public class ControllerManager extends ControllerUtenteAutenticato implements ControllerUtente {

    public ControllerManager(IView<String> view, Manager manager) {
        super(view, manager);
        impostaMenu();
    }


    private void impostaMenu() {
        menuItems.add("1) Inserisci Campagna");
        menuItems.add("2) Invia Pubblicità");
    }
}

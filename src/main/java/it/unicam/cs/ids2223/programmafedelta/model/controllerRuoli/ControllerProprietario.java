package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.ruoli.Proprietario;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

public class ControllerProprietario extends ControllerUtenteAutenticato implements ControllerUtente{

    public ControllerProprietario(IView<String> view, Proprietario proprietario) {
        super(view, proprietario);
        impostaMenu();
    }


    private void impostaMenu() {
        menuItems.add("1) Inserisci Dipendente");
        menuItems.add("2) Imposta Regole Fedeltà");
    }
}

package it.unicam.cs.ids2223.programmafedelta.model.controllerRuoli;

import it.unicam.cs.ids2223.programmafedelta.ruoli.Cliente;
import it.unicam.cs.ids2223.programmafedelta.view.IView;

public class ControllerCliente extends ControllerUtenteAutenticato implements ControllerUtente {

    public ControllerCliente(IView<String> view, Cliente cliente) {
        super(view, cliente);
        impostaMenu();
    }

    private void impostaMenu() {
        menuItems.add("1) Crea Tessera Fedelta");
        menuItems.add("2) Effettua Acquista");
        menuItems.add("3) Visita Profilo");
        menuItems.add("4) Modifica Profilo");
        menuItems.add("5) Riscatta Bonus");
        menuItems.add("6) Scrivi Recensione");
        menuItems.add("7) Porta un Amico");
    }
}

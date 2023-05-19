package model;

import model.ruolo.Cliente;

public interface TesseraFedelta {

    boolean statoTessera();
    int getId();
    int getSaldo();
    Cliente getCliente();
}

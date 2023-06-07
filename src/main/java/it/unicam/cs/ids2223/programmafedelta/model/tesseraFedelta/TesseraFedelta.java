package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta;

public interface TesseraFedelta {

    int statoTessera();
    int getIdTessera();
    int getSaldo();
    int getId_Cliente();
    void cambiaStatoTessera(int stato);
    void assegnaIdCliente(int id);
}

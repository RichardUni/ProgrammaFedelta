package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta;

import it.unicam.cs.ids2223.programmafedelta.ruoli.Cliente;

import java.util.Date;

public class DefaultTessera implements TesseraFedelta{

    private int idTessera;
    private int punti;
    private Date dataCreazione;
    private Date dataScadenza;
    private boolean stato;
    private Cliente cliente;

    public DefaultTessera(int idTessera, int punti, Date dataCreazione, Date dataScadenza,
                          boolean stato, Cliente cliente) {
        this.idTessera = idTessera;
        this.punti = punti;
        this.dataCreazione = dataCreazione;
        this.dataScadenza = dataScadenza;
        this.stato = stato;
        this.cliente = cliente;
    }

    public int getIdTessera() {
        return idTessera;
    }

    public int getPunti() {
        return punti;
    }

    public Date getDataCreazione() {
        return dataCreazione;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public boolean isStato() {
        return stato;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public boolean statoTessera() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public int getSaldo() {
        return 0;
    }

    @Override
    public String toString() {
        return "DefaultTessera{" +
                "idTessera=" + idTessera +
                ", punti=" + punti +
                ", dataCreazione=" + dataCreazione +
                ", dataScadenza=" + dataScadenza +
                ", stato=" + stato +
                ", cliente=" + cliente +
                '}';
    }
}

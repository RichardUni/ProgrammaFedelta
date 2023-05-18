package model;

import model.ruolo.Cliente;

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
}

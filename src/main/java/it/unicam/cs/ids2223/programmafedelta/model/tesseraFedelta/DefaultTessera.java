package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta;

import java.time.LocalDateTime;
import java.util.Objects;

public class DefaultTessera implements TesseraFedelta {

    private int idTessera;
    private int idCliente;
    private int idNegozio;
    private int saldo;
    private LocalDateTime dataCreazione;
    private LocalDateTime dataScadenza;
    private int stato;



    /**
     * Costruttore per la creazione di una {@code DefaultTessera}
     *
     * @param idTessera     identificativo della tessera fedeltà
     * @param saldo         saldo punteggio assegnato alla tessera
     * @param dataCreazione data di creazione della tessera
     * @param dataScadenza  data di scadenza della tessera
     * @param stato         stato della tessera (0 = disattivata, 1 = attivata)
     * @param idCliente     identificativo del cliente che a cui è associata la {@code TesseraFedelta}
     * @param idNegozio     identificativo del negozio dove opera la {@code TesseraFedelta}
     */
    public DefaultTessera(int idTessera, int saldo, LocalDateTime dataCreazione, LocalDateTime dataScadenza,
                          int stato, int idCliente, int idNegozio) {

        this.idTessera = idTessera;
        this.saldo = saldo;
        this.dataCreazione = dataCreazione;
        this.dataScadenza = dataScadenza;
        this.stato = stato;
        this.idCliente = idCliente;
        this.idNegozio = idNegozio;
    }

    @Override
    public int statoTessera() {
        return 0;
    }

    @Override
    public int getIdTessera() {
        return idTessera;
    }

    @Override
    public int getId_Cliente() {
        return 0;
    }

    @Override
    public void cambiaStatoTessera(int stato) {

    }

    @Override
    public void assegnaIdCliente(int id) {

    }

    public int getSaldo() {
        return saldo;
    }

    public LocalDateTime getDataCreazione() {
        return dataCreazione;
    }

    public LocalDateTime getDataScadenza() {
        return dataScadenza;
    }

    public int getStato() {
        return stato;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public int getIdNegozio() {
        return idNegozio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultTessera that = (DefaultTessera) o;
        return idTessera == that.idTessera && saldo == that.saldo && stato == that.stato && Objects.equals(dataCreazione, that.dataCreazione) && Objects.equals(dataScadenza, that.dataScadenza) && Objects.equals(idCliente, that.idCliente) && Objects.equals(idNegozio, that.idNegozio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTessera, saldo, dataCreazione, dataScadenza, stato, idCliente, idNegozio);
    }

    @Override
    public String toString() {
        return "DefaultTessera{" +
                "idTessera=" + idTessera +
                ", saldo=" + saldo +
                ", dataCreazione=" + dataCreazione +
                ", dataScadenza=" + dataScadenza +
                ", stato=" + stato +
                ", cliente=" + idCliente +
                ", negozio=" + idNegozio +
                '}';
    }
}
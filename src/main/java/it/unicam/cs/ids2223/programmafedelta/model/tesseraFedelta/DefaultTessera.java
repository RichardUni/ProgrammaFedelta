package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta;

import java.time.LocalDateTime;
import java.util.Objects;

public class DefaultTessera implements TesseraFedelta {

    private int idTessera;
    private int idCliente;
    private int idNegozio;
    private int punti;
    private LocalDateTime dataCreazione;
    private LocalDateTime dataScadenza;
    private int stato;



    /**
     * Costruttore per la creazione di una {@code DefaultTessera}
     *
     * @param idTessera     identificativo della tessera fedeltà
     * @param punti         saldo punteggio assegnato alla tessera
     * @param dataCreazione data di creazione della tessera
     * @param dataScadenza  data di scadenza della tessera
     * @param stato         stato della tessera (0 = disattivata, 1 = attivata)
     * @param idCliente     identificativo del cliente che a cui è associata la {@code TesseraFedelta}
     * @param idNegozio     identificativo del negozio dove opera la {@code TesseraFedelta}
     */
    public DefaultTessera(int idTessera, int punti, LocalDateTime dataCreazione, LocalDateTime dataScadenza,
                          int stato, int idCliente, int idNegozio) {

        this.idTessera = idTessera;
        this.punti = punti;
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
    public int getSaldo() {
        return 0;
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

    public int getPunti() {
        return punti;
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
        return idTessera == that.idTessera && punti == that.punti && stato == that.stato && Objects.equals(dataCreazione, that.dataCreazione) && Objects.equals(dataScadenza, that.dataScadenza) && Objects.equals(idCliente, that.idCliente) && Objects.equals(idNegozio, that.idNegozio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTessera, punti, dataCreazione, dataScadenza, stato, idCliente, idNegozio);
    }

    @Override
    public String toString() {
        return "DefaultTessera{" +
                "idTessera=" + idTessera +
                ", punti=" + punti +
                ", dataCreazione=" + dataCreazione +
                ", dataScadenza=" + dataScadenza +
                ", stato=" + stato +
                ", cliente=" + idCliente +
                ", negozio=" + idNegozio +
                '}';
    }
}
package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Raccoglitore delle info per la creazione di una {@code TesseraFedelta}.
 */
public class InfoTessera {

    // informazioni impostate dall'utente che crea la tessera fedeltà
    private int idTessera;
    private int idCliente;

   // private int idNegozio;
    private final int punti;
    private LocalDateTime dataCreazione;
    private LocalDateTime dataScadenza;
    private int stato;

    /*
    private final int idTessera;
    private final int idCliente;
    private final int idNegozio;
    private final int punti;
    private final LocalDateTime dataCreazione;
    private final LocalDateTime dataScadenza;
    private final int stato;
     */



    public InfoTessera(int idTessera, int idCliente, int punti, LocalDateTime dataCreazione, LocalDateTime dataScadenza, int stato) {
        this.idTessera = idTessera;
        this.idCliente = idCliente;
        this.punti = punti;
        this.dataCreazione = dataCreazione;
        this.dataScadenza = dataScadenza;
        this.stato = stato;
    }

    public InfoTessera(int punti, int stato) {
        this.punti = punti;
        this.stato = stato;
    }

    public int getIdTessera(){
        return idTessera;
    }

    public int getIdCliente() {
        return idCliente;
    }

    /*public int getIdNegozio(){
        return idNegozio;
    }*/

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoTessera that = (InfoTessera) o;
        return idTessera == that.idTessera && idCliente == that.idCliente && punti == that.punti && stato == that.stato && Objects.equals(dataCreazione, that.dataCreazione) && Objects.equals(dataScadenza, that.dataScadenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTessera, idCliente, punti, dataCreazione, dataScadenza, stato);
    }
}
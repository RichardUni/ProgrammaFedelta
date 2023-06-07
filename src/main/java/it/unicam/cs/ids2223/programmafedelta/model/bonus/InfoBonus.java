package it.unicam.cs.ids2223.programmafedelta.model.bonus;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Raccoglitore delle info per la creazione di un {@code Bonus}.
 */

public class InfoBonus {

    // informazioni impostate dal proprietario nell'inserimento dei bonus

    private final int idBonus;
    private final int idTessera;
    private final int idNegozio;
    private final String nome;
    private final int prezzoPunti;
    private final int stato;
    private final double prezzo;
    private final LocalDateTime dataScadenza;

    public InfoBonus(int idBonus, int idTessera, int idNegozio, String nome, int prezzoPunti, int stato, double prezzo, LocalDateTime dataScadenza) {
        this.idBonus = idBonus;
        this.idTessera = idTessera;
        this.idNegozio = idNegozio;
        this.nome = nome;
        this.prezzoPunti = prezzoPunti;
        this.stato = stato;
        this.prezzo = prezzo;
        this.dataScadenza = dataScadenza;

    }

    public int getIdBonus() {
        return idBonus;
    }

    public int getIdNegozio() {
        return idNegozio;
    }

    public int getIdTessera(){
        return idTessera;
    }

    public String getNome() {
        return nome;
    }

    public int getPrezzoPunti() {
        return prezzoPunti;
    }

    public int getStato() {
        return stato;
    }

    public LocalDateTime getDataScadenza() {
        return dataScadenza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoBonus infoBonus = (InfoBonus) o;
        return idBonus == infoBonus.idBonus && idNegozio == infoBonus.idNegozio && prezzoPunti == infoBonus.prezzoPunti && stato == infoBonus.stato && Double.compare(infoBonus.prezzo, prezzo) == 0 && Objects.equals(nome, infoBonus.nome) && Objects.equals(dataScadenza, infoBonus.dataScadenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBonus, idNegozio, nome, prezzoPunti, stato, prezzo, dataScadenza);
    }
}
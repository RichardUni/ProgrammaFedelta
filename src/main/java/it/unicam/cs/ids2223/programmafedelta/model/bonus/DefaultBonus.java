package it.unicam.cs.ids2223.programmafedelta.model.bonus;

import java.time.LocalDateTime;
import java.util.Objects;

public class DefaultBonus implements Bonus {

    private int idBonus;
    private int idNegozio;
    private String nome;
    private int prezzoPunti;
    private int stato;
    private LocalDateTime dataScadenza;

    public DefaultBonus(int idBonus, int idNegozio, String nome, int prezzoPunti, LocalDateTime dataScadenza, int stato) {
        this.idBonus = idBonus;
        this.idNegozio = idNegozio;
        this.nome = nome;
        this.prezzoPunti = prezzoPunti;
        this.dataScadenza = dataScadenza;
        this.stato = stato;
    }

    public int getIdNegozio() {
        return idNegozio;
    }

    @Override
    public int getId() {
        return idBonus;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getPunti() {
        return 0;
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
        DefaultBonus that = (DefaultBonus) o;
        return idBonus == that.idBonus && idNegozio == that.idNegozio && prezzoPunti == that.prezzoPunti && stato == that.stato && Objects.equals(nome, that.nome) && Objects.equals(dataScadenza, that.dataScadenza);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBonus, idNegozio, nome, prezzoPunti, stato, dataScadenza);
    }

    @Override
    public String toString() {
        return "DefaultBonus{" +
                "idBonus=" + idBonus +
                ", idNegozio=" + idNegozio +
                ", nome='" + nome + '\'' +
                ", prezzoPunti=" + prezzoPunti +
                ", stato=" + stato +
                ", dataScadenza=" + dataScadenza +
                '}';
    }
}

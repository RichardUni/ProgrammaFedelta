package it.unicam.cs.ids2223.programmafedelta.model.prodotto;

import java.util.Objects;

public class DefaultProdotto implements Prodotto {
    private int idProdotto;
    private int idNegozio;
    private String nome;
    private double prezzo;
    private int punti;

    public DefaultProdotto(int idProdotto, int idNegozio, String nome, double prezzo, int punti) {
        this.idProdotto = idProdotto;
        this.idNegozio = idNegozio;
        this.nome = nome;
        this.prezzo = prezzo;
        this.punti = punti;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public int getIdNegozio() {
        return idNegozio;
    }

    @Override
    public int getNegozioId() {
        return 0;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public int getPunti() {
        return punti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultProdotto that = (DefaultProdotto) o;
        return idProdotto == that.idProdotto && idNegozio == that.idNegozio && Double.compare(that.prezzo, prezzo) == 0 && punti == that.punti && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdotto, idNegozio, nome, prezzo, punti);
    }

    @Override
    public String toString() {
        return "DefaultProdotto{" +
                "idProdotto=" + idProdotto +
                ", idNegozio=" + idNegozio +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", punti=" + punti +
                '}';
    }
}

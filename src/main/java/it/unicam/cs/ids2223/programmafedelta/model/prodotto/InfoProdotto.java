package it.unicam.cs.ids2223.programmafedelta.model.prodotto;

import java.util.Objects;

public class InfoProdotto {

    // informazioni impostate dal proprietario nell'inserimento del prodotto

    private final int idProdotto;
    private final int idNegozio;
    private final String nome;
    private final int prezzo;
    private final int punti;

    public InfoProdotto(int idProdotto, int idNegozio, String nome, int prezzo, int punti) {
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

    public String getNome() {
        return nome;
    }

    public int getPrezzo() {
        return prezzo;
    }

    public int getPunti() {
        return punti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoProdotto that = (InfoProdotto) o;
        return idProdotto == that.idProdotto && idNegozio == that.idNegozio && prezzo == that.prezzo && punti == that.punti && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdotto, idNegozio, nome, prezzo, punti);
    }

    @Override
    public String toString() {
        return "InfoProdotto{" +
                "idProdotto=" + idProdotto +
                ", idNegozio=" + idNegozio +
                ", nome='" + nome + '\'' +
                ", prezzo=" + prezzo +
                ", punti=" + punti +
                '}';
    }
}

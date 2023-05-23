package model;

public class DefaultProdotto implements Prodotto {
    private int id;
    private String nome;
    private float prezzo;
    private int punti;

    public DefaultProdotto(int id, String nome, float prezzo, int punti) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.punti = punti;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public float getPrezzo() {
        return this.prezzo;
    }

    @Override
    public int getPunti() {
        return this.punti;
    }
}

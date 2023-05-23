package model;

public class DefaultBonus implements Bonus {

    private String nome;
    private int id;
    private int punti;
    private int quantita;
    private boolean stato;

    public DefaultBonus(String nome, int id, int punti, int quantita, boolean stato) {
        this.nome = nome;
        this.id = id;
        this.punti = punti;
        this.quantita = quantita;
        this.stato = true;
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
    public int getPunti() {
        return this.punti;
    }

    @Override
    public int getQuantita() {
        return this.quantita;
    }

    public boolean cambiaStato() {
        return this.stato = false;
    }

    public void verificaStato() {
        if(this.stato = true) {
            System.out.println("Prodotto disponibile");
        }
        System.out.println("Prodotto non disponibile");
    }
}

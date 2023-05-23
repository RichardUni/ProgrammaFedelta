package model.ruolo;

public class DefaultManager implements Manager{
    private String nome;
    private int id;

    public DefaultManager (String n, int k) {
        this.nome=n;
        this.id= k;
    }


    @Override
    public void aggiungiBonus() {

    }

    @Override
    public void creaTessera() {

    }

    @Override
    public void cancellaIscrizione() {

    }
}

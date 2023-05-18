package model.ruoli;


/**
 * Rappresenta un utente <code>Cassiere</code> della piattaforma ProgrammaFedeltà
 */
public class DefaultCassiere implements Cassiere{

    private String nome;
    private int id_cassiere;
    private Negozio negozio;

    @Override
    public Cliente getCliente(Cliente c) {
        return null;
    }
}

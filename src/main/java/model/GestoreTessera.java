package model;

import model.ruolo.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Gestore di tutte le tessere associate al relativo <code>Cliente</code>.
 */

public class GestoreTessera {

    private List<TesseraFedelta> tessereFedelta;
    private Cliente cliente;

    /**
     * Crea un gestore delle tessere per il relativo <code>Cliente</code>.
     * @param cliente <code>Cliente</code> a cui il gestore fa riferimento.
     */

    public GestoreTessera(Cliente cliente){
        this.cliente = cliente;
        tessereFedelta = new ArrayList<>();
    }

    /**
     * Restituisce il <code>Cliente</code>> del gestore delle tessere
     * @return <code>Cliente</code> del gestore
     */
    public Cliente getcliente(){
        return cliente;
    }

    /**
     * Restituisce la tessera relativa all'id fornito
     * @param id identificativo della tessera che si cerca
     * @return la tessera cercata oppure un null
     */
    public Optional<TesseraFedelta> getTesseraFedelta(int id){
        return tessereFedelta.stream().filter((t) -> t.getId()==id).findFirst();
    }

    /**
     * Aggiunge una <code>TesseraFedelta</code> creata dal <Code>Cliente</Code>
     * @param tesseraFedelta
     */
    public void add(TesseraFedelta tesseraFedelta){
        tessereFedelta.add(tesseraFedelta);
    }
}

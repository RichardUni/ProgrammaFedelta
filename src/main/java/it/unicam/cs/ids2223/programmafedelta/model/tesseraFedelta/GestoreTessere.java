package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta;

import it.unicam.cs.ids2223.programmafedelta.persistence.services.ServiceTessera;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Cassiere;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Cliente;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gestore di tutte le tessere associate al relativo <code>Cliente</code>.
 */

public class GestoreTessere {

    private Set<ITesseraFedelta> tessereFedelta;
    private Cliente cliente;
    private Cassiere cassiere;
    private Set<TesseraFedelta> gruppoTessereFedelta;
    private static GestoreTessere instance = null;
    private static ServiceTessera serviceTessera;

    public Set<TesseraFedelta> getTessereFedelta() {
        return gruppoTessereFedelta.stream().collect(Collectors.toSet());
    }

    /**
     * Crea un gestore delle tessere per il relativo <code>Cliente</code>.
     * @param cliente <code>Cliente</code> a cui il gestore fa riferimento.
     */
    public GestoreTessere(Cliente cliente){
        this.cliente = cliente;
    }

    /**
     * Crea un gestore delle tessere per il <code>Cassiere</code> incaricato.
     * @param cassiere <code>Cassiere</code> a cui il gestore fa riferimento.
     */

    public GestoreTessere(Cassiere cassiere){
        this.cassiere = cassiere;
    }

    public static GestoreTessere getInstance(Cliente cliente) {
        if (instance == null) instance = new GestoreTessere(cliente);
        return instance;
    }
    public static GestoreTessere getInstance(Cassiere cassiere) {
        if (instance == null) instance = new GestoreTessere(cassiere);
        return instance;
    }

    /**
     * Restituisce la tessera in merito all'id fornito.
     * @param id identificativo della tessera
     * @return la tessera con l'id fornito oppure restituisce null se non trova nulla.
     */
    public ITesseraFedelta getTesseraFedelta(int id){
        return tessereFedelta.stream().filter((e) -> e.getId()==id).findFirst().orElseThrow(NullPointerException::new);
    }

    /**
     * Aggiunge una <code>TesseraFedelta</code> creata dall'utente.
     * @param infoTessera informazioni della <code>TesseraFedelta</code>.
     */
    public void add(InfoTessera infoTessera) {
        serviceTessera.upload(infoTessera);
    }

    public void aggiornaSaldo(InfoTessera infoTessera){
        serviceTessera.aggiornaSaldo(infoTessera);
    }




}

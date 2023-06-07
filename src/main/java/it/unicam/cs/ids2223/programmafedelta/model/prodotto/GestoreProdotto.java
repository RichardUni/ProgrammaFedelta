package it.unicam.cs.ids2223.programmafedelta.model.prodotto;

import it.unicam.cs.ids2223.programmafedelta.persistence.services.ServiceProdotto;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Cassiere;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Manager;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Proprietario;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gestore di tutti i prodotti
 */

public class GestoreProdotto {

    private Set<IProdotto> prodotto;
    private Cassiere cassiere;
    private Proprietario proprietario;
    private Manager manager;
    private Set<Prodotto> gruppoProdotti;
    private static GestoreProdotto instance = null;
    private static ServiceProdotto serviceProdotto;

    public Set<Prodotto> getGruppoProdotti() {
        return gruppoProdotti.stream().collect(Collectors.toSet());
    }

    /**
     * Crea un gestore dei prodotti per il relativo <code>Cassiere</code>.
     * @param cassiere <code>Cassiere</code> a cui il gestore fa riferimento.
     */
    public GestoreProdotto(Cassiere cassiere){
        this.cassiere = cassiere;
    }

    /**
     * Crea un gestore dei prodotti per il <code>Proprietario</code>.
     * @param proprietario <code>Proprietario</code> a cui il gestore fa riferimento.
     */

    public GestoreProdotto(Proprietario proprietario){
        this.proprietario = proprietario;
    }

    public static GestoreProdotto getInstance(Cassiere cassiere) {
        if (instance == null) instance = new GestoreProdotto(cassiere);
        return instance;
    }
    public static GestoreProdotto getInstance(Proprietario proprietario) {
        if (instance == null) instance = new GestoreProdotto(proprietario);
        return instance;
    }

    /**
     * Restituisce il prodotto in merito all'id fornito.
     * @param id identificativo del prodotto
     * @return il prodotto con l'id fornito oppure restituisce null se non trova nulla.
     */
    public IProdotto getProdotto(int id){
        return prodotto.stream().filter((p) -> p.getId()==id).findFirst().orElseThrow(NullPointerException::new);
    }

    /**
     * Aggiunge un <code>Bonus</code> creato dal Proprietario.
     * @param infoProdotto informazioni del <code>Bonus</code>.
     */
    public void add(InfoProdotto infoProdotto) {
        serviceProdotto.upload(infoProdotto);
    }





}

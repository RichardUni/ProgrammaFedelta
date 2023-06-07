package it.unicam.cs.ids2223.programmafedelta.model.bonus;

import it.unicam.cs.ids2223.programmafedelta.persistence.services.ServiceBonus;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Cassiere;
import it.unicam.cs.ids2223.programmafedelta.ruoli.Proprietario;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gestore di tutti i bonus
 */

public class GestoreBonus {

    private Set<IBonus> bonus;
    private Cassiere cassiere;
    private Proprietario proprietario;
    private Set<Bonus> gruppoBonus;
    private static GestoreBonus instance = null;
    private static ServiceBonus serviceBonus;

    public Set<Bonus> getGruppoBonus() {
        return gruppoBonus.stream().collect(Collectors.toSet());
    }

    /**
     * Crea un gestore dei bonus per il relativo <code>Cassiere</code>.
     * @param cassiere <code>Cassiere</code> a cui il gestore fa riferimento.
     */
    public GestoreBonus(Cassiere cassiere){
        this.cassiere = cassiere;
    }

    /**
     * Crea un gestore dei bonus per il <code>Proprietario</code>.
     * @param proprietario <code>Proprietario</code> a cui il gestore fa riferimento.
     */

    public GestoreBonus(Proprietario proprietario){
        this.proprietario = proprietario;
    }

    public static GestoreBonus getInstance(Cassiere cassiere) {
        if (instance == null) instance = new GestoreBonus(cassiere);
        return instance;
    }
    public static GestoreBonus getInstance(Proprietario proprietario) {
        if (instance == null) instance = new GestoreBonus(proprietario);
        return instance;
    }

    /**
     * Restituisce il bonus in merito all'id fornito.
     * @param id identificativo del bonus
     * @return il bonus con l'id fornito oppure restituisce null se non trova nulla.
     */
    public IBonus getBonus(int id){
        return bonus.stream().filter((e) -> e.getId()==id).findFirst().orElseThrow(NullPointerException::new);
    }

    /**
     * Restituisce il bonus in merito allo stato dell'elemento
     * @param stato condizione del bonus
     * @return il bonus con lo stato deciso oppure restituisce null se non trova nulla.
     */
    public IBonus getBonusStato(int stato){
        return bonus.stream().filter((e) -> e.getId()==stato).findFirst().orElseThrow(NullPointerException::new);
    }

    /**
     * Aggiunge un <code>Bonus</code> creato dal Proprietario.
     * @param infoBonus informazioni del <code>Bonus</code>.
     */
    public void add(InfoBonus infoBonus) {
        serviceBonus.upload(infoBonus);
    }




}
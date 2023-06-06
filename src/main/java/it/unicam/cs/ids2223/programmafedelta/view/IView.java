package it.unicam.cs.ids2223.programmafedelta.view;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

public interface IView<T> {

    /**
     * Permette di inviare un messaggio all'utente.
     * @param message messaggio da inviare all'utente.
     */
    void message(T message);

    /**
     * Permette di inviare un messaggio all'utente ed elencare gli elementi di una collezione.
     * @param message messaggio all'utente.
     * @param items collezione di elementi da elencare all'utente.
     */
    void message(T message, Collection<T> items);

    /**
     * Permette di inviare un messaggio all'utente e di ottenere una risposta.
     * @param message messaggio da mandare all'utente.
     * @return messaggio di risposta.
     */
    T ask(T message);

    /**
     * Permette di scegliere un singolo elemento dall'insieme dato in input.
     * @param items insieme degli elementi da cui scegliere un solo elemento.
     * @return l'elemento scelto dall'insieme dato in input.
     */
    T fetchSingleChoice(Collection<T> items);

    /**
     * Permette di scegliere un intero che va da 1 al limite fornitogli.
     * @param message messaggio da mostrare all'utente.
     * @param upperBound limite superiore del numero da scegliere.
     * @return numero scelto.
     */
    int fetchChoice(T message, int upperBound);

    /**
     * Permette di scegliere un intero.
     * @return numero intero scelto.
     */
    int fetchInt();

    /**
     * Permette di scegliere una data.
     * @return data scelta.
     */
    LocalDateTime fetchDate();

    /**
     * Permette di scegliere un sottoinsieme dall'insieme dato.
     * @param superSet insieme dato
     * @return sottoinsieme scelto
     */
    Set<T> fetchSubSet(Set<T> superSet);

    /**
     * Permette di scegliere un booleano.
     * @return valore booleano scelto
     */
    boolean fetchBool();

}


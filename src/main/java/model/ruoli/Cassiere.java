package model.ruoli;


/**
 * Dipendente che può far registrare i clienti nel programma fedeltà presso il negozio fisico,
 * convalidare gli acquisti assegnando punteggi per le relative carte e dare loro i bonus relativi
 * al proprio programma fedeltà
 */

public interface Cassiere {

    /**
     * Restituisce i dati di un Cliente
     * @return un'istanza di un Cliente
     */
    Cliente getCliente(Cliente c)();






}

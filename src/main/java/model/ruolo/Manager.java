package model.ruolo;

public interface Manager {

    /**
     * metodo per implementare la funzione che permette di aggiungere un bonus al programma fedelta
     */
   void aggiungiBonus();

   /**
    * metodo che permette anche al manager di iscrivere un nuovo cliente al programma
    */
   void creaTessera();

   void cancellaIscrizione(); //todo potenziale metodo per future iterazioni

}

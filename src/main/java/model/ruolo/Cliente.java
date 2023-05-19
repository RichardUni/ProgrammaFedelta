package model.ruolo;

import model.TesseraFedelta;

public interface Cliente {

    /**
     * Creazione di una <code>TesseraFedelta</code>
     */
    void creaTesseraFedelta();

    /**
     * Restituisce la tessera fedelta del <code>Cliente</code>
     * @return la tessera fedelta associata al <code>Cliente</code>
     */
    TesseraFedelta getTesseraFedelta();
}

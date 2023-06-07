package it.unicam.cs.ids2223.programmafedelta.persistence.services;

import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.ITesseraFedelta;
import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.InfoTessera;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Singleton Service class
 */

public class ServiceTessera extends AbstractService<ITesseraFedelta> {

    private static ServiceTessera instance = null;
    private final String table_name = "public.tessereFedelta";
    private final String pk_name = "idTessera";
    private final String col_names = "statoTessera, puntiTessera, dataInizio, dataScadenza";
    private final String col_values = "VALUES ( {0} , {1} , {2} , {3} , {4})";
    private final String select_base_query = "SELECT " + pk_name + ", " + col_names + " FROM " + table_name;
    private final String insert_query = "INSERT INTO " + table_name + " (" + col_names + ") " + col_values + ";";
    private final String update_query = "UPDATE " + table_name + ";";

    private ServiceTessera() {}

    public static ServiceTessera getInstance() {
        if (instance == null)
            instance = new ServiceTessera();
        return instance;
    }

    /**
     * Inserisce la nuova tessera fedeltà all'interno del database.
     * @param info informazioni della tessera fedeltà.
     * @return .
     */
    public ITesseraFedelta upload (InfoTessera info) {
        int genKey = getGeneratedKey(
                MessageFormat.format(insert_query, "'" + info.getIdTessera()  + "'",
                        "'" + info.getIdCliente()  + "'" + info.getIdNegozio() + "'", "'" + info.getStato() + "'",
                        "'" + info.getPunti() + "'", "'" + info.getDataCreazione() + "'",
                        "'" + info.getDataScadenza().toString().replace("T", " ")));
        return null;
    }

    public ITesseraFedelta aggiornaSaldo (InfoTessera info){
        int genKey = getGeneratedKey(
                MessageFormat.format(update_query, " SET puntiTessera = '" + info.getPunti() +
                        "' WHERE idTessera = '" + info.getIdTessera() + "'"));
        return null;
    }

    @Override
    public Set<ITesseraFedelta> parseDataResult(TreeMap<String, HashMap<String, String>> tessereFedelta) {
        Set<ITesseraFedelta> resultSet = new HashSet<>();
        int idTessera, idCliente, idNegozio, statoTessera, puntiTessera;
        LocalDateTime dataInizio, dataScadenza;

        for (Map.Entry<String, HashMap<String, String>> firstEntry : tessereFedelta.entrySet()) {
            idTessera = Integer.parseInt(firstEntry.getKey());
            HashMap<String, String> others = firstEntry.getValue();
            for (Map.Entry<String, String> secondEntry : others.entrySet()) {
                String key = secondEntry.getKey();
                String val = secondEntry.getValue();
                switch (key) {
                    case "idCliente": idCliente = Integer.parseInt(val); break;
                    case "idNegozio": idNegozio = Integer.parseInt(val); break;
                    case "statoTessera": statoTessera = Integer.parseInt(val); break;
                    case "puntiTessera": puntiTessera = Integer.parseInt(val); break;
                    case "dataInizio" : dataInizio = LocalDateTime.parse(val.replace(" ", "T")); break;
                    case "dataScadenza" : dataScadenza = LocalDateTime.parse(val.replace(" ", "T")); break;
                    default: break;
                }
            }
        }
        return resultSet;
    }
}

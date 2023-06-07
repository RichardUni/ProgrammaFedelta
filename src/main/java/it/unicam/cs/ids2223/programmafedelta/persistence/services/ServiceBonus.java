package it.unicam.cs.ids2223.programmafedelta.persistence.services;

import it.unicam.cs.ids2223.programmafedelta.model.bonus.IBonus;
import it.unicam.cs.ids2223.programmafedelta.model.bonus.InfoBonus;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Singleton Service class
 */

public class ServiceBonus extends AbstractService<IBonus> {

    private static ServiceBonus instance = null;
    private final String table_name = "public.bonus";
    private final String pk_name = "idBonus";
    private final String col_names = "nome, stato, prezzoPunti, dataScadenza, quantita";
    private final String col_values = "VALUES ( {0} , {1} , {2} , {3} , {4})";
    private final String select_base_query = "SELECT " + pk_name + ", " + col_names + " FROM " + table_name;
    private final String insert_query = "INSERT INTO " + table_name + " (" + col_names + ") " + col_values + ";";

    private ServiceBonus() {
    }

    public static ServiceBonus getInstance() {
        if (instance == null)
            instance = new ServiceBonus();
        return instance;
    }

    /**
     * Inserisce il bonus all'interno del database.
     *
     * @param info informazioni del bonus.
     * @return .
     */
    public IBonus upload(InfoBonus info) {
        int genKey = getGeneratedKey(
                MessageFormat.format(insert_query, "'" + info.getIdBonus() + "'",
                        "'" + info.getIdTessera() + "'" + info.getIdNegozio() + "'", "'" + info.getNome() + "'",
                        "'" + info.getStato() + "'", "'" + info.getPrezzoPunti() + "'",
                        "'" + info.getDataScadenza().toString().replace("T", " ") + "'"));
        return null;
    }

    @Override
    public Set<IBonus> parseDataResult(TreeMap<String, HashMap<String, String>> bonus) {
        Set<IBonus> resultSet = new HashSet<>();
        int idBonus, idTessera, idNegozio, stato, prezzoPunti, quantita;
        String nome = "";
        LocalDateTime dataScadenza;

        for (Map.Entry<String, HashMap<String, String>> firstEntry : bonus.entrySet()) {
            idBonus = Integer.parseInt(firstEntry.getKey());
            HashMap<String, String> others = firstEntry.getValue();
            for (Map.Entry<String, String> secondEntry : others.entrySet()) {
                String key = secondEntry.getKey();
                String val = secondEntry.getValue();
                switch (key) {
                    case "idTessera":
                        idTessera = Integer.parseInt(val);
                        break;
                    case "idNegozio":
                        idNegozio = Integer.parseInt(val);
                        break;
                    case "nome":
                        nome = val;
                        break;
                    case "stato":
                        stato = Integer.parseInt(val);
                        break;
                    case "prezzoPunti":
                        prezzoPunti = Integer.parseInt(val);
                        break;
                    case "dataScadenza":
                        dataScadenza = LocalDateTime.parse(val.replace(" ", "T"));
                        break;
                    case "quantita":
                        quantita = Integer.parseInt(val);
                        break;
                    default:
                        break;
                }
            }
        }
        return resultSet;
    }
}

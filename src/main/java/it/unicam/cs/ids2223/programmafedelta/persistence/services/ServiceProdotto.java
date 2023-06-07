package it.unicam.cs.ids2223.programmafedelta.persistence.services;

import it.unicam.cs.ids2223.programmafedelta.model.bonus.IBonus;
import it.unicam.cs.ids2223.programmafedelta.model.prodotto.IProdotto;
import it.unicam.cs.ids2223.programmafedelta.model.prodotto.InfoProdotto;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;

public class ServiceProdotto extends AbstractService<IProdotto> {

    private static ServiceProdotto instance = null;
    private final String table_name = "public.bonus";
    private final String pk_name = "idProdotto";
    private final String col_names = "nome, prezzo, punti";
    private final String col_values = "VALUES ( {0} , {1} , {2})";
    private final String select_base_query = "SELECT " + pk_name + ", " + col_names + " FROM " + table_name;
    private final String insert_query = "INSERT INTO " + table_name + " (" + col_names + ") " + col_values + ";";

    private ServiceProdotto() {
    }

    public static ServiceProdotto getInstance() {
        if (instance == null)
            instance = new ServiceProdotto();
        return instance;
    }

    /**
     * Inserisce il bonus all'interno del database.
     *
     * @param info informazioni del bonus.
     * @return .
     */
    public IProdotto upload(InfoProdotto info) {
        int genKey = getGeneratedKey(
                MessageFormat.format(insert_query, "'" + info.getIdProdotto() + "'",
                        "'" + info.getIdNegozio() + "'" + info.getNome() + "'", "'" + info.getPunti() + "'"));
        return null;
    }

    @Override
    public Set<IProdotto> parseDataResult(TreeMap<String, HashMap<String, String>> prodotto) {
        Set<IProdotto> resultSet = new HashSet<>();
        int idProdotto, prezzo, punti;
        String nome = "";

        for (Map.Entry<String, HashMap<String, String>> firstEntry : prodotto.entrySet()) {
            idProdotto = Integer.parseInt(firstEntry.getKey());
            HashMap<String, String> others = firstEntry.getValue();
            for (Map.Entry<String, String> secondEntry : others.entrySet()) {
                String key = secondEntry.getKey();
                String val = secondEntry.getValue();
                switch (key) {
                    case "idProdotto":
                        idProdotto = Integer.parseInt(val);
                        break;
                    case "idNegozio":
                        idNegozio = Integer.parseInt(val);
                        break;
                    case "nome":
                        nome = val;
                        break;
                    case "prezzo":
                        prezzo = Integer.parseInt(val);
                        break;
                    case "punti":
                        punti = Integer.parseInt(val);
                        break;
                    default:
                        break;
                }
            }
        }
        return resultSet;
    }
}

package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.persistenza;

import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.DefaultTessera;
import it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.TesseraFedelta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBTessere {

    public DBTessere(){
        Logger.getAnonymousLogger().log(Level.INFO, "inizio db Tessere Fedeltà");
    }

    /**
     * istanziazione di una <code>{@link DefaultTessera}</code>
     *
     * @param resultSet il risultato di una query <code>Resulset</code>
     * @return una <code>{@link DefaultTessera}</code>
     * @throws SQLException
     */

    public TesseraFedelta genera(ResultSet resultSet) throws SQLException {
        while(resultSet!=null && resultSet.next()){
            TesseraFedelta tesseraFedelta = new DefaultTessera(
                    resultSet.getInt("idTessera"),
                    resultSet.getInt("idCliente"),
                    resultSet.getObject("dataInizio", LocalDateTime.class),
                    resultSet.getObject("dataScadenza", LocalDateTime.class),
                    resultSet.getInt("idNegozio"),
                    resultSet.getInt("statoTessera"),
                    resultSet.getInt("puntiTessera")
                    );
            return tesseraFedelta;
        }
        return null;
    }

    /**
     * inserimento di un insieme di <code>{@link DefaultTessera}</code>
     *
     * @param resultSet <code>ResultSet</code>
     * @param tesserafedeltaList lista di tessere fedeltà
     * @throws SQLException
     */
    public void genera(ResultSet resultSet , List<TesseraFedelta> tesserafedeltaList) throws SQLException {
        while(resultSet!=null && resultSet.next()){
            TesseraFedelta tesseraFedelta = new DefaultTessera(
                    resultSet.getInt("idTessera"),
                    resultSet.getInt("idCliente"),
                    resultSet.getObject("dataInizio", LocalDateTime.class),
                    resultSet.getObject("dataScadenza", LocalDateTime.class),
                    resultSet.getInt("idNegozio"),
                    resultSet.getInt("statoTessera"),
                    resultSet.getInt("puntiTessera")
            );
            tesserafedeltaList.add(tesseraFedelta);
        }
    }


}

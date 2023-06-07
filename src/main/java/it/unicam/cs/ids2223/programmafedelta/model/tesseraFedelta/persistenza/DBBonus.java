package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.persistenza;

import it.unicam.cs.ids2223.programmafedelta.model.bonus.Bonus;
import it.unicam.cs.ids2223.programmafedelta.model.bonus.DefaultBonus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBBonus {
    public DBBonus(){
        Logger.getAnonymousLogger().log(Level.INFO, "inizio db Bonus");
    }

    /**
     * istanziazione di un <code>{@Link DefaultBonus}</code>
     *
     * @param resultSet il risultato di una query <code>Resultset</code>
     * @return un <code>{@link DefaultBonus}</code>
     * @throws SQLException
     */

    public Bonus genera(ResultSet resultSet) throws SQLException {
        while(resultSet!=null && resultSet.next()){
            Bonus bonus = new DefaultBonus(
                    resultSet.getInt("idBonus"),
                    resultSet.getInt("idTessera"),
                    resultSet.getInt("idNegozio"),
                    resultSet.getString("nome"),
                    resultSet.getInt("prezzoPunti"),
                    resultSet.getObject("dataScadenza", LocalDateTime.class),
                    resultSet.getInt("stato")
            );
            return bonus;
        }
        return null;
    }

    /**
     * inserimento di un insieme di <code>{@link DefaultBonus}</code>
     *
     * @param resultSet <code>ResultSet</code>
     * @param bonusList lista di bonus
     * @throws SQLException
     */
    public void genera(ResultSet resultSet , List<Bonus> bonusList) throws SQLException {
        while(resultSet!=null && resultSet.next()){
            Bonus bonus = new DefaultBonus(
                    resultSet.getInt("idBonus"),
                    resultSet.getInt("idTessera"),
                    resultSet.getInt("idNegozio"),
                    resultSet.getString("nome"),
                    resultSet.getInt("prezzoPunti"),
                    resultSet.getObject("dataScadenza", LocalDateTime.class),
                    resultSet.getInt("stato")
            );
            bonusList.add(bonus);
        }
    }
}


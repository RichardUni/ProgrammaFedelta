package it.unicam.cs.ids2223.programmafedelta.model.tesseraFedelta.persistenza;

import it.unicam.cs.ids2223.programmafedelta.model.utenti.DefaultUtente;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.TipoUtente;
import it.unicam.cs.ids2223.programmafedelta.model.utenti.Utente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBUtente {

    public DBUtente(){
        Logger.getAnonymousLogger().log(Level.INFO, "Inizio db Utenti");
    }

    public void genera(ResultSet resultSet, List<Utente> lista) throws SQLException {
        while(resultSet!=null && resultSet.next()){
            Utente utente = new DefaultUtente(
                    resultSet.getInt("idUtente"),
                    tipoUtente(resultSet.getInt("tipoUtente")),
                    resultSet.getString("email"),
                    resultSet.getString("username"));
            lista.add(utente);
        }
    }


    public Utente genera(ResultSet resultSet) throws SQLException {
        while(resultSet!=null && resultSet.next()){
            Utente utente = new DefaultUtente(
                    resultSet.getInt("idUtente"),
                    tipoUtente(resultSet.getInt("tipoUtente")),
                    resultSet.getString("email"),
                    resultSet.getString("username"));
            return utente;
        }return null;
    }

    private TipoUtente tipoUtente(int tipo){
        switch (tipo){
            case 0 : return TipoUtente.AMMINISTRATORE;
            case 1 : return TipoUtente.CLIENTE;
            case 2 : return TipoUtente.CASSIERE;
            case 3 : return TipoUtente.PROPRIETARIO;
            case 4 : return TipoUtente.MANAGER;
            default: return null;
        }
    }
}


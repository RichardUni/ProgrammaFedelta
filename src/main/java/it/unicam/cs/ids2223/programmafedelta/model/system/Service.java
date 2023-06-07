package it.unicam.cs.ids2223.programmafedelta.model.system;

import java.sql.SQLException;

public interface Service <T>{

    T menu() throws SQLException;

}

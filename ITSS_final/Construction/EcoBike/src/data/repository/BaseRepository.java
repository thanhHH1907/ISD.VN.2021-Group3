package data.repository;


import java.sql.SQLException;
import java.sql.Statement;

import common.utils.EcoBikeRental;


public class BaseRepository {
     /**
     * update row in table
     * @param tbname
     * @param id
     * @param column
     * @param value
     * @throws SQLException
     */
    public void updateFieldById(String tbname, int id, String column, Object value) throws SQLException {
        Statement stm = EcoBikeRental.getConnection().createStatement();
        if (value instanceof String) {
            value = "\"" + value + "\"";
        }
        stm.executeUpdate(" update " + tbname + " set" + " "
                + column + "=" + value + " "
                + "where id=" + id + ";");

    }
}

package ma.creditSimula.dao.daoMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

public class Utilitaire {

    public static PreparedStatement initPS(Connection CNX, String SQL, boolean geneatekey, Object... Columns) throws SQLException{

        PreparedStatement PS= null;
        PS    = CNX.prepareStatement(SQL, geneatekey ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);
        for (int i = 0; i < Columns.length; i++) {
            PS.setObject(i+1, Columns[i]);
        }
        return PS;
    }

}


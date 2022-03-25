package gov.edu.anm.presenter.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdpresenteranm", "anmadmin", "epanm2022");    
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

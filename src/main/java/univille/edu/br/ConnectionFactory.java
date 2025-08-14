package univille.edu.br;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;

    private ConnectionFactory(){}

    public static ConnectionFactory getInstance(){
        if(instance == null) instance = new ConnectionFactory();
        return instance;
    }

    public Connection get() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String user = "root";
        String password = "mysql300805";
        return DriverManager.getConnection(url,user,password);
    }

}

package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Singleton {
    public Connection cnx;
    private static Singleton  instance;
    private static String dsn = "jdbc:mariadb://10.30.103.63/commandelabo";
    private static String username = "root";
    private static String password = "";


    private Singleton() throws SQLException {

        cnx = DriverManager.getConnection(dsn,username,password);

    }
    public static Singleton getInstance() throws SQLException {
        if(instance==null) {
            instance= new Singleton();
        }
        return instance;

    }

}

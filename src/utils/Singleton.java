package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Singleton {
    public Connection cnx;
    private static Singleton  instance;
    private static String dsn = "jdbc:mariadb://127.0.0.1:3306/commandelabo";
    private static String username = "Admin";
    private static String password = "123+aze";


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

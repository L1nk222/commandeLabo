import DAO.DAOLaboratoire;
import entity.Laboratoire;
import utils.Singleton;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
public class Main {


    public static void TestFindLabo(){
        try  {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            DAOLaboratoire DAO = new DAOLaboratoire(cnx);
            Laboratoire Labo = DAO.find(2);
            System.out.println(Labo.getVille());

        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void TestFindAllLabo(){
        try {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            DAOLaboratoire DAO = new DAOLaboratoire(cnx);
            List<Laboratoire> labos = DAO.findAll();
            for (Laboratoire Labo : labos){
                System.out.println(Labo.getVille());
            }


        }
        catch (SQLException e){
            e.printStackTrace();


        }


    }

    public static void main(String[] args)    {
        System.out.println("Hello world!");
        TestFindLabo();
        TestFindAllLabo();
        }
}
import DAO.DAOCommande;
import entity.Commande;
import utils.Singleton;

import java.sql.SQLException;
import java.util.List;

public class MainTest {
    public static void TestFindAllCommande(){
        try {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            DAOCommande DAO = new DAOCommande(cnx);
            List<Commande> produits = DAO.findAll(0,100);
            for (Commande prod : produits){
                System.out.println(prod.getIdRecap());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        TestFindAllCommande();
    }
}


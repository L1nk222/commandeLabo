import DAO.DAOCommande;
import controller.ControllerTest;
import entity.Commande;
import utils.Singleton;

import java.sql.SQLException;
import java.util.List;
import views.FenetreTest;
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
    private static void AfficheTestFenetre(){
        FenetreTest f = new FenetreTest();
        f.setVisible(true);
        new ControllerTest(f);
        System.out.println("ça marche");
    }

    public static void main(String[] args){

        TestFindAllCommande();
        AfficheTestFenetre();

    }
}

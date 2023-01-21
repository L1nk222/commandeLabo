import DAO.DAOCommande;
import DAO.DAOProduit;
import controller.ControllerHistorique;
import controller.ControllerTest;
import controller.ControlleurTable;
import entity.Commande;
import entity.Produit;
import utils.Singleton;

import java.sql.SQLException;
import java.util.List;

import views.FenetreMain;
import views.FenetreTable;
import views.FenetreTest;
public class MainTest {
    public static void TestFindAllCommande(){
        try {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            DAOCommande DAO = new DAOCommande(cnx);
            List<Commande> produits = DAO.findAll(0,100);
            for (Commande prod : produits){
                System.out.println(prod.getIdCommande());
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
    private static void AfficheFenetre(){
        DAOCommande dao;
        try {
            FenetreMain f = new FenetreMain();
            //f.setVisible(true);
            dao = new DAOCommande(Singleton.getInstance().cnx);
            new ControllerHistorique(f,dao).init();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void TableaTest(){
        DAOCommande dao;
        try {

            dao = new DAOCommande(Singleton.getInstance().cnx);
            FenetreTable f = new FenetreTable();
            new ControlleurTable(f,dao).init();

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public static void FindAll(){
        try {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            DAOCommande DAO = new DAOCommande(cnx);
            List<Commande> produits = DAO.findAll(0,100);
            for (Commande commande : produits){
                System.out.println(commande.getDescriptionCommande());
                System.out.println(commande.getDateCommande());
                System.out.println(commande.getIdLabo());
                System.out.println(commande.getDateCommande());


            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){

        TestFindAllCommande();
        //AfficheTestFenetre();
        //AfficheFenetre();
        TableaTest();
        FindAll();
    }
}


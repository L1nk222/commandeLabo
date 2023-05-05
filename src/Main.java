import DAO.DAOCommande;
import DAO.DAOConnexion;
import DAO.DAOLaboratoire;
import DAO.DAOProduit;
import controller.ControllerConnexion;
import entity.Commande;
import entity.Laboratoire;
import entity.Produit;
import utils.Singleton;
import views.FenetreConnexion;
import views.FenetreMain;

import java.sql.SQLException;
import java.util.List;
public class Main {

//Voir interstellar
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
    public static void TestFindAllProduit(){
        try {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            DAOProduit DAO = new DAOProduit(cnx);
            List<Produit> produits = DAO.findAll(0,100);
            for (Produit prod : produits){
                System.out.println(prod.getMatricule());
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    /*public static void TestFindAllCommande(){
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
    }*/
    public static void  aled(){
        System.out.println("STP MAAAAAAAARCHE!");
    }

    public static void MainTest(){

        DAOLaboratoire daol;
        DAOConnexion daoc;
        try{
            daoc = new DAOConnexion(Singleton.getInstance().cnx);
            daol = new DAOLaboratoire(Singleton.getInstance().cnx);

            FenetreConnexion f=new FenetreConnexion();
            FenetreMain f2 = new FenetreMain();
            new ControllerConnexion(f,daoc,daol,f2).init();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void main(String[] args)    {
        System.out.println("Hello world!");
        //TestFindLabo();
        //TestFindAllLabo();
        //TestFindAllProduit();
        //TestSaveCommande();
        //TestFindAllCommande();
        MainTest();
        //aled();
    }
}
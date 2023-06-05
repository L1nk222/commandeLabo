import DAO.*;
import controller.ControllerConnexion;
import controller.ControllerStock;
import controller.ControllerVideStock;
import entity.Commande;
import entity.Laboratoire;
import entity.Produit;
import utils.Singleton;
import views.FenetreConnexion;
import views.FenetreMain;
import views.FenetreVideStock;

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
            FenetreVideStock f3 = new FenetreVideStock();
            new ControllerConnexion(f,daoc,daol,f2,f3).init();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public static void MainTest2(){
        DAOStock daos;
        DAOProduit daop;
        DAOLaboratoire daol;
        try{
            //daol = new DAOLaboratoire(Singleton.getInstance().cnx);
            FenetreVideStock f2 = new FenetreVideStock();
            //FenetreConnexion f=new FenetreConnexion();
             daos = new DAOStock(Singleton.getInstance().cnx);
             daop = new DAOProduit(Singleton.getInstance().cnx);
             daol = new DAOLaboratoire(Singleton.getInstance().cnx);

            f2.setVisible(true);
            System.out.println(daol.findByName("Winwood").getVille());
            System.out.println("ça doit marcher");
           new ControllerVideStock(daos,daop,f2,daol.findByName("Winwood")).init(); //f2.getComboLabo().getSelectedItem())).init()
            System.out.println("ça a marcher ?");
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void MainTest3(){

        //FenetreVideStock fenetreVideStock = new FenetreVideStock();
        //fenetreVideStock.setVisible(true);

        FenetreMain fenetreMain = new FenetreMain();
        fenetreMain.setVisible(true);
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
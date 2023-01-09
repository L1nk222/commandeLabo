import DAO.DAOCommande;
import DAO.DAOLaboratoire;
import DAO.DAOProduit;
import entity.Commande;
import controller.ControllerLabo;
import entity.Laboratoire;
import entity.Produit;
import utils.Singleton;
import views.FenetreCommande;
import views.FenetreLab;

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
    public static void TestSaveCommande(){
        try {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            DAOCommande DAO = new DAOCommande(cnx);
            DAO.save(new Commande(37,"20/01/2023","joli",3,7));

        }
        catch (SQLException e){
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
        DAOLaboratoire dao;
        try{
        dao = new DAOLaboratoire(Singleton.getInstance().cnx);
        FenetreLab f=new FenetreLab();
        FenetreCommande f2 = new FenetreCommande();
        new ControllerLabo(f,dao,f2).init();
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
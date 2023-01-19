package controller;

import DAO.DAOCommande;
import entity.Commande;
import views.FenetreMain;

import java.sql.SQLException;
import java.util.List;

public class ControllerHistorique {

    FenetreMain fenetreMain;
    DAOCommande daoCommande;



    public  ControllerHistorique(){


    }

    public void init(){
        try {
            List<Commande> commandes = daoCommande.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tableHitorique(){
        //fenetreMain.
    }


}

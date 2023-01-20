package controller;

import DAO.DAOCommande;
import entity.Commande;
import views.FenetreMain;

import java.sql.SQLException;
import java.util.List;

public class ControllerHistorique {

    FenetreMain fenetreMain;
    DAOCommande daoCommande;

    List<Commande> commandeList;
    MyDefaultTableModel mDTM;


    public  ControllerHistorique(FenetreMain fenetreMain, DAOCommande daoCommande){
        super();
        this.fenetreMain = fenetreMain;
        this.daoCommande = daoCommande;

    }

    public void init(){
        try {
            commandeList = daoCommande.findAll();
            mDTM = new MyDefaultTableModel(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
            fenetreMain.setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tableHitorique(){
        //fenetreMain.
    }


}

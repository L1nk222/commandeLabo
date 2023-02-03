package controller;

import DAO.DAOCommande;
import entity.Commande;
import views.FenetreTable;

import java.sql.SQLException;
import java.util.List;

public class ControlleurTable {

    FenetreTable fenetreTable;

    DAOCommande daoCommande;

    List<Commande> commandeList;

    ModelTableHistorique mDTM;

    public ControlleurTable(FenetreTable fenetreTable, DAOCommande daoCommande) {
        //super();
        this.fenetreTable = fenetreTable;
        this.daoCommande = daoCommande;
    }
    /*
    public void init(){
        try {

            commandeList = daoCommande.findAll();

            mDTM = new ModelTableHistorique(commandeList);
            fenetreTable.getTable1().setModel(mDTM);
            fenetreTable.setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
*/
}

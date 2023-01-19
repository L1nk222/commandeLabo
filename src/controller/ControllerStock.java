package controller;

import DAO.DAOStock;
import views.FenetreMain;

import javax.swing.*;

public class ControllerStock {

    DAOStock daoStock;
    JPanel panelStock;
    FenetreMain fenetre;


    public ControllerStock(DAOStock daoStock, JPanel panelStock, FenetreMain fenetre){
        this.daoStock = daoStock;
        this.panelStock = panelStock;
        this.fenetre = fenetre;



    }

}


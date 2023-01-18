package controller;

import DAO.DAOStock;
import views.FenetreMain;

import javax.swing.*;

public class ControllerStock {

    DAOStock daoStock;
    JPanel panelStock;
    FenetreMain fenetre1;

    public ControllerStock(DAOStock daoStock, JPanel panelStock, FenetreMain fenetre1){
        this.daoStock = daoStock;
        this.panelStock = panelStock;
        this.fenetre1 = fenetre1;


    }
    public void init(){
        fenetre1.setVisible(true);
    }
}


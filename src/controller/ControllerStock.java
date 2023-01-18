package controller;

import DAO.DAOStock;

import javax.swing.*;

public class ControllerStock {

    DAOStock daoStock;
    JPanel panelStock;

    public ControllerStock(DAOStock daoStock, JPanel panelStock){
        this.daoStock = daoStock;
        this.panelStock = panelStock;


    }
}

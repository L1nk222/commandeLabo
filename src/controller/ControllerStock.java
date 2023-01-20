package controller;

import DAO.DAOStock;
import entity.Stock;
import views.FenetreMain;
import javax.swing.*;
import  javax.swing.table.DefaultTableModel;
import  javax.swing.JTable;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.List;

public class ControllerStock {

    DAOStock daoStock;

    List<Stock> stocks;
    FenetreMain fenetre;

    ModelTableStock modelTable;

    public ControllerStock(DAOStock daoStock, FenetreMain fenetre) {
        this.daoStock = daoStock;
        this.fenetre = fenetre;

    }

        public void init() {
        try {
            stocks = daoStock.findAll();
            for (Stock stock: stocks
                 ) {
                System.out.println(stock);

            }
            modelTable = new ModelTableStock(stocks);
            fenetre.getTableStock().setModel(modelTable);
            System.out.println("fin");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }




    }}




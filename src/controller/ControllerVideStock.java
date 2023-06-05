package controller;

import DAO.DAOProduit;
import DAO.DAOStock;
import entity.Laboratoire;
import entity.Produit;
import entity.Stock;
import views.FenetreMain;
import views.FenetreVideStock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

public class ControllerVideStock {

    DAOStock daoStock;
    DAOProduit daoProduit;
    List<Stock> stocks;
    FenetreVideStock fenetreV;
    ModelTableStock modelTable;
    Laboratoire laboratoire;

    public ControllerVideStock(DAOStock daoStock, DAOProduit daoProduit, FenetreVideStock fenetreV, Laboratoire laboratoire) {
        this.daoStock = daoStock;
        this.fenetreV = fenetreV;
        this.laboratoire = laboratoire;
        this.daoProduit = daoProduit;

        fenetreV.getValideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                doValidation();
            }
        });

        fenetreV.getTableStock().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                doSelect();
                //System.out.println("c cliqued");

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });



    }
    private void doSelect(){

        try{
            int row =fenetreV.getTableStock().getSelectedRow();
            String produitSelect = (String) fenetreV.getTableStock().getValueAt(row,1);
            Produit produit = daoProduit.find(produitSelect);
            fenetreV.getDescriptionTextPane().setSize(100,100);
            fenetreV.getDescriptionTextPane().setMaximumSize(new Dimension(100,100));
            fenetreV.getLibelle().setText("Libelle:"+produit.getNom());
            fenetreV.getMatriculeLabel().setText("Matricule:"+ produit.getMatricule());
            fenetreV.getDescriptionTextPane().setText("Description:"+produit.getDescription());
            fenetreV.getPoidsLabel().setText("Poids:"+produit.getPoids());
            fenetreV.getIdFournisseurLabel().setText("idFournisseur:"+produit.getIdFournisseur());

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    private void doValidation()  {
        try {
            //Récupéré le nom du produit dans la combo box
            String produitSelect = (String) fenetreV.getComboBoxProduit().getSelectedItem();
            String[] matriculeProd = produitSelect.split(":");
            //Récupéré la quantité séléctionné  : fenetre.getTextQuantiter().getText()
            int quantite=0;
            if (fenetreV.getTextQuantiter().getText().matches("[0-9]{1,10}")) {
                quantite =Integer.parseInt(fenetreV.getTextQuantiter().getText());
            }

            //Utiliser : "updateQ" du DAO Stock
            daoStock.updateQ(daoStock.find(matriculeProd[0],laboratoire.getIdStock()),-quantite);
            //Faire un FindAll pour le tableau de stock
            initTableStock();

        }  catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();

    }

    }

    public void initTableStock(){
        try{

            stocks = daoStock.findStockBySearch(laboratoire);
            modelTable = new ModelTableStock(stocks);
            fenetreV.getTableStock().setModel(modelTable);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void init() {
        try {
            stocks = daoStock.findStockBySearch(laboratoire);
            for (Stock stock: stocks
                 ) {

                fenetreV.getComboBoxProduit().addItem(stock.getMatricule()+":"+stock.getNomProd());
            }
            initTableStock();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        System.out.println("avant setVisible");
        fenetreV.setVisible(true);
        System.out.println("après setVisible");

    }}




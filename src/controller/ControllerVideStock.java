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
    FenetreVideStock fenetre;
    ModelTableStock modelTable;
    Laboratoire laboratoire;

    public ControllerVideStock(DAOStock daoStock, DAOProduit daoProduit, FenetreVideStock fenetre, Laboratoire laboratoire) {
        this.daoStock = daoStock;
        this.fenetre = fenetre;
        this.laboratoire = laboratoire;
        this.daoProduit = daoProduit;

        fenetre.getValideButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                doValidation();
            }
        });

        fenetre.getTableStock().addMouseListener(new MouseListener() {
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
            int row =fenetre.getTableStock().getSelectedRow();
            String produitSelect = (String) fenetre.getTableStock().getValueAt(row,1);
            Produit produit = daoProduit.find(produitSelect);
            fenetre.getDescriptionTextPane().setSize(100,100);
            fenetre.getDescriptionTextPane().setMaximumSize(new Dimension(100,100));
            fenetre.getLibelle().setText("Libelle:"+produit.getNom());
            fenetre.getMatriculeLabel().setText("Matricule:"+ produit.getMatricule());
            fenetre.getDescriptionTextPane().setText("Description:"+produit.getDescription());
            fenetre.getPoidsLabel().setText("Poids:"+produit.getPoids());
            fenetre.getIdFournisseurLabel().setText("idFournisseur:"+produit.getIdFournisseur());

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    private void doValidation() {
        //Récupéré le nom du produit dans la combo box
        //Récupéré la quantité séléctionné  : fenetre.getTextQuantiter().getText()
        //Utiliser : "updateQ" du DAO Stock
        //Faire un FinAll pour le tableau de stock
    }

    public void initTableStock(){
        try{

            stocks = daoStock.findStockBySearch(laboratoire);
            modelTable = new ModelTableStock(stocks);
            fenetre.getTableStock().setModel(modelTable);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

    public void init() {
        try {
            stocks = daoStock.findAll();
            /*
            for (Stock stock: stocks
                 ) {
                System.out.println(stock.getMatricule());
            }*/
            initTableStock();
            System.out.println("fin ?");
            fenetre.setVisible(true);
            System.out.println("finte");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            fenetre.setVisible(true);
        }




    }}




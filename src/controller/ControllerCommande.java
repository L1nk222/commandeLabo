package controller;

import DAO.DAOCommande;
import DAO.DAOLigneCommande;
import DAO.DAOProduit;
import entity.Commande;
import entity.Laboratoire;
import entity.LigneCommande;
import entity.Produit;
import utils.Singleton;
import views.FenetreMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerCommande {

    DAOLigneCommande daoLigneCommande;
    DAOCommande daoCommande;
    FenetreMain fenetreMain;
    Laboratoire laboratoire;
    ModelTableCommande modelTable;

    List<LigneCommande>ligneCommandes = new ArrayList<>();

    public ControllerCommande(DAOLigneCommande daoLigneCommande, DAOCommande daoCommande, FenetreMain fenetreMain, Laboratoire laboratoire) {
        this.daoLigneCommande = daoLigneCommande;
        this.daoCommande = daoCommande;
        this.fenetreMain = fenetreMain;
        this.laboratoire = laboratoire;

        fenetreMain.getAjouterUneLigneButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doAddLigne();
            }
        });
        fenetreMain.getSupprimerUneLigneButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doSupprLigne();
            }
        });
        fenetreMain.getCommanderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCommander();
            }
        });

    }
    public void doSupprLigne(){

        //try {
            int row =fenetreMain.getTableLigneCommande().getSelectedRow();
            /*String matriculeSelect = (String) fenetreMain.getTableLigneCommande().getValueAt(row,2);
            LigneCommande ligneCommande =fenetreMain.getTableLigneCommande().get;
            System.out.println(ligneCommande.getNomProd());*/
            ligneCommandes.remove(row);
            /*daoLigneCommande.delete(ligneCommande);

            ligneCommandes = daoLigneCommande.findLigneByCommande(laboratoire, Integer.parseInt(fenetreMain.getIdLaboratoireLabel().getText()));
            */

            modelTable = new ModelTableCommande(ligneCommandes);
            fenetreMain.getTableLigneCommande().setModel(modelTable);
/*
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/

    }
    public void doCommander(){

        try {
            daoCommande.save(new Commande(Integer.parseInt(fenetreMain.getIdCommandeAutoLabel().getText()),null,
                    null,Integer.parseInt(fenetreMain.getIdLaboratoireLabel().getText())));

            for (LigneCommande lignecommande:ligneCommandes
                 ) {
                daoLigneCommande.save(lignecommande);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doAddLigne(){

            int idcommande = Integer.parseInt(fenetreMain.getIdCommandeAutoLabel().getText());
            String produit = (String) fenetreMain.getProduitCommande().getSelectedItem();
            int quantite = Integer.parseInt(fenetreMain.getQuantiteCommande().getText());
            String[] matriculeProd = produit.split(":");

            LigneCommande ligneCommande = new LigneCommande(idcommande,matriculeProd[0],matriculeProd[1],quantite);
            ligneCommandes.add(ligneCommande);
            /*
        try {
            if (daoCommande.find(idcommande)==null){
            daoCommande.save(new Commande(idcommande,null,
                    null,Integer.parseInt(fenetreMain.getIdLaboratoireLabel().getText())));}
            daoLigneCommande.save(new LigneCommande(idcommande,matriculeProd[0],matriculeProd[1],quantite));
            ligneCommandes = daoLigneCommande.findLigneByCommande(laboratoire,idcommande);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        modelTable = new ModelTableCommande(ligneCommandes);
        fenetreMain.getTableLigneCommande().setModel(modelTable);


    };

    public void init() {
        List<LigneCommande> ligneCommandes = new ArrayList<>();
        try {
            DAOProduit daoProduit = new DAOProduit(Singleton.getInstance().cnx);
            List<Produit> produits = daoProduit.findAll();

            for (Produit produit : produits) {
                fenetreMain.getProduitCommande().addItem(produit.getMatricule()+": "+produit.getNom());
            }
            List<Commande> commandes = daoCommande.findAll();
            fenetreMain.getIdCommandeAutoLabel().setText(String.valueOf(commandes.get(commandes.size()-1).getIdCommande()+1));
            fenetreMain.getIdLaboratoireLabel().setText(String.valueOf(laboratoire.getIdLabo()));
            LigneCommande ligneCommande = new LigneCommande(1,"vide","vide",1);
            ligneCommandes.add(ligneCommande);
            modelTable = new ModelTableCommande(ligneCommandes);
            fenetreMain.getTableLigneCommande().setModel(modelTable);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    };






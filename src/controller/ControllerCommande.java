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
import java.time.LocalDate;
import java.io.*;
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

            int row =fenetreMain.getTableLigneCommande().getSelectedRow();

            ligneCommandes.remove(row);

            modelTable = new ModelTableCommande(ligneCommandes);
            fenetreMain.getTableLigneCommande().setModel(modelTable);


    }
    public void doCommander(){

        try {
            daoCommande.save(new Commande(Integer.parseInt(fenetreMain.getIdCommandeAutoLabel().getText()),""+LocalDate.now(),
                    fenetreMain.getDescriptionTextAreaCommande().getText(),Integer.parseInt(fenetreMain.getIdLaboratoireLabel().getText())));

            for (LigneCommande lignecommande:ligneCommandes
                 ) {
                daoLigneCommande.save(lignecommande);
            }

            ligneCommandes.clear();
            init();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doAddLigne(){
        int quantite=0;
            if (fenetreMain.getQuantiteCommande().getText().matches("[0-9]{0,10}")) {
                 quantite =Integer.parseInt(fenetreMain.getQuantiteCommande().getText());
            }
            else { quantite = 10;}
            int idcommande = Integer.parseInt(fenetreMain.getIdCommandeAutoLabel().getText());
            //TODO verifier qu'il n'y est pas deux fois le meme produit
            String produit = (String) fenetreMain.getProduitCommande().getSelectedItem();

            String[] matriculeProd = produit.split(":");


        LigneCommande ligneCommande = new LigneCommande(idcommande,matriculeProd[0],matriculeProd[1],quantite);
        ligneCommandes.add(ligneCommande);

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
            //System.out.println("id de la derniere commande:"+commandes.get(commandes.size()-1).getIdCommande());
            fenetreMain.getIdCommandeAutoLabel().setText(String.valueOf(commandes.get(commandes.size()-1).getIdCommande()+1));
            //System.out.println(commandes.get(commandes.size()-1).getIdCommande());
            fenetreMain.getIdLaboratoireLabel().setText(String.valueOf(laboratoire.getIdLabo()));
            LigneCommande ligneCommande = new LigneCommande(0,"vide","vide",0);
            ligneCommandes.add(ligneCommande);
            modelTable = new ModelTableCommande(ligneCommandes);
            fenetreMain.getTableLigneCommande().setModel(modelTable);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    };






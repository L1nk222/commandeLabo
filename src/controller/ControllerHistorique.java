package controller;

import DAO.DAOCommande;
import DAO.DAOLigneCommande;
import entity.Commande;
import entity.LigneCommande;
import utils.Singleton;
import views.FenetreMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerHistorique {

    FenetreMain fenetreMain;
    DAOCommande daoCommande;
    DAOLigneCommande daoLigneCommande;
    List<Commande> commandeList;
    List<LigneCommande> lesCommandes;
    ModelTableHistorique mDTM;
    ModelTableListCommande mDTM2;
    String lastSearch;
    String donnerSearch;
    int produitSelect;


    public  ControllerHistorique(FenetreMain fenetreMain, DAOCommande daoCommande){
        super();
        this.fenetreMain = fenetreMain;
        this.daoCommande = daoCommande;
        daoLigneC();
        fenetreMain.getRechercheButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche();
            }
        });
        fenetreMain.getButtonResetHisto().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findAll();
            }
        });
        fenetreMain.getButtonEtatCommande().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BouttonValidationChangementEtatCommande();
            }
        });
        fenetreMain.getRefrecheButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Refreche();
            }
        });
        fenetreMain.getTableHistorique().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SelectTable();
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
////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

    public void init(){
        lastSearch = "all";
        Refreche();
        fenetreMain.setVisible(true);
        fenetreMain.getComboBoxEtatCommande().setSelectedIndex(4);
    }

    public void SelectTable(){
        try{
            int row =fenetreMain.getTableHistorique().getSelectedRow();
            produitSelect = (int) fenetreMain.getTableHistorique().getValueAt(row,0);
            String etatProd = (String) fenetreMain.getTableHistorique().getValueAt(row,3);
            //////////////////////////////////////////////////////
            lesCommandes = daoLigneCommande.findByAllId(produitSelect);

            mDTM2 = new ModelTableListCommande(lesCommandes);
            fenetreMain.getTableListCommande().setModel(mDTM2);

            selectBoxEtat(etatProd);

            fenetreMain.getJLabelidCommand().setText(String.valueOf(produitSelect));
            //  fenetreMain.getProduitLabel().setText(commande.getNom());

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void selectBoxEtat(String EtatCommande){
        if (EtatCommande.equals("En cours") ) {
            fenetreMain.getComboBoxEtatCommande().setSelectedIndex(0);
        } else if (EtatCommande.equals("Terminer")) {
            fenetreMain.getComboBoxEtatCommande().setSelectedIndex(1);
        } else if (EtatCommande.equals("Abandonner")) {
            fenetreMain.getComboBoxEtatCommande().setSelectedIndex(2);            
        } else if (EtatCommande.equals("En pause")) {
            fenetreMain.getComboBoxEtatCommande().setSelectedIndex(3);
        }else{
            fenetreMain.getComboBoxEtatCommande().setSelectedIndex(4);
        }
    }
    private void recherche(){
        String box = (String) fenetreMain.getComboBox1().getSelectedItem();
        String r = fenetreMain.getRechercheHistorique().getText();
        if (box.equals("Date")){
            dateR(r);
        } else if (box.equals("Id")) {
            idR(r);
        } else{
            findAll();
        }
    }
    private void idR(String id){
        donnerSearch = id;
        lastSearch = "idR";
        Refreche();
    }

    private void dateR(String r){
        lastSearch = "DateR";
        donnerSearch= r;
        Refreche();
    }

    private void findAll(){
        lastSearch = "all";
        Refreche();
    }
//////////////////////////////////////////////////////////////////////////
    private void daoLigneC(){
        try {
            daoLigneCommande = new DAOLigneCommande(Singleton.getInstance().cnx);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void BouttonValidationChangementEtatCommande()  {
        String boxEtat = (String) fenetreMain.getComboBoxEtatCommande().getSelectedItem();
        // produitSelect
        System.out.println("boxEtat :"+boxEtat);
        if (boxEtat.equals("Null")){
            boxEtat = null;
        }
        try {
            System.out.println("id Produit = "+produitSelect+"  Etat produit = "+boxEtat);
            daoCommande.updateEtat(boxEtat,produitSelect);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Commande effectuer");
        Refreche();


    }
    private void Refreche(){
        try {
            System.out.println("&& "+ lastSearch);
            /////////////////////////////////
            if (lastSearch.equals("all")){
                commandeList = daoCommande.findAll(0,100);
            } else if (lastSearch.equals("DateR")) {
                commandeList = daoCommande.findHitorique(donnerSearch,0,100);
            } else if (lastSearch.equals("idR")) {
                int id = Integer.parseInt(donnerSearch);
                commandeList = daoCommande.findAllById(id);
            }
            /////////////////////////////////
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mDTM = new ModelTableHistorique(commandeList);
        fenetreMain.getTableHistorique().setModel(mDTM);
    }

}

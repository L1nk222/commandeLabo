package controller;

import DAO.DAOCommande;
import DAO.DAOLigneCommande;
import DAO.DAOStock;
import entity.Commande;
import entity.Laboratoire;
import entity.LigneCommande;
import entity.Stock;
import utils.Singleton;
import views.FenetreMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

public class ControllerHistorique {

    FenetreMain fenetreMain;
    DAOCommande daoCommande;
    DAOStock daoStock;
    DAOLigneCommande daoLigneCommande;
    List<Commande> commandeList;
    List<LigneCommande> lesCommandes;
    ModelTableHistorique mDTM;
    ModelTableListCommande mDTM2;
    String lastSearch;
    String elementSearch;
    int produitSelect;
    Laboratoire laboratoire;

    Stock stock;

    public  ControllerHistorique(FenetreMain fenetreMain, DAOCommande daoCommande, DAOStock daoStock, Laboratoire laboratoire){
        super();
        this.fenetreMain = fenetreMain;
        this.daoCommande = daoCommande;
        this.laboratoire = laboratoire;
        this.daoStock = daoStock;
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
                Refresh();
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
        Refresh();
        //fenetreMain.setVisible(true);
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
        if (box.equals("Annee")){
            dateR(r);
        } else if (box.equals("Id")) {
            idR(r);
        } else{
            findAll();
        }
    }
    private void idR(String id){
        elementSearch = id;
        lastSearch = "idR";
        Refresh();
    }

    private void dateR(String r){
        lastSearch = "DateR";
        elementSearch= r;
        Refresh();
    }

    private void findAll(){
        lastSearch = "all";
        Refresh();
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
        //TODO quand etat est selectionner sur terminer ajouter la commande au stock
        String boxEtat = (String) fenetreMain.getComboBoxEtatCommande().getSelectedItem();
        // produitSelect
        System.out.println("boxEtat :"+boxEtat);
            if (boxEtat.equals("Null")){
            boxEtat = null;
        }

        try {
            System.out.println("id Produit = "+produitSelect+"  Etat produit = "+boxEtat);
            daoCommande.updateEtat(boxEtat,produitSelect);
            if (boxEtat.equals("Terminer")){
                int row =fenetreMain.getTableHistorique().getSelectedRow();
                produitSelect = (int) fenetreMain.getTableHistorique().getValueAt(row,0);
                System.out.println(produitSelect);
                for (LigneCommande ligneCommande: daoLigneCommande.findByAllId(produitSelect)
                     ) {
                       // if(daoStock.findAll(ligneCommande.getMatriculProd())== new Stock()){
                         //   save}
                    System.out.println("id commande"+(6));
                    System.out.println("matricule"+ligneCommande.getMatriculProd());
                        daoStock.update(new Stock( ligneCommande.getIdCommande(),ligneCommande.getMatriculProd(),
                                ligneCommande.getQuantiteProd(),0));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Commande effectuer");
        Refresh();
    }

    private void Refresh(){
        try {
            //System.out.println("&& "+ lastSearch);
            /////////////////////////////////
            if (lastSearch.equals("all")){
                commandeList = daoCommande.findAll(laboratoire);
            } else if (lastSearch.equals("DateR")) {
                if (elementSearch.equals("") ||elementSearch.equals(" ") ||elementSearch.equals(null) ){
                    commandeList = daoCommande.findAll(laboratoire);
                }else {
                    commandeList = daoCommande.findHistorique(elementSearch,laboratoire);
                }

            } else if (lastSearch.equals("idR")) {
                if (elementSearch.equals("") ||elementSearch.equals(" ") ||elementSearch.equals(null) ){
                    commandeList = daoCommande.findAll(laboratoire);
                }else {
                    int id = Integer.parseInt(elementSearch);
                    commandeList = daoCommande.findAllById(id,laboratoire);
                }

            }
            /////////////////////////////////
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        mDTM = new ModelTableHistorique(commandeList);
        fenetreMain.getTableHistorique().setModel(mDTM);
    }
}

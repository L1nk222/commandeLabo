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
        try {
            commandeList = daoCommande.findAll(0,2000);
            mDTM = new ModelTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
            fenetreMain.setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void SelectTable(){
        try{

            int row =fenetreMain.getTableHistorique().getSelectedRow();
            System.out.println("1 :"+row);
            int produitSelect = (int) fenetreMain.getTableHistorique().getValueAt(row,0);
            System.out.println("2 :"+produitSelect);
            //////////////////////////////////////////////////////

            lesCommandes = daoLigneCommande.findByAllId(produitSelect);
            System.out.println("3 :"+lesCommandes);

            mDTM2 = new ModelTableListCommande(lesCommandes);
            fenetreMain.getTableListCommande().setModel(mDTM2);


            fenetreMain.getJLabelidCommand().setText(String.valueOf(produitSelect));
            //  fenetreMain.getProduitLabel().setText(commande.getNom());

        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void recherche(){
        String box = (String) fenetreMain.getComboBox1().getSelectedItem();
        String r = fenetreMain.getRechercheHistorique().getText();
        System.out.println("|"+r+"| Truc entré par utilisateur");
        autoR(r);

        //intR();
    }
    private void autoR(String r){
        try {
            commandeList = daoCommande.findHitorique(r,0,100);
            System.out.println(commandeList);
            mDTM = new ModelTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }

    private void intR(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new ModelTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }

    private void dateR(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new ModelTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }
    private void etatR(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new ModelTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }
    private void findAll(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new ModelTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }
//////////////////////////////////////////////////////////////////////////
    private void daoLigneC(){
        try {
            daoLigneCommande = new DAOLigneCommande(Singleton.getInstance().cnx);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

package controller;

import DAO.DAOCommande;
import entity.Commande;
import views.FenetreMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class ControllerHistorique {

    FenetreMain fenetreMain;
    DAOCommande daoCommande;

    List<Commande> commandeList;
    DefaultTableHistorique mDTM;


    public  ControllerHistorique(FenetreMain fenetreMain, DAOCommande daoCommande){
        super();
        this.fenetreMain = fenetreMain;
        this.daoCommande = daoCommande;

        fenetreMain.getRechercheButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recherche();
            }
        });

    }

    public void init(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new DefaultTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
            fenetreMain.setVisible(true);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void tableHitorique(){
        //fenetreMain.
    }
    private void recherche(){
        String box = (String) fenetreMain.getComboBox1().getSelectedItem();
        String r = fenetreMain.getRechercheHistorique().getText();
        System.out.println(r+ "  NOOOOOO");
        //autoR(r);
        intR();
    }
    private void autoR(String r){
        try {
            commandeList = daoCommande.findHitorique(r,0,100);
            mDTM = new DefaultTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }

    private void intR(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new DefaultTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }

    private void dateR(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new DefaultTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }
    private void etatR(){
        try {
            commandeList = daoCommande.findAll(0,100);
            mDTM = new DefaultTableHistorique(commandeList);
            fenetreMain.getTableHistorique().setModel(mDTM);
        } catch (SQLException e1) {
            throw new RuntimeException(e1);
        }
    }



}

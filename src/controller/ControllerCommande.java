package controller;

import DAO.DAOCommande;
import DAO.DAOLigneCommande;
import entity.Laboratoire;
import views.FenetreMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerCommande {

    DAOLigneCommande daoLigneCommande;
    DAOCommande daoCommande;
    FenetreMain fenetreMain;
    Laboratoire laboratoire;

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

    }
    public void doAddLigne(){
        fenetreMain.add(new JButton("Bouton Test"));

        System.out.println("fct doAddLigne activation");

    };




}

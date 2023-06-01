package controller;

import DAO.DAOLaboratoire;
import DAO.DAOStock;
import entity.Laboratoire;
import entity.Stock;
import entity.User;
import views.FenetreCommande;
import views.FenetreConnexion;
import views.FenetreMain;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ControllerHome {

    DAOLaboratoire daol;
    FenetreMain fenetreMain;
    FenetreConnexion fenetreConnexion;
    Laboratoire laboratoire;
    Stock stock;
    DAOStock  daos;
    ModelTable modelTable;
    User user;

    public ControllerHome(DAOLaboratoire daol,DAOStock daos, FenetreMain fenetreMain, FenetreConnexion fenetreConnexion, Laboratoire laboratoire, User user) {
        this.daol = daol;
        this.fenetreMain = fenetreMain;
        this.fenetreConnexion = fenetreConnexion;
        this.laboratoire = laboratoire;
        this.user = user;
        this.daos =daos;


        fenetreMain.getBtnRefreshListAlert().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fillListAlert();
            }
        });
    }

    private void fillData() {
        fenetreMain.getNomLabo().setText(laboratoire.getNom());
        fenetreMain.getIdStockLabel().setText("" + laboratoire.getIdStock());
        fenetreMain.getEmailLabel().setText(laboratoire.getEmail());
        fenetreMain.getIdLaboLabel().setText("" + laboratoire.getIdLabo());
        fenetreMain.getAdresseLabel().setText(laboratoire.getAdresse());
        fenetreMain.getNumPhoneLabel().setText(laboratoire.getNumTelephone());
        fenetreMain.getVilleLaboLabel().setText(laboratoire.getVille());
        fenetreMain.getUserName().setText(user.getUsername());
    }

    private void fillListAlert(){
        try {

            List<Stock> stocks= daos.findStockByCritique(laboratoire);
            DefaultListModel<String> listStock= new DefaultListModel<>();
            for (Stock produit: stocks
                 ) {listStock.addElement("le produit : ["+produit.getMatricule()+"]"+produit.getNomProd()
                    +"est en dessous du seuil critique avec : "
                    +produit.getQuantiteProd()+" de quantité . Le seuil critique est de:"+produit.getSeuilCritique());
            }
            fenetreMain.getListeAlerte().setModel(listStock);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void init() {
        fillData();
        fillListAlert();
        /*
        try {
            image();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        ImageIcon icon = new ImageIcon("Steins_Gate_Labo.jpg");
        JLabel label = new JLabel(icon);

        fenetreMain.add(label);
        fenetreMain.pack();*/
        fenetreMain.setVisible(true);


    }
}
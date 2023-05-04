package controller;

import DAO.DAOLaboratoire;
import entity.Laboratoire;
import views.FenetreCommande;
import views.FenetreConnexion;
import views.FenetreMain;


import javax.imageio.ImageIO;
import javax.swing.*;
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
    ModelTable modelTable;


    public ControllerHome(DAOLaboratoire daol, FenetreMain fenetreMain, FenetreConnexion fenetreConnexion, Laboratoire laboratoire) {
        this.daol = daol;
        this.fenetreMain = fenetreMain;
        this.fenetreConnexion = fenetreConnexion;
        this.laboratoire = laboratoire;


    }

    private void fillData() {
        fenetreMain.getNomLabo().setText(laboratoire.getNom());
        fenetreMain.getIdStockLabel().setText("" + laboratoire.getIdStock());
        fenetreMain.getEmailLabel().setText(laboratoire.getEmail());
        fenetreMain.getIdLaboLabel().setText("" + laboratoire.getIdLabo());
        fenetreMain.getAdresseLabel().setText(laboratoire.getAdresse());
        fenetreMain.getNumPhoneLabel().setText(laboratoire.getNumTelephone());
        fenetreMain.getVilleLaboLabel().setText(laboratoire.getVille());
    }


    public void init() {
        fillData();
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
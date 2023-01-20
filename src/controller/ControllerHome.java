package controller;

import DAO.DAOLaboratoire;
import entity.Laboratoire;
import views.FenetreCommande;
import views.FenetreConnexion;
import views.FenetreMain;


import java.sql.SQLException;
import java.util.List;

public class ControllerHome {

    DAOLaboratoire daol;

    FenetreMain fenetreMain;
    FenetreConnexion fenetreConnexion;
    Laboratoire laboratoire;

    ModelTable modelTable;


    public ControllerHome(DAOLaboratoire daol, FenetreMain fenetreMain, FenetreConnexion fenetreConnexion,Laboratoire laboratoire){
        this.daol=daol;
        this.fenetreMain=fenetreMain;
        this.fenetreConnexion=fenetreConnexion;
        this.laboratoire=laboratoire;


    }
    private void fillData(){
        fenetreMain.getNomLabo().setText("Laboratoire :"+laboratoire.getNom());
        fenetreMain.getIdStockLabel().setText("Id stock :"+laboratoire.getIdStock());
        fenetreMain.getEmailLabel().setText("Email :"+laboratoire.getEmail());
        fenetreMain.getIdLaboLabel().setText("Id laboratoire :"+laboratoire.getIdLabo());
        fenetreMain.getAdresseLabel().setText("Adresse :"+laboratoire.getAdresse());
        fenetreMain.getNumPhoneLabel().setText("Numéro téléphone :"+laboratoire.getNumTelephone());
        fenetreMain.getVilleLaboLabel().setText("Ville :"+laboratoire.getVille());
    }


    public void init(){
        fillData();

        fenetreMain.setVisible(true);

    }
    }



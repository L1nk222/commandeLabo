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


    public ControllerHome(DAOLaboratoire daol, FenetreMain fenetreMain, FenetreConnexion fenetreConnexion,Laboratoire laboratoire){
        this.daol=daol;
        this.fenetreMain=fenetreMain;
        this.fenetreConnexion=fenetreConnexion;
        this.laboratoire=laboratoire;


    }
    private void fillData(){
        fenetreMain.getNomLabo().setText("Vous étes au laboratoire:"+laboratoire.getNom());
        fenetreMain.getIdStockLabel().setText("L'id du stock est :"+laboratoire.getIdStock());
        fenetreMain.getEmailLabel().setText("L'adresse email est :"+laboratoire.getEmail());
        fenetreMain.getIdLaboLabel().setText("L'id du laboratoire est :"+laboratoire.getIdLabo());
        fenetreMain.getAdresseLabel().setText("L'adresse du laboratoire est:"+laboratoire.getAdresse());
        fenetreMain.getNumPhoneLabel().setText("le numéro de téléphone est :"+laboratoire.getNumTelephone());
        fenetreMain.getVilleLaboLabel().setText("La ville du laboratoire est :"+laboratoire.getVille());
    }


    public void init(){
        fillData();
        fenetreMain.setVisible(true);

    }
    }



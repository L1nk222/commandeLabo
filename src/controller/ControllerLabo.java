package controller;

import DAO.DAOLaboratoire;
import views.FenetreCommande;
import views.FenetreLab;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerLabo {

    FenetreLab fenetre;
    FenetreCommande fenetre2;
    DAOLaboratoire daol;

    public ControllerLabo(FenetreLab fenetre, DAOLaboratoire daol,FenetreCommande fenetre2){
        super();
        this.fenetre=fenetre;
        this.daol=daol;
        this.fenetre2=fenetre2;

        fenetre.getCommandeButton().addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                doTest();

            }
        });

    }

    private void doTest(){
        System.out.println("ça marche");
        fenetre2.setVisible(true);
        fenetre.setVisible(false);




    }

    public void init(){
        fenetre.setVisible(true);
    }
}

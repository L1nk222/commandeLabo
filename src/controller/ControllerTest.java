package controller;

import views.FenetreTest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerTest {

    FenetreTest fenetre;
    public ControllerTest(FenetreTest fenetre) {
        this.fenetre= fenetre;

        fenetre.getStockButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.Stock();
            }
        });
        fenetre.getButtonCommande().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fenetre.Commande();
            }
        });
    }
}

package controller;

import views.FenetreImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

public class ControlleurTestImage {

    FenetreImage fenetreImage;

    public ControlleurTestImage(FenetreImage fenetreImage){
        this.fenetreImage = fenetreImage;
    }
    public void init(){
        afficheImage();
        fenetreImage.setSize(500,400);
        fenetreImage.setVisible(true);
    }
    public void afficheImage(){
//////////////////////////////////////////////////
//////////////////////////////////////////////////
        //ImageIcon icone = new ImageIcon("Steins_Gate_Labo.jpg");
        //fenetreImage.setPanel1().setIcon(icone);
        //URL de l'image
/*
        //fenetreImage.setLocationRelativeTo(null);
        String imgUrl="Steins_Gate_Labo.jpg";
        ImageIcon icone = new ImageIcon(imgUrl);

        JLabel jlabel = new JLabel(icone, JLabel.CENTER);
        fenetreImage.getContentPane().add(jlabel);
        //fenetreImage.setVisible(true);
        fenetreImage.validate();
*/
        JFrame frame = new JFrame("JLabel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530,600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //URL de l'image
        String imgUrl="MicrosoftTeams-image (1).png";
        ImageIcon icone = new ImageIcon(imgUrl);

        //Création de JLable avec un alignement gauche
        JLabel jlabel = new JLabel(icone, JLabel.CENTER);
        
        //ajouter les deux JLabel a JFrame
        frame.getContentPane().add(jlabel);
        frame.validate();

    }
}

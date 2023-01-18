package controller;

import DAO.DAOConnexion;
import DAO.DAOLaboratoire;
import entity.Laboratoire;
import views.FenetreCommande;
import views.FenetreConnexion;
import entity.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.sql.SQLException;
import java.util.List;

public class ControllerConnexion {
    FenetreConnexion fenetreCnx;
    DAOConnexion daoc;
    DAOLaboratoire daol;

    FenetreCommande fenetreCommande;

    public ControllerConnexion(FenetreConnexion fenetreCnx, DAOConnexion daoc, DAOLaboratoire daol, FenetreCommande fenetreCommande) {
        this.fenetreCnx = fenetreCnx;
        this.daoc = daoc;
        this.daol = daol;
        this.fenetreCommande = fenetreCommande;


        fenetreCnx.getValiderButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doValide();
            }
        });
    }


    public static byte[] getSHA(String input) throws NoSuchAlgorithmException
    {
        /* MessageDigest instance for hashing using SHA512*/
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        /* digest() method called to calculate message digest of an input and return array of byte */
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash)
    {
        /* Convert byte array of hash into digest */
        BigInteger number = new BigInteger(1, hash);

        /* Convert the digest into hex value */
        StringBuilder hexString = new StringBuilder(number.toString(16));

        /* Pad with leading zeros */
        while (hexString.length() < 32)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }
    private void doValide(){
        try {
            String username=fenetreCnx.getTextField1().getText();
            String password= fenetreCnx.getPasswordField1().getText();
            if (daoc.findByLogin(username)!=null){
            User user=daoc.findByLogin(username);
            //System.out.println(password);
            password = toHexString(getSHA(password));

            if(user.getPassword().equals(password)){
                //System.out.println("c passe");
                fenetreCnx.setVisible(false);
                fenetreCommande.setVisible(true);
            }
            //System.out.println(password);
            //System.out.println(user.getPassword());
            else{
                fenetreCnx.getMsgError().setText("Erreur mot de passe ou identifiant");
            }}else {
                fenetreCnx.getMsgError().setText("Erreur mot de passe ou identifiant");
            }

        }

        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }


    }
    public void init() {
        try {
            List<Laboratoire> Labos = daol.findAll();

            for (Laboratoire labo : Labos) {
                fenetreCnx.getComboLabo().addItem(labo.getVille());
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();


            fenetreCnx.setVisible(true);
        }
    }
}

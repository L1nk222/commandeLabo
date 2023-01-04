package views;

import javax.swing.*;

public class FenetreLab extends JFrame {
    private JComboBox comboBoxLabo;
    private JTextField rechercherTextField;
    private JTable tableStock;
    private JButton commandeButton;
    private JButton historiqueButton;
    private JButton validerButton;
    private JPanel mainPanel;




    public  FenetreLab(){
        setContentPane(mainPanel);
        setSize(10000,7000);
        comboBoxLabo.addItem("hello");
        comboBoxLabo.addItem("world");
       
        setVisible(true);
    }

    public static void main(String[] arg){
        FenetreLab mylab= new FenetreLab();
    }

}

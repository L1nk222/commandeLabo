package views;

import javax.swing.*;
import java.awt.*;

public class FenetreConnexion extends JFrame{
    private JButton validerButton;
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;

    public JLabel getMsgError() {
        return MsgError;
    }

    public void setMsgError(JLabel msgError) {
        MsgError = msgError;
    }

    private JComboBox ComboLabo;
    private JLabel MsgError;

    public JButton getValiderButton() {
        return validerButton;
    }

    public void setValiderButton(JButton validerButton) {
        this.validerButton = validerButton;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public void setPasswordField1(JPasswordField passwordField1) {
        this.passwordField1 = passwordField1;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JComboBox getComboLabo() {
        return ComboLabo;
    }

    public void setComboLabo(JComboBox comboLabo) {
        ComboLabo = comboLabo;
    }
    public FenetreConnexion(){
        setContentPane(panel1);
        setSize(300,240);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] arg){
        FenetreConnexion myConnexion= new FenetreConnexion();
    }
}

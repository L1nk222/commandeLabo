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

    public JComboBox getComboBoxLabo() {
        return comboBoxLabo;
    }

    public void setComboBoxLabo(JComboBox comboBoxLabo) {
        this.comboBoxLabo = comboBoxLabo;
    }

    public JTextField getRechercherTextField() {
        return rechercherTextField;
    }

    public void setRechercherTextField(JTextField rechercherTextField) {
        this.rechercherTextField = rechercherTextField;
    }

    public JTable getTableStock() {
        return tableStock;
    }

    public void setTableStock(JTable tableStock) {
        this.tableStock = tableStock;
    }

    public JButton getCommandeButton() {
        return commandeButton;
    }

    public void setCommandeButton(JButton commandeButton) {
        this.commandeButton = commandeButton;
    }

    public JButton getHistoriqueButton() {
        return historiqueButton;
    }

    public void setHistoriqueButton(JButton historiqueButton) {
        this.historiqueButton = historiqueButton;
    }

    public JButton getValiderButton() {
        return validerButton;
    }

    public void setValiderButton(JButton validerButton) {
        this.validerButton = validerButton;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public  FenetreLab(){
        setContentPane(mainPanel);
        setExtendedState(FenetreLab.MAXIMIZED_BOTH);
        comboBoxLabo.addItem("hello");
        comboBoxLabo.addItem("world");
       


    }

    public static void main(String[] arg){
        FenetreLab mylab= new FenetreLab();
    }

}

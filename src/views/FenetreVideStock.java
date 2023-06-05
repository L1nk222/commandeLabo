package views;

import javax.swing.*;

public class FenetreVideStock extends JFrame{
    private JTable tableStock;
    private JButton valideButton;
    private JComboBox comboBoxProduit;
    private JTextField textQuantiter;
    private JLabel matriculeLabel;
    private JLabel libelle;
    private JLabel poidsLabel;
    private JLabel idFournisseurLabel;
    private JTextPane descriptionTextPane;
    private JPanel panel1;

    public JTable getTableStock() {
        return tableStock;
    }

    public void setTableStock(JTable tableStock) {
        this.tableStock = tableStock;
    }

    public JButton getValideButton() {
        return valideButton;
    }

    public void setValideButton(JButton valideButton) {
        this.valideButton = valideButton;
    }

    public JComboBox getComboBoxProduit() {
        return comboBoxProduit;
    }

    public void setComboBoxProduit(JComboBox comboBoxProduit) {
        this.comboBoxProduit = comboBoxProduit;
    }

    public JTextField getTextQuantiter() {
        return textQuantiter;
    }

    public void setTextQuantiter(JTextField textQuantiter) {
        this.textQuantiter = textQuantiter;
    }

    public JLabel getMatriculeLabel() {
        return matriculeLabel;
    }

    public void setMatriculeLabel(JLabel matriculeLabel) {
        this.matriculeLabel = matriculeLabel;
    }

    public JLabel getLibelle() {
        return libelle;
    }

    public void setLibelle(JLabel libelle) {
        this.libelle = libelle;
    }

    public JLabel getPoidsLabel() {
        return poidsLabel;
    }

    public void setPoidsLabel(JLabel poidsLabel) {
        this.poidsLabel = poidsLabel;
    }

    public JLabel getIdFournisseurLabel() {
        return idFournisseurLabel;
    }

    public void setIdFournisseurLabel(JLabel idFournisseurLabel) {
        this.idFournisseurLabel = idFournisseurLabel;
    }

    public JTextPane getDescriptionTextPane() {
        return descriptionTextPane;
    }

    public void setDescriptionTextPane(JTextPane descriptionTextPane) {
        this.descriptionTextPane = descriptionTextPane;
    }

    public void setVisible(boolean b) {
    }
    public FenetreVideStock(){
        setContentPane(panel1);
        setSize(400,340);
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] arg){
        FenetreVideStock myConnexion= new FenetreVideStock();
    }
}

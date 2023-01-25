package views;

import javax.swing.*;

public class FenetreMain extends JFrame{
    private JTabbedPane tabbedPane1;

    public JLabel getNomLabo() {
        return nomLabo;
    }

    public void setNomLabo(JLabel nomLabo) {
        this.nomLabo = nomLabo;
    }

    private JPanel panel1;
    private JTextField rechercheHome;
    private JPanel Home;
    private JPanel Stock;
    private JPanel Historique;
    private JPanel Commande;
    private JTextField rechercheStock;
    private JTable tableStock;
    private JTextField rechercheHistorique;
    private JTable tableHistorique;
    private JTextField textField1;
    private JTable table1;
    private JTextArea textArea1;
    private JButton commanderButton;
    private JLabel nomLabo;
    private JLabel villeLaboLabel;
    private JLabel numPhoneLabel;
    private JLabel idLaboLabel;
    private JLabel adresseLabel;
    private JLabel emailLabel;
    private JLabel idStockLabel;
    private JScrollPane scrollPaneHistorique;
    private JButton rechercherButton;
    private JLabel produitLabel;
    private JButton rechercheButtonHisto;
    private JComboBox comboBoxHisto;
    private JButton buttonResetHisto;
    private JLabel JLabelidCommand;
    private JTable tableListCommande;
    private JScrollPane JScrollPaneListCommande;

    /////////////////////////////////////////////////////////////////////////////
    public  FenetreMain(){
        tabbedPane1.setSelectedComponent(Home);
        setContentPane(tabbedPane1);
        setSize(700,600);
        setExtendedState(FenetreLab.MAXIMIZED_BOTH);

    }
    public void home(){
        setContentPane(Home);
    }
    public void Stock(){
        tabbedPane1.setSelectedComponent(Stock);
        setContentPane(tabbedPane1);
    }
    public void Commande(){
        tabbedPane1.setSelectedComponent(Commande);
        setContentPane(tabbedPane1);

    }
    /////////////////////////////////////////////////////////////////////////////
    public JTabbedPane getTabbedPane1() {
        return tabbedPane1;
    }

    public void setTabbedPane1(JTabbedPane tabbedPane1) {
        this.tabbedPane1 = tabbedPane1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getRechercheHome() {
        return rechercheHome;
    }

    public void setRechercheHome(JTextField rechercheHome) {
        this.rechercheHome = rechercheHome;
    }

    public JPanel getHome() {
        return Home;
    }

    public void setHome(JPanel home) {
        Home = home;
    }

    public JPanel getStock() {
        return Stock;
    }

    public void setStock(JPanel stock) {
        Stock = stock;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JButton getCommanderButton() {
        return commanderButton;
    }

    public void setCommanderButton(JButton commanderButton) {
        this.commanderButton = commanderButton;
    }

    public JPanel getHistorique() {
        return Historique;
    }

    public void setHistorique(JPanel historique) {
        Historique = historique;
    }

    public JPanel getCommande() {
        return Commande;
    }

    public void setCommande(JPanel commande) {
        Commande = commande;
    }

    public JTextField getRechercheStock() {
        return rechercheStock;
    }

    public void setRechercheStock(JTextField rechercheStock) {
        this.rechercheStock = rechercheStock;
    }

    public JTable getTableStock() {
        return tableStock;
    }

    public void setTableStock(JTable tableStock) {
        this.tableStock = tableStock;
    }

    public JTextField getRechercheHistorique() {
        return rechercheHistorique;
    }

    public void setRechercheHistorique(JTextField rechercheHistorique) {
        this.rechercheHistorique = rechercheHistorique;
    }

    public JTable getTableHistorique() {
        return tableHistorique;
    }

    public void setTableHistorique(JTable tableHistorique) {
        this.tableHistorique = tableHistorique;
    }

    public JLabel getProduitLabel() {
        return produitLabel;
    }

    public void setProduitLabel(JLabel produitLabel) {
        this.produitLabel = produitLabel;
    }

    public JLabel getVilleLaboLabel() {
        return villeLaboLabel;
    }

    public void setVilleLaboLabel(JLabel villeLaboLabel) {
        this.villeLaboLabel = villeLaboLabel;
    }

    public JLabel getNumPhoneLabel() {
        return numPhoneLabel;
    }

    public void setNumPhoneLabel(JLabel numPhoneLabel) {
        this.numPhoneLabel = numPhoneLabel;
    }

    public JLabel getIdLaboLabel() {
        return idLaboLabel;
    }

    public void setIdLaboLabel(JLabel idLaboLabel) {
        this.idLaboLabel = idLaboLabel;
    }

    public JLabel getAdresseLabel() {
        return adresseLabel;
    }

    public void setAdresseLabel(JLabel adresseLabel) {
        this.adresseLabel = adresseLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }

    public JLabel getIdStockLabel() {
        return idStockLabel;
    }

    public void setIdStockLabel(JLabel idStockLabel) {
        this.idStockLabel = idStockLabel;
    }

    public JScrollPane getScrollPaneHistorique() {
        return scrollPaneHistorique;
    }

    public void setScrollPaneHistorique(JScrollPane scrollPaneHistorique) {
        this.scrollPaneHistorique = scrollPaneHistorique;
    }

    public JButton getRechercheButton() {
        return rechercheButtonHisto;
    }

    public void setRechercheButton(JButton rechercheButtonHisto) {
        this.rechercheButtonHisto = rechercheButtonHisto;
    }

    public JComboBox getComboBox1() {
        return comboBoxHisto;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBoxHisto = comboBox1;
    }

    public JButton getRechercherButton() {
        return rechercherButton;
    }

    public void setRechercherButton(JButton rechercherButton) {
        this.rechercherButton = rechercherButton;
    }

    public JButton getRechercheButtonHisto() {
        return rechercheButtonHisto;
    }

    public void setRechercheButtonHisto(JButton rechercheButtonHisto) {
        this.rechercheButtonHisto = rechercheButtonHisto;
    }

    public JButton getButtonResetHisto() {
        return buttonResetHisto;
    }

    public void setButtonResetHisto(JButton buttonResetHisto) {
        this.buttonResetHisto = buttonResetHisto;
    }

    public JLabel getJLabelidCommand() {
        return JLabelidCommand;
    }

    public void setJLabelidCommand(JLabel JLabelidCommand) {
        this.JLabelidCommand = JLabelidCommand;
    }

    public JTable getTableListCommande() {
        return tableListCommande;
    }

    public void setTableListCommande(JTable tableListCommande) {
        this.tableListCommande = tableListCommande;
    }

    public JScrollPane getJScrollPaneListCommande() {
        return JScrollPaneListCommande;
    }

    public void setJScrollPaneListCommande(JScrollPane JScrollPaneListCommande) {
        this.JScrollPaneListCommande = JScrollPaneListCommande;
    }
}

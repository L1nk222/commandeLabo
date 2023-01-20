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

    /////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args){
        JFrame frame = new JFrame("JTable Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable tableHistorique = creatTable();
        //frame.getContentPane().add(scrollPaneHistorique);
        frame.pack();
        frame.setVisible(true);
    }
// FULL TEST
    private static JTable creatTable() {
        String[] columnNames = {"Colonne 1", "Colonne 2"};
        Object[][] data = {{"Kathy", "Smith"},{"John", "Doe"}};
        JTable tableHistorique = new JTable(data,columnNames);

        tableHistorique.setFillsViewportHeight(true);

        return tableHistorique;

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

    public  FenetreMain(){
        tabbedPane1.setSelectedComponent(Home);
        setContentPane(tabbedPane1);
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
}

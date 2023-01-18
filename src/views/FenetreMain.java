package views;

import javax.swing.*;

public class FenetreMain {
    private JTabbedPane tabbedPane1;
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

    public  FenetreMain(){
        tabbedPane1.setSelectedComponent(Stock);
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

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
    private JTextField QuantiteCommande;
    private JTable tableLigneCommande;
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
    private JLabel libelle;
    private JButton rechercheButtonHisto;
    private JComboBox comboBoxHisto;
    private JLabel matriculeLabel;
    private JLabel descriptionLabel;
    private JLabel idFournisseurLabel;
    private JLabel poidsLabel;
    private JTextPane descriptionTextPane;
    private JButton ajouterUneLigneButton;
    private JButton supprimerUneLigneButton;
    private JComboBox produitCommande;
    private JLabel idCommandeAutoLabel;
    private JPanel commandePanel;
    private JLabel idLaboratoireLabel;
    private JTextArea descriptionTextArea;

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

    public JTextPane getDescriptionTextPane() {
        return descriptionTextPane;
    }

    public void setDescriptionTextPane(JTextPane descriptionTextPane) {
        this.descriptionTextPane = descriptionTextPane;
    }

    public JTextArea getDescriptionTextArea() {
        return descriptionTextArea;
    }

    public void setDescriptionTextArea(JTextArea descriptionTextArea) {
        this.descriptionTextArea = descriptionTextArea;
    }

    public JLabel getLibelle() {
        return libelle;
    }

    public void setLibelle(JLabel libelle) {
        this.libelle = libelle;
    }

    public JLabel getMatriculeLabel() {
        return matriculeLabel;
    }

    public void setMatriculeLabel(JLabel matriculeLabel) {
        this.matriculeLabel = matriculeLabel;
    }

    public JLabel getDescriptionLabel() {
        return descriptionLabel;
    }

    public JPanel getCommandePanel() {
        return commandePanel;
    }

    public void setCommandePanel(JPanel commandePanel) {
        this.commandePanel = commandePanel;
    }

    public JTextField getQuantiteCommande() {
        return QuantiteCommande;
    }

    public void setQuantiteCommande(JTextField quantiteCommande) {
        QuantiteCommande = quantiteCommande;
    }

    public JButton getAjouterUneLigneButton() {
        return ajouterUneLigneButton;
    }

    public void setAjouterUneLigneButton(JButton ajouterUneLigneButton) {
        this.ajouterUneLigneButton = ajouterUneLigneButton;
    }

    public JButton getSupprimerUneLigneButton() {
        return supprimerUneLigneButton;
    }

    public void setSupprimerUneLigneButton(JButton supprimerUneLigneButton) {
        this.supprimerUneLigneButton = supprimerUneLigneButton;
    }

    public JComboBox getProduitCommande() {
        return produitCommande;
    }

    public void setProduitCommande(JComboBox produitCommande) {
        this.produitCommande = produitCommande;
    }

    public JLabel getIdCommandeAutoLabel() {
        return idCommandeAutoLabel;
    }

    public void setIdCommandeAutoLabel(JLabel idCommandeAutoLabel) {
        this.idCommandeAutoLabel = idCommandeAutoLabel;
    }

    public void setDescriptionLabel(JLabel descriptionLabel) {
        this.descriptionLabel = descriptionLabel;
    }

    public JLabel getIdFournisseurLabel() {
        return idFournisseurLabel;
    }

    public void setIdFournisseurLabel(JLabel idFournisseurLabel) {
        this.idFournisseurLabel = idFournisseurLabel;
    }

    public JLabel getPoidsLabel() {
        return poidsLabel;
    }

    public void setPoidsLabel(JLabel poidsLabel) {
        this.poidsLabel = poidsLabel;
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
        return QuantiteCommande;
    }

    public void setTextField1(JTextField textField1) {
        this.QuantiteCommande = textField1;
    }

    public JTable getTable1() {
        return tableLigneCommande;
    }

    public void setTable1(JTable table1) {
        this.tableLigneCommande = table1;
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
        return libelle;
    }

    public void setProduitLabel(JLabel produitLabel) {
        this.libelle = produitLabel;
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

    public JLabel getIdLaboratoireLabel() {
        return idLaboratoireLabel;
    }

    public void setIdLaboratoireLabel(JLabel idLaboratoireLabel) {
        this.idLaboratoireLabel = idLaboratoireLabel;
    }

    public JTable getTableLigneCommande() {
        return tableLigneCommande;
    }

    public void setTableLigneCommande(JTable tableLigneCommande) {
        this.tableLigneCommande = tableLigneCommande;
    }
}

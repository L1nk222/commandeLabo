package views;

import javax.swing.*;

public class FenetreTest extends JFrame
{
    //Objet nomé dans le .form
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField textField1;
    private JTable table1;
    private JPanel Home;
    private JPanel Stock;
    private JPanel Commande;
    private JPanel Historique;
    private JButton buttonCommande;
    private JButton stockButton;

    public JButton getButtonCommande() {
        return buttonCommande;
    }

    public void setButtonCommande(JButton buttonCommande) {
        this.buttonCommande = buttonCommande;
    }

    public JButton getStockButton() {
        return stockButton;
    }

    public void setStockButton(JButton stockButton) {
        this.stockButton = stockButton;
    }



    //Utilisation et modification des Objet :
    public FenetreTest(){
        tabbedPane1.setSelectedComponent(Stock);
        setContentPane(tabbedPane1);
        setExtendedState(FenetreLab.MAXIMIZED_BOTH);

    }

    public void homme(){
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

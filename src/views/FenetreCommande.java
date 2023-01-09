package views;

import javax.swing.*;

public class FenetreCommande extends JFrame {
    private JPanel panelTest;
    private JButton buttonTest;
    private JLabel fakeTest;

    public FenetreCommande() {
        setContentPane(panelTest);
        setExtendedState(FenetreLab.MAXIMIZED_BOTH);


    }
}
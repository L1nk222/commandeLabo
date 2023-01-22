package views;

import javax.swing.*;

public class FenetreTable extends JFrame {
    private JTable table1;
    private JPanel panel1;

    ///////////////////////////////////////////////
    public FenetreTable(){
        setContentPane(panel1);
        setSize(1000,800);
        setResizable(false);
        setVisible(true);
    }
    public static void main (String[] args){
        FenetreTable maTable = new FenetreTable();
    }


    ///////////////////////////////////////////////

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }
}

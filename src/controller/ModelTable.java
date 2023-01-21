package controller;

import entity.Stock;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.util.List;


public class ModelTable extends JFrame {

    private JTable table;
    private MyTableModel tableModel;

    public ModelTable(List<Stock> stocks) {
        // Initialiser les données de la table
        String[] columnNames = {"idStock", "matricule", "quantiteProd","seuilCritique"};
        for (Stock stock:stocks
             ) {
            //Object[][] data = stock;

        }
        Object[][] data = {{"John", "Doe", 25}, {"Jane", "Doe", 23}};

        // Créer un modèle de table personnalisé
        tableModel = new MyTableModel(data, columnNames);

        // Créer la table en utilisant le modèle de table
        table = new JTable(tableModel);

        // Ajouter la table à un JScrollPane pour ajouter une barre de défilement
        //JScrollPane scrollPane = new JScrollPane(table);
        //add(scrollPane);

    }

    /*public static void main(String[] args) {
        new ModelTable();
    }*/

    // Classe interne pour définir un modèle de table personnalisé
    class MyTableModel extends AbstractTableModel {

        private Object[][] data;
        private String[] columnNames;

        public MyTableModel(Object[][] data, String[] columnNames) {
            this.data = data;
            this.columnNames = columnNames;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }
    }
}
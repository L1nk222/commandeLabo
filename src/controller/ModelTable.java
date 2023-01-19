package controller;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


public class ModelTable extends JFrame {

    private JTable table;
    private MyTableModel tableModel;

    public ModelTable() {
        // Initialiser les données de la table
        String[] columnNames = {"Nom", "Prénom", "Age"};
        Object[][] data = {{"John", "Doe", 25}, {"Jane", "Doe", 23}};

        // Créer un modèle de table personnalisé
        tableModel = new MyTableModel(data, columnNames);

        // Créer la table en utilisant le modèle de table
        table = new JTable(tableModel);

        // Ajouter la table à un JScrollPane pour ajouter une barre de défilement
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);

        setTitle("JTable Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ModelTable();
    }

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
package controller;

import entity.Commande;
import entity.Stock;
import javax.management.loading.PrivateClassLoader;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelTableStock extends DefaultTableModel {
    List<Stock> stocks;
    private String[] columNames = {"idStock", "matricule", "quantiteProd", "seuilCritique"};
    Set<Stock> modified;

    public ModelTableStock(List<Stock> stocks) {
        super();
        this.stocks = stocks;
        modified = new HashSet<Stock>();
    }

    @Override
    public void removeRow(int row) {
        super.removeRow(row);
    }


    @Override
    public int getRowCount() {
        return super.getRowCount();
    }


    @Override
    public int getColumnCount() {
        return super.getColumnCount();
    }


    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }


    @Override
    public boolean isCellEditable(int row, int column) {
        return super.isCellEditable(row, column);
    }


    @Override
    public Object getValueAt(int row, int column) {
        return super.getValueAt(row, column);
    }


    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column);
    }

}
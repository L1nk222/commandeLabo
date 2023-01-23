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
    private String[] columNames = {"idStock", "matricule","nom produit","quantiteProd", "seuilCritique"};
    HashSet<Stock> modified;

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
        if(stocks==null){
            return 0;
        }
        return stocks.size();
    }


    @Override
    public int getColumnCount() {
        return 5;
    }


    @Override
    public String getColumnName(int column) {
        return columNames[column];
    }


    @Override
    public boolean isCellEditable(int row, int column) {
        return (column > 4);
    }


    @Override
    public Object getValueAt(int row, int column) {
        Stock stock = stocks.get(row);
        Object value = null;

        switch (column) {
            case 0:
                value = stock.getIdStock();
                break;
            case 1:
                value = stock.getMatricule();
                break;
            case 2:
                value = stock.getNomProd();
                break;
            case 3:
                value = stock.getQuantiteProd();
                break;
            case 4:
                value = stock.getSeuilCritique();
                if (value == null){
                    value = "null";
                }
                break;
            default:
                break;
        }
        return value;
    }


    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Stock stock = stocks.get(row);
        Object value = null;

        switch (column) {
            case 0:
                stock.setIdStock((int)aValue);
                break;
            case 1:
                stock.setMatricule((String) aValue);
                break;
            case 2:
                stock.setNomProd((String) aValue);
                break;
            case 3:
                stock.setQuantiteProd((int) aValue);
                break;
            case 4:
                stock.setSeuilCritique((int) aValue);
                break;
            default:
                break;
        }

    }
    /**
     * Returns <code>Object.class</code> regardless of <code>columnIndex</code>.
     *
     * @param columnIndex the column being queried
     * @return the Object.class
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> type = null;
        switch (columnIndex) {
            case 0:
                type = Integer.class;
                break;
            case 1:
                type = String.class;
                break;
            case 2:
                type = String.class;
                break;
            case 3:
                type = String.class;
                break;
            case 4:
                type = String.class;
                break;
            default:
                break;
        }
        return type;
    }

}
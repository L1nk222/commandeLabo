package controller;

import entity.Commande;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class MyDefaultTableModel  extends DefaultTableModel {
    List<Commande> commandeList;
    private String[] columNames = {"idCommande","dateCommande"};
    HashSet<Commande> modified;

    public MyDefaultTableModel(List<Commande>commandeList){
        super();
        this.commandeList = commandeList;
        modified = new HashSet<Commande>();
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

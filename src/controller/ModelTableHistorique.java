package controller;

import entity.Commande;

import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;

public class ModelTableHistorique extends DefaultTableModel {
    List<Commande> commandeList;
    private String[] columNames = {"idCommande","DateCommande","DescriptionCommande","EtatCommande"};
    HashSet<Commande> modified;

    public ModelTableHistorique(List<Commande>commandeList){
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
        if(commandeList==null){
            return 0;
        }
        return commandeList.size();
    }


    @Override
    public int getColumnCount() {
        return 4;
    }


    @Override
    public String getColumnName(int column) {
        return columNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return (column > 0);
    }


    @Override
    public Object getValueAt(int row, int column) {
        Commande commande = commandeList.get(row);
        Object value = null;

        switch (column) {
            case 0:
                value = commande.getIdCommande();
                break;
            case 1:
                value = commande.getDateCommande();
                break;
            case 2:
                value = commande.getDescriptionCommande();
                break;
            case 3:
                value = commande.getEtatCommande();
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
        Commande commande = commandeList.get(row);
        Object value = null;

        switch (column) {
            case 0:
                commande.setIdCommande((int)aValue);
                break;
            case 1:
                commande.setDateCommande((String) aValue);
                break;
            case 2:
                commande.setDescriptionCommande((String) aValue);
                break;
            case 3:
                commande.setEtatCommande((String) aValue);
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
            default:
                break;
        }
        return type;
    }
}

package controller;


import entity.Commande;
import entity.LigneCommande;
import entity.Stock;
import javax.management.loading.PrivateClassLoader;
import javax.swing.table.DefaultTableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModelTableCommande extends DefaultTableModel {
    List<LigneCommande> ligneCommandes;
    private String[] columNames = {"idCommande", "matricule","nom produit","quantiteProd"};
    HashSet<LigneCommande> modified;

    public ModelTableCommande(List<LigneCommande> ligneCommandes) {
        super();
        this.ligneCommandes = ligneCommandes;
        modified = new HashSet<LigneCommande>();
    }

    @Override
    public void removeRow(int row) {
        super.removeRow(row);
    }


    @Override
    public int getRowCount() {
        if(ligneCommandes==null){
            return 0;
        }
        return ligneCommandes.size();
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
        return (column > 4);
    }


    @Override
    public Object getValueAt(int row, int column) {
        LigneCommande ligneCommande = ligneCommandes.get(row);
        Object value = null;

        switch (column) {
            case 0:
                value = ligneCommande.getIdCommande();
                break;
            case 1:
                value = ligneCommande.getMatriculProd();
                break;
            case 2:
                value = ligneCommande.getNomProd();
                break;
            case 3:
                value = ligneCommande.getQuantiteProd();
                break;
            default:
                break;
        }
        return value;
    }


    @Override
    public void setValueAt(Object aValue, int row, int column) {
        LigneCommande ligneCommande = ligneCommandes.get(row);
        Object value = null;

        switch (column) {
            case 0:
                ligneCommande.setIdCommande((int)aValue);
                break;
            case 1:
                ligneCommande.setMatriculProd((String) aValue);
                break;
            case 2:
                ligneCommande.setNomProd((String) aValue);
                break;
            case 3:
                ligneCommande.setQuantiteProd((int) aValue);
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
                type = Integer.class;
                break;

            default:
                break;
        }
        return type;
    }

}
package controller;

import DAO.DAOProduit;
import entity.LigneCommande;
import entity.Produit;
import utils.Singleton;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
public class ModelTableListCommande extends DefaultTableModel {
    List<LigneCommande> commandeList;
    DAOProduit daoProduit;
    Produit produit;
    private String[] columNames = {"Libellé","Matricul","Quantité"};
    HashSet<LigneCommande> modified;

    public ModelTableListCommande(List<LigneCommande>commandeList){
        super();
        this.commandeList = commandeList;
        modified = new HashSet<LigneCommande>();
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
        return 3;
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
        LigneCommande commande = commandeList.get(row);
        Object value = null;

        switch (column) {
            case 0:
                GetLibelle(commande);
                value = GetLibelle(commande);
                break;
            case 1:
                value = commande.getMatriculProd();
                break;
            case 2:
                value = commande.getQuantiteProd();
                break;
            default:
                break;
        }
        return value;
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
                type = String.class;
                break;
            case 1:
                type = String.class;
                break;
            case 2:
                type = Integer.class;
                break;
            default:
                break;
        }
        return type;
    }
    private String GetLibelle(LigneCommande commande){
        try {
            java.sql.Connection cnx = Singleton.getInstance().cnx;
            daoProduit = new DAOProduit(cnx);
            produit = daoProduit.find(commande.getMatriculProd());
            return produit.getNom();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

package DAO;

import entity.Laboratoire;
import entity.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProduit {

    private Connection cnx;

    public DAOProduit(Connection cnx) {
        this.cnx = cnx;
    }

    public Produit find(int id) throws SQLException {
        Produit produit = null;
        String SQL = "SELECT * FROM produit where idProduit=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            produit = new Produit();
            produit.setMatricule(rs.getString("matricule"));
            produit.setNom(rs.getString("nom"));
            produit.setDescription(rs.getString("description"));
            produit.setPoids(rs.getInt("poids"));
            produit.setIdFournisseur(rs.getInt("idFournisseur"));
        }

        return produit;
    }

    public List<Produit> findAll(int limit, int offset) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String SQL = "SELECT * FROM produit where idProduit limit ? offset ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(2, limit);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Produit produit = new Produit();
            produit.setMatricule(rs.getString("matricule"));
            produit.setNom(rs.getString("nom"));
            produit.setDescription(rs.getString("description"));
            produit.setPoids(rs.getInt("poids"));
            produit.setIdFournisseur(rs.getInt("idFournisseur"));

            produits.add(produit);
        }
        return produits;
    }

    public List<Produit>findAll() throws SQLException{
        return findAll(0,4000);
    }


}

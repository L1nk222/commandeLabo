package DAO;


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
        String SQL = "SELECT * FROM produit where matricule=?";
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
        String SQL = "SELECT * FROM produit ";
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

    public int count()throws SQLException{
        String SQL = "SELECT COUNT(matricule) FROM produit ";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public void save(Produit p) throws SQLException {
        String SQL = "INSERT INTO produit(matricule,nom,description,poids,idFournisseur) VALUES(?,?,?,?,?);";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, p.getMatricule());
        ps.setString(2, p.getNom());
        ps.setString(3, p.getDescription());
        ps.setInt(4, p.getPoids());
        ps.setInt(5, p.getIdFournisseur());
        ps.executeQuery();

    }
    public void update(Produit p) throws SQLException {
        String SQL = "UPDATE produit SET matricule=?, nom=?, description=?, poids=?, idFournisseur=? WHERE matricule=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, p.getMatricule());
        ps.setString(2, p.getNom());
        ps.setString(3, p.getDescription());
        ps.setInt(4, p.getPoids());
        ps.setInt(5, p.getIdFournisseur());
        ps.executeQuery();
    }



    public void delete(Produit p) throws SQLException {
        String matricule = p.getMatricule(); ;
        String SQL ="DELETE FROM produit WHERE matricule=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, matricule);
        ps.executeQuery();
    }



}

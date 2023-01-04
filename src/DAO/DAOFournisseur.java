package DAO;

import entity.Fournisseur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOFournisseur {

    private Connection cnx;

    public DAOFournisseur(Connection cnx){
        this.cnx = cnx;
    }

    public Fournisseur find(int id) throws SQLException {
        Fournisseur fournisseur =null;
        String SQL= "SELECT * FROM fournisseurs where idFournisseur=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            fournisseur = new Fournisseur();
            fournisseur.setIdFournisseur(rs.getInt("idFournisseur"));
            fournisseur.setNom(rs.getString("nom"));
            fournisseur.setEmail(rs.getString("email"));
            fournisseur.setAdresse(rs.getString("adresse"));
        }
        return fournisseur;

    }

    public List<Fournisseur> findAll(int limit, int offset)throws SQLException{
        List<Fournisseur> fournisseurs = new ArrayList<>();
        String SQL= "SELECT * FROM fournisseurs where idFournisseur limit ? offset ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(2, limit);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Fournisseur fournisseur= new Fournisseur();
            fournisseur.setIdFournisseur(rs.getInt("idFournisseur"));
            fournisseur.setNom(rs.getString("nom"));
            fournisseur.setEmail(rs.getString("email"));
            fournisseur.setAdresse(rs.getString("adresse"));
            fournisseurs.add(fournisseur);

        }

        return fournisseurs;

    }

    public List<Fournisseur>findAll() throws SQLException{
        return findAll(0,4000);
    }
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Commande;
import entity.LigneComande;

public class DAOListeCommande {
    private Connection cnx;

    public DAOListeCommande(Connection cnx) {this.cnx = cnx;}

    public LigneComande findById(int idCommande) throws SQLException {
        LigneComande commande = null;
        String SQL = "SELECT * FROM ligneCommande where idCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, idCommande);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            commande = new LigneComande();
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setMatriculProd(rs.getString("matriculeProd"));
            commande.setQuantiteProd(rs.getInt("descriptionCommande"));

        }

        return commande;
    }
    public List<LigneComande> findAll(int limit, int offset) throws SQLException{
        List<LigneComande> commandes = new ArrayList<>();
        String SQL = "SELECT * FROM ligneCommande LIMIT ? OFFSET ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(1, limit);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            LigneComande commande = new LigneComande();
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setMatriculProd(rs.getString("matriculeProd"));
            commande.setQuantiteProd(rs.getInt("descriptionCommande"));

            commandes.add(commande);

        }
        return commandes;
    }
    public List<LigneComande> findAll()throws SQLException{
        return findAll(0,4000);
    }
    public void save(LigneComande c) throws SQLException{
        String SQL= "INSERT INTO ligneCommande (IdCommande, MatriculProd, QuantiteProd) VALUES (?,?,?);";
        PreparedStatement ps =cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande() );
        ps.setString(2,c.getMatriculProd() );
        ps.setInt(3, c.getQuantiteProd());

        ps.executeQuery();

    }

    public void update(LigneComande c) throws SQLException {
        String SQL = "UPDATE ligneCommande SET IdCommande=?, MatriculProd=?,QuantiteProd=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande());
        ps.setString(2,c.getMatriculProd() );
        ps.setInt(3, c.getQuantiteProd());

        ps.executeQuery();

    }

    public void delete(LigneComande c) throws SQLException{
        int IdCommande =  c.getIdCommande();
        String SQL ="DELETE FROM ligneCommande WHERE IdCommande =?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1,IdCommande);
        ps.executeQuery();
    }




}

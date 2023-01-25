package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.LigneCommande;

public class DAOLigneCommande {
    private Connection cnx;

    public DAOLigneCommande(Connection cnx) {this.cnx = cnx;}

    public LigneCommande findById(int idCommande) throws SQLException {
        LigneCommande commande = null;
        String SQL = "SELECT * FROM ligneCommande where idCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, idCommande);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            commande = new LigneCommande();
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setMatriculProd(rs.getString("matriculeProd"));
            commande.setQuantiteProd(rs.getInt("quantiteProd"));

        }
        return commande;
    }
    public List<LigneCommande> findByAllId(int idCommande) throws SQLException {
        List<LigneCommande> commandes = new ArrayList<>();
        LigneCommande commande = null;
        String SQL = "SELECT * FROM ligneCommande where idCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, idCommande);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            commande = new LigneCommande();
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setMatriculProd(rs.getString("matriculeProd"));
            commande.setQuantiteProd(rs.getInt("quantiteProd"));

            commandes.add(commande);

        }
        return commandes;
    }
    public List<LigneCommande> findAll(int limit, int offset) throws SQLException{
        List<LigneCommande> commandes = new ArrayList<>();
        String SQL = "SELECT * FROM ligneCommande LIMIT ? OFFSET ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(1, limit);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            LigneCommande commande = new LigneCommande();
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setMatriculProd(rs.getString("matriculeProd"));
            commande.setQuantiteProd(rs.getInt("quantiteProd"));

            commandes.add(commande);

        }
        return commandes;
    }
    public List<LigneCommande> findAll()throws SQLException{
        return findAll(0,4000);
    }
    public void save(LigneCommande c) throws SQLException{
        String SQL= "INSERT INTO ligneCommande (IdCommande, MatriculProd, QuantiteProd) VALUES (?,?,?);";
        PreparedStatement ps =cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande() );
        ps.setString(2,c.getMatriculProd() );
        ps.setInt(3, c.getQuantiteProd());

        ps.executeQuery();

    }

    public void update(LigneCommande c) throws SQLException {
        String SQL = "UPDATE ligneCommande SET IdCommande=?, MatriculProd=?,QuantiteProd=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande());
        ps.setString(2,c.getMatriculProd() );
        ps.setInt(3, c.getQuantiteProd());

        ps.executeQuery();

    }

    public void delete(LigneCommande c) throws SQLException{
        int IdCommande =  c.getIdCommande();
        String SQL ="DELETE FROM ligneCommande WHERE IdCommande =?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1,IdCommande);
        ps.executeQuery();
    }




}

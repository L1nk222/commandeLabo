package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Laboratoire;
import entity.LigneCommande;
import entity.Stock;

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
    public LigneCommande findByMatricule(String matricule) throws SQLException {
        LigneCommande commande = null;
        String SQL = "SELECT * FROM ligneCommande where matriculeProd=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, matricule);
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
        String SQL= "INSERT INTO ligneCommande (idCommande, matriculeProd, quantiteProd) VALUES (?,?,?);";
        PreparedStatement ps =cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande() );
        ps.setString(2,c.getMatriculProd() );
        ps.setInt(3, c.getQuantiteProd());

        ps.executeQuery();

    }

    public void update(LigneCommande c) throws SQLException {
        String SQL = "UPDATE ligneCommande SET idCommande=?, matriculeProd=?,quantiteProd=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande());
        ps.setString(2,c.getMatriculProd() );
        ps.setInt(3, c.getQuantiteProd());

        ps.executeQuery();

    }

    public void delete(LigneCommande c) throws SQLException{
        String matriculProd =  c.getMatriculProd();
        String SQL ="DELETE FROM ligneCommande WHERE matriculeProd =?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1,matriculProd);
        ps.executeQuery();
    }

    public List<LigneCommande> findLigneByCommande(Laboratoire laboratoire, int idCommande) throws SQLException{
        List<LigneCommande> ligneCommandes = new ArrayList<>();
        String SQL = "SELECT * FROM lignecommande,Produit,laboratoire,commande where nom= ? AND lignecommande.idCommande =? AND commande.idLabo=laboratoire.idLabo " +
                " AND lignecommande.idCommande=commande.idCommande AND lignecommande.matriculeProd=produit.matricule";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, laboratoire.getNom());
        ps.setInt(2,idCommande);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            LigneCommande ligneCommande = new LigneCommande();
            ligneCommande.setIdCommande(rs.getInt("idCommande"));
            ligneCommande.setMatriculProd(rs.getString("matriculeProd"));
            ligneCommande.setNomProd(rs.getString("libelle"));
            ligneCommande.setQuantiteProd(rs.getInt("quantiteProd"));
            ligneCommandes.add(ligneCommande);

        }
        return ligneCommandes;
    }




}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Commande;
import entity.Produit;

public class DAOCommande {
    private Connection cnx;

    public DAOCommande(Connection cnx) {
        this.cnx = cnx;
    }

    public Commande findByDate(String dateX) throws SQLException{
        Commande commande = null;
        String SQL = "SELECT * FROM commande where dateCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, dateX);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            commande = new Commande();
            commande.setIdRecap(rs.getInt("idRecap"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setDescriptionCommande(rs.getString("descriptionCommande"));
            commande.setIdComande(rs.getInt("idCommande"));
            commande.setIdLabo(rs.getInt("idLabo"));
        }

        return commande;
    }
    public List<Commande> findAll(int limit, int offset) throws SQLException{
        List<Commande> commandes = new ArrayList<>();
        String SQL = "SELECT * FROM commande LIMIT ? OFFSET ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(2, limit);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Commande commande = new Commande();
            commande.setIdRecap(rs.getInt("idRecap"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setDescriptionCommande(rs.getString("descriptionCommande"));
            commande.setIdComande(rs.getInt("idCommande"));
            commande.setIdLabo(rs.getInt("idLabo"));


            commandes.add(commande);

        }
        return commandes;
    }
    public List<Commande> findAll()throws SQLException{
        return findAll(0,4000);
    }

    public void save(Commande c) throws SQLException{
        String SQL= "INSERT INTO commande (dateCommande, descriptionCommande, idCommande, idLabo) VALUES (?,?,?,?);";
        PreparedStatement ps =cnx.prepareStatement(SQL);
        ps.setString(1,c.getDateCommande() );
        ps.setString(2,c.getDescriptionCommande() );
        ps.setInt(3, c.getIdComande());
        ps.setInt(4, c.getIdLabo());
        ps.executeQuery();

    }

    public void update(Commande c) throws SQLException {
        String SQL = "UPDATE commande SET idRecap=?, dateCommande=?,descriptionCommande=?, idCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdRecap());
        ps.setString(2, c.getDateCommande());
        ps.setString(3,c.getDescriptionCommande() );
        ps.setInt(4, c.getIdComande());
        ps.setInt(5, c.getIdLabo());
        ps.executeQuery();

    }

    public void delete(Commande c) throws SQLException{
    int idRecap =  c.getIdRecap();
    String SQL ="DELETE FROM command WHERE idRecap =?";
    PreparedStatement ps = cnx.prepareStatement(SQL);
    ps.setInt(1,idRecap);
    ps.executeQuery();
    }

}

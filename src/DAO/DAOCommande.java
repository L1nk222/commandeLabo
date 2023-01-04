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
        }

        return commande;
    }
    public List<Commande> findAll(int limit, int offset) throws SQLException{
        List<Commande> commandes = new ArrayList<>();
        String SQL = "SELECT * FROM commande LIMIT ? OFFSET ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(1, limit);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Commande commande = new Commande();
            commande.setIdRecap(rs.getInt("idRecap"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setDescriptionCommande(rs.getString("descriptionCommande"));
            commande.setIdComande(rs.getInt("idCommande"));

            commandes.add(commande);

        }
        return commandes;
    }
}

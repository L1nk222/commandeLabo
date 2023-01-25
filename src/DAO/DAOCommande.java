package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Commande;

public class DAOCommande {
    private Connection cnx;

    public DAOCommande(Connection cnx) {
        this.cnx = cnx;
    }

    public Commande findById(int idC) throws SQLException{
        Commande commande = null;
        String SQL = "SELECT * FROM commande where dateCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, idC);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            commande = new Commande();
            commande.setEtatCommande(rs.getString("etatCommande"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setDescriptionCommande(rs.getString("descriptionCommande"));
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setIdLabo(rs.getInt("idLabo"));
        }

        return commande;
    }

    public Commande find(int id) throws SQLException{

        Commande commande = null;
        String SQL = "SELECT * FROM commande where idCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            commande = new Commande();
            commande.setEtatCommande(rs.getString("etatCommande"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setDescriptionCommande(rs.getString("descriptionCommande"));
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setIdLabo(rs.getInt("idLabo"));
        }

        return commande;
    }
    public List<Commande> findAll(int limit, int offset) throws SQLException{
        List<Commande> commandes = new ArrayList<>();
        String SQL = "SELECT * FROM commande ORDER BY dateCommande DESC LIMIT ? OFFSET ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(2, limit);
        ResultSet rs = ps.executeQuery();

        while (rs.next()){
            Commande commande = new Commande();
            commande.setEtatCommande(rs.getString("etatCommande"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setDescriptionCommande(rs.getString("descriptionCommande"));
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setIdLabo(rs.getInt("idLabo"));


            commandes.add(commande);

        }
        return commandes;
    }
    public List<Commande> findAll()throws SQLException{
        return findAll(0,2000);
    }
    public List<Commande> findHitorique(String recheche, int limit, int offset) throws SQLException{
        List<Commande> commandes = new ArrayList<>();
        //recheche = "%"+recheche+"%";
        System.out.println("DAO var Recherche : "+recheche);
        String SQL = "SELECT * FROM commande where dateCommande = '%'+?+'%' ORDER BY dateCommande DESC"; //ORDER BY dateCommande DESC
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1,recheche);
        //ps.setInt(3, offset);
        //ps.setInt(2, limit);
        System.out.println("1 "+ps);
        ResultSet rs = ps.executeQuery();

        System.out.println(rs);
        System.out.println(rs.next());
        while (rs.next()) {

            Commande commande = new Commande();
            commande.setEtatCommande(rs.getString("etatCommande"));
            commande.setDateCommande(rs.getString("dateCommande"));
            commande.setDescriptionCommande(rs.getString("descriptionCommande"));
            commande.setIdCommande(rs.getInt("idCommande"));
            commande.setIdLabo(rs.getInt("idLabo"));

            System.out.println("2");
            commandes.add(commande);
        }
        System.out.println("3");
        System.out.println("commandes :" +commandes);
        return commandes;

    }
    public List<Commande> findHitorique(String recheche) throws SQLException {
        return findHitorique(recheche, 0,400);
    }


    public void save(Commande c) throws SQLException{
        String SQL= "INSERT INTO commande (idCommande,dateCommande, descriptionCommande, etatCommande, idLabo) VALUES (?,?,?,?,?);";
        PreparedStatement ps =cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande());
        ps.setString(2,c.getDateCommande() );
        ps.setString(3,c.getDescriptionCommande() );
        ps.setString(4, c.getEtatCommande());
        ps.setInt(5, c.getIdLabo());
        ps.executeQuery();

    }

    public void update(Commande c) throws SQLException {
        String SQL = "UPDATE commande SET idCommande=?, dateCommande=?,descriptionCommande=?, etatCommande=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1,c.getIdCommande());
        ps.setString(2, c.getDateCommande());
        ps.setString(3,c.getDescriptionCommande() );
        ps.setString(4, c.getEtatCommande());
        ps.setInt(5, c.getIdLabo());
        ps.executeQuery();

    }

    public void delete(Commande c) throws SQLException{
    int idRecap =  c.getIdCommande();
    String SQL ="DELETE FROM command WHERE idCommande =?";
    PreparedStatement ps = cnx.prepareStatement(SQL);
    ps.setInt(1,idRecap);
    ps.executeQuery();
    }

}

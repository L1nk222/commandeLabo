package DAO;

import entity.Laboratoire;
import entity.Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOStock {

    private Connection cnx;

    public DAOStock(Connection cnx) {
        this.cnx = cnx;
    }

    public Stock find(int id) throws SQLException {
        Stock stock = null;
        String SQL = "SELECT * FROM produit where matricule=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            stock = new Stock();
            stock.setIdStock(rs.getInt("idStock"));
            stock.setMatricule(rs.getString("matricule"));
            stock.setNomProd(rs.getString("libelle"));
            stock.setQuantiteProd(rs.getInt("quantiteProd"));
            stock.setSeuilCritique(rs.getInt("seuilCritique"));

        }

        return stock;
    }

    public List<Stock> findAll(int limit, int offset) throws SQLException {
        List<Stock> stocks = new ArrayList<>();
        String SQL = "SELECT * FROM stock where idStock limit ? offset ?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, offset);
        ps.setInt(2, limit);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Stock stock = new Stock();
            stock.setIdStock(rs.getInt("idStock"));
            stock.setMatricule(rs.getString("matricule"));
            stock.setQuantiteProd(rs.getInt("quantiteProd"));
            stock.setSeuilCritique(rs.getInt("seuilCritique"));

            stocks.add(stock);

        }
        return stocks;
    }
    public List<Stock>findAll() throws SQLException{
        return findAll(0,4000);
    }

    public List<Stock> findStockBySearch(Laboratoire laboratoire) throws SQLException{
        List<Stock> stocks = new ArrayList<>();
        String SQL = "SELECT * FROM stock,laboratoire,produit where nom= ? AND stock.idStock=laboratoire.idStock AND " +
                "stock.matricule=produit.matricule;";

        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, laboratoire.getNom());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Stock stock = new Stock();
            stock.setIdStock(rs.getInt("idStock"));
            stock.setMatricule(rs.getString("matricule"));
            stock.setNomProd(rs.getString("libelle"));
            stock.setQuantiteProd(rs.getInt("quantiteProd"));
            stock.setSeuilCritique(rs.getInt("seuilCritique"));
            stocks.add(stock);

        }
        return stocks;
    }
    public List<Stock> findStockBySearch(Laboratoire laboratoire, String value) throws SQLException{
        List<Stock> stocks = new ArrayList<>();
         value = "%"+value+"%";
        String SQL = "SELECT * FROM stock,laboratoire,produit where nom= ? AND (stock.matricule LIKE ? OR produit.libelle LIKE ?) AND stock.idStock=laboratoire.idStock " +
                " AND stock.matricule=produit.matricule";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, laboratoire.getNom());
        ps.setString(2,value);
        ps.setString(3,value);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Stock stock = new Stock();
            stock.setIdStock(rs.getInt("idStock"));
            stock.setMatricule(rs.getString("matricule"));
            stock.setNomProd(rs.getString("libelle"));
            stock.setQuantiteProd(rs.getInt("quantiteProd"));
            stock.setSeuilCritique(rs.getInt("seuilCritique"));

            stocks.add(stock);

        }
        return stocks;
    }

    }



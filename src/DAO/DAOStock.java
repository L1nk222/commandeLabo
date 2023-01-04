package DAO;

import entity.Laboratoire;
import entity.Produit;
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
        String SQL = "SELECT * FROM produit where idProduit=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            stock = new Stock();
            stock.setIdStock(rs.getInt("idStock"));
            stock.setMatricule(rs.getString("matricule"));
            stock.setQuantiteProd(rs.getInt("quantiteProd"));


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

            stocks.add(stock);

        }
        return stocks;
    }
    public List<Stock>findAll() throws SQLException{
        return findAll(0,4000);
    }

}

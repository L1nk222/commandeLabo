package DAO;

import entity.Laboratoire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class DAOLaboratoire {
    private Connection cnx;

    public DAOLaboratoire(Connection cnx){
        this.cnx = cnx;
    }

    public Laboratoire find(int id) throws SQLException {
        Laboratoire labo =null;
        String SQL= "SELECT * FROM laboratoire where idLabo=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            labo = new Laboratoire();
            labo.setIdLabo(rs.getInt("idLabo"));
            labo.setVille(rs.getString("ville"));
            labo.setIdStock(rs.getInt("idStock"));
        }
        return labo;

        }

        public  List<Laboratoire>findAll(int limit, int offset)throws SQLException{
            List<Laboratoire> labos = new ArrayList<>();
            String SQL= "SELECT * FROM laboratoire where idLabo limit ? offset ?";
            PreparedStatement ps = cnx.prepareStatement(SQL);
            ps.setInt(1, offset);
            ps.setInt(2, limit);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Laboratoire labo= new Laboratoire();
                labo.setIdLabo(rs.getInt("idLabo"));
                labo.setVille(rs.getString("ville"));
                labo.setIdStock(rs.getInt("idStock"));
                labos.add(labo);

            }

            return labos;

        }

        public List<Laboratoire>findAll() throws SQLException{
            return findAll(0,4000);
        }


}

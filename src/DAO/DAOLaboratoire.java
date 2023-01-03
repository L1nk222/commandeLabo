package DAO;

import entity.Laboratoire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOLaboratoire {
    private Connection cnx;

    public DAOLaboratoire(Connection cnx){
        this.cnx = cnx;
    }

    public find(int id) throws SQLException {
        Laboratoire labo =null;
        String SQL= "SELECT * FROM laboratoire where idLabo=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            labo = new Laboratoire();
            labo

        }

        }


}

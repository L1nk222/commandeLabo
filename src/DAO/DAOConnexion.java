package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Fournisseur;
import entity.User;
public class DAOConnexion {
    private Connection cnx;

    public DAOConnexion(Connection cnx) {
        this.cnx = cnx;
    }


    public User findByLogin(String username) throws SQLException {
        User user =null;
        String SQL= "SELECT * FROM users where username=?";
        PreparedStatement ps = cnx.prepareStatement(SQL);
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            user = new User();
            user.setId((rs.getInt("id")));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setRole((rs.getInt("role")));

        }
        return user;

    }

}

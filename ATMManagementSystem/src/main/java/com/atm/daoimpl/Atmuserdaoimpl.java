package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.dao.Atmdao;
import com.atm.model.Atmuser;
import com.atm.util.Dbconnet;

public class Atmuserdaoimpl implements Atmdao {

    @Override
    public Atmuser login(String username, String pin) {

        String sql =
                "SELECT * FROM users WHERE username=? AND pin=?";

        try (Connection con = Dbconnet.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, pin);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Atmuser user = new Atmuser();

                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPin(rs.getString("pin"));
                user.setFullName(rs.getString("full_name"));

                return user;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean changePin(int userId, String newPin) {

        String sql =
                "UPDATE users SET pin=? WHERE user_id=?";

        try (Connection con = Dbconnet.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, newPin);
            ps.setInt(2, userId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }
}
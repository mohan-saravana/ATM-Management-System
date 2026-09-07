package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.atm.dao.Atmaccountdao;
import com.atm.model.Atmaccount;
import com.atm.util.Dbconnet;

public class Atmaccountdaoimpl implements Atmaccountdao {

    @Override
    public Atmaccount getAccountByUserId(int userId) {

        String sql =
                "SELECT * FROM accounts WHERE user_id=?";

        try (Connection con = Dbconnet.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Atmaccount(
                        rs.getInt("account_id"),
                        rs.getInt("user_id"),
                        rs.getString("account_number"),
                        rs.getDouble("balance")
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean deposit(int accountId, double amount) {

        String sql =
                "UPDATE accounts SET balance=balance+? " +
                "WHERE account_id=?";

        try (Connection con = Dbconnet.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setInt(2, accountId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean withdraw(int accountId, double amount) {

        String sql =
                "UPDATE accounts SET balance=balance-? " +
                "WHERE account_id=? AND balance>=?";

        try (Connection con = Dbconnet.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setDouble(1, amount);
            ps.setInt(2, accountId);
            ps.setDouble(3, amount);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean transfer(int fromAccountId,
                            int toAccountId,
                            double amount) {

        Connection con = null;

        try {

            con = Dbconnet.getConnection();

            con.setAutoCommit(false);

            String withdraw =
                    "UPDATE accounts SET balance=balance-? " +
                    "WHERE account_id=? AND balance>=?";

            PreparedStatement ps1 =
                    con.prepareStatement(withdraw);

            ps1.setDouble(1, amount);
            ps1.setInt(2, fromAccountId);
            ps1.setDouble(3, amount);

            int result1 = ps1.executeUpdate();

            if (result1 == 0) {

                con.rollback();
                return false;
            }

            String deposit =
                    "UPDATE accounts SET balance=balance+? " +
                    "WHERE account_id=?";

            PreparedStatement ps2 =
                    con.prepareStatement(deposit);

            ps2.setDouble(1, amount);
            ps2.setInt(2, toAccountId);

            int result2 = ps2.executeUpdate();

            if (result2 == 0) {

                con.rollback();
                return false;
            }

            con.commit();

            return true;

        } catch (Exception e) {

            try {

                if (con != null) {
                    con.rollback();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {

            try {

                if (con != null) {
                    con.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
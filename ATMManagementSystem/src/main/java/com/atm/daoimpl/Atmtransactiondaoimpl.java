package com.atm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.atm.dao.Atmtransactiondao;
import com.atm.model.Atmtransaction;
import com.atm.util.Dbconnet;

public class Atmtransactiondaoimpl implements Atmtransactiondao {

    @Override
    public boolean addTransaction(Atmtransaction transaction) {

        String sql =
                "INSERT INTO transactions " +
                "(account_id, transaction_type, amount) " +
                "VALUES (?, ?, ?)";

        try (Connection con = Dbconnet.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, transaction.getAccountId());
            ps.setString(2, transaction.getTransactionType());
            ps.setDouble(3, transaction.getAmount());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Atmtransaction> getTransactions(int accountId) {

        List<Atmtransaction> list =
                new ArrayList<>();

        String sql =
                "SELECT * FROM transactions " +
                "WHERE account_id=? " +
                "ORDER BY transaction_date DESC";

        try (Connection con = Dbconnet.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Atmtransaction transaction =
                        new Atmtransaction();

                transaction.setTransactionId(
                        rs.getInt("transaction_id"));

                transaction.setAccountId(
                        rs.getInt("account_id"));

                transaction.setTransactionType(
                        rs.getString("transaction_type"));

                transaction.setAmount(
                        rs.getDouble("amount"));

                transaction.setTransactionDate(
                        rs.getTimestamp("transaction_date"));

                list.add(transaction);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }
}
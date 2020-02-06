package Model.Repository;


import Model.Pojo.History;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {

    public List<History> getHistoryByAccountId(int accountId) {

        List<History> histories = new ArrayList<>();
        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT id, balance, " +
                    "transactionAmount, transactionDate FROM History WHERE accountId = ?");
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                histories.add(new History(rs.getInt("id"), rs.getDouble("balance"),
                        rs.getDouble("transactionAmount"), rs.getDate("transactionDate")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return histories;
    }


    public List<History> getAllHistoryBetweenDate(int accountID, String startDate, String endDate) {

        List<History> historyList = new ArrayList<>();
        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement
                    ("select * from History " +
                            "where transactionDate BETWEEN ? AND ? having AccountId = ?");
            stmt.setString(1, startDate);
            stmt.setString(2, endDate);
            stmt.setInt(3, accountID);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                History history = new History();
                history.setId(rs.getInt("id"));
                history.setBalance(rs.getDouble("balance"));
                history.setTransactionAmount(rs.getDouble("transactionAmount"));
                history.setTransactionDate(rs.getDate("transactionDate"));
                historyList.add(history);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return historyList;
    }



}

package Model.Repository;



import Model.Pojo.Account;
import Model.Pojo.History;
import Model.Pojo.Loan;

import java.sql.*;
import java.util.List;

public class LoanRepository {

    public Loan getLoanByAccountId(int accountId) {

        Loan loan = new Loan();
        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT id, balance, " +
                    "interestRate, paymentInterval FROM Loan WHERE accountId = ?");
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                loan = new Loan(rs.getInt("id"), rs.getDouble("balance"),
                        rs.getDouble("interestRate"),rs.getInt("paymentInterval"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }

    public Loan getLastAddedLoan() {

        Loan loan =new Loan();
        Connection con = ConnectionJDBC.getConnection();

        try {

            Statement stmt =con.createStatement();

            String qu="SELECT id, balance, interestRate, paymentInterval FROM Loan WHERE id   = (select  id from Loan group by id order by id desc limit 1)";

            ResultSet rs =stmt.executeQuery(qu);

            while (rs.next()) {

                loan = new Loan(rs.getInt("id"), rs.getDouble("balance"),
                        rs.getDouble("interestRate"),rs.getInt("paymentInterval"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loan;
    }

}

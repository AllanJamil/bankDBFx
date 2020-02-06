package ATM.Model.Repository;

import ATM.Model.Pojo.Loan;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanRepo {


    public Loan getLoanByAccountID(int id){
        Loan loan = new Loan();


        Connection con= ConnectionJDBC.getConnection();
        String query="select *\n"
            + "from SuperGruppen.Loan\n"
            + "inner join SuperGruppen.Account\n"
            + "on Loan.AccountId = Account.id\n"
            + "where AccountId=?;\n";
        try {
            PreparedStatement preparedStatement=con.prepareStatement(query);

            preparedStatement.setString(1,id+"");
            ResultSet rs=preparedStatement.executeQuery();

            while(rs.next()){
                loan.setId(rs.getInt("id"));
                loan.setBalance(rs.getDouble("balance"));
                loan.setInterestRate(rs.getDouble("interestRate"));
                loan.setPaymentInterval(rs.getInt("paymentInterval"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loan;
    }



}

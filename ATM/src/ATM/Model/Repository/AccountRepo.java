package ATM.Model.Repository;

import ATM.Model.Pojo.Account;
import ATM.Model.Pojo.History;
import ATM.Model.Pojo.Loan;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountRepo {

    public List<Account> getAccountsByCustomerID(int customerID) {

        List<Account> accountList = new ArrayList<>();

        Connection con = ConnectionJDBC.getConnection();
        String query = "select a.id as aID,a.Balance as aBalance, a.interestRate as aIR\n"
            + "from SuperGruppen.Account a\n"
            + "inner join SuperGruppen.Customer C\n"
            + "on a.customerId = C.id\n"
            + "where C.id=?;\n";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, customerID + "");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("aID"));
                account.setBalance(rs.getDouble("aBalance"));
                account.setInterestRate(rs.getDouble("aIR"));
                List<History> historyByAccountID = new HistoryRepo().getHistoryByAccountID(account.getId());
                account.setHistoryList(historyByAccountID);
                Loan loanByAccountID = new LoanRepo().getLoanByAccountID(account.getId());
                account.setLoan(loanByAccountID);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public boolean withdrawAmount(int accountId, int amount){
        Connection con = ConnectionJDBC.getConnection();
        String query = "call withdrawAmountfromAccount(?,?)";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, accountId + "");
            preparedStatement.setString(2, amount + "");
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void main(String[] args) {
        AccountRepo accountRepo = new AccountRepo();
        List<Account> accountsByCustomerID = accountRepo.getAccountsByCustomerID(2);
        accountsByCustomerID.forEach(System.out::println);

    }
}

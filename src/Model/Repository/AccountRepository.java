package Model.Repository;


import Model.Pojo.Account;
import Model.Pojo.Customer;
import Model.Pojo.History;
import Model.Pojo.Loan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    LoanRepository loanRepo = new LoanRepository();
    HistoryRepository historyRepo = new HistoryRepository();

    public List<Account> getAccountsById(int customerId) {

        List<Account> accounts = new ArrayList<>();
        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT id, customerId, " +
                    "Balance, interestRate FROM Account WHERE customerId = ?");
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                Loan loan = loanRepo.getLoanByAccountId(id);
                List<History> history = historyRepo.getHistoryByAccountId(id);

                accounts.add(new Account(rs.getInt("id"), rs.getDouble("Balance"),
                        rs.getDouble("interestRate"),loan,history));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public Account getLastAddedAccount() {

        Account account =new Account();
        Connection con = ConnectionJDBC.getConnection();

        try {

            Statement stmt =con.createStatement();

            String qu="SELECT id, customerId, Balance, interestRate FROM Account WHERE id = (select  id from Account group by id order by id desc limit 1)";

            ResultSet rs =stmt.executeQuery(qu);

            while (rs.next()) {

                int id = rs.getInt("id");
                Loan loan = loanRepo.getLoanByAccountId(id);
                List<History> history = historyRepo.getHistoryByAccountId(id);

               account= new Account(id, rs.getDouble("Balance"),
                        rs.getDouble("interestRate"),loan,history);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(account.getId()+" "+account.getBalance());
        return account;
    }

/*    public List<Account> getAllAccounts() {

        List<Account> accounts = new ArrayList<>();
        List<Integer> accountIds = new ArrayList<>();

        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT id FROM Account");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                accountIds.add(rs.getInt("id"));
            }

            accounts = accountIds.stream().map(id -> getAccountById(id)).collect(Collectors.toList());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }*/

}
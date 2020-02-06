package Model.Repository;

import Model.Pojo.Administrator;
import Model.Pojo.History;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministratorRepository {

    public Administrator getAdministrator(String userName, String password) {
        Connection con = ConnectionJDBC.getConnection();
        Administrator admin = null;
        try {
            admin = null;
            CallableStatement callableStatement = con.prepareCall("call verifyAdmin(?,?)");
            callableStatement.setString(1, userName);
            callableStatement.setString(2, password);

            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                admin = new Administrator();
                admin.setUsername(rs.getString("username"));
                admin.setPassword(rs.getString("password"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    public boolean addNewCustomer(String firstName, String lastName, String pin) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call AddNewCustomer(?,?,?)");
            callableStatement.setString(1, firstName);
            callableStatement.setString(2, lastName);
            callableStatement.setString(3, pin);
            callableStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateCustomerInfo(int customerID, String newFirstName, String newLastName, String pin) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call UpdateCustomerInfo(?,?,?,?)");
            callableStatement.setInt(1, customerID);
            callableStatement.setString(2, newFirstName);
            callableStatement.setString(3, newLastName);
            callableStatement.setString(4, pin);
            callableStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCustomerByID(int customerID) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call DeleteCustomerByID(?)");
            callableStatement.setInt(1, customerID);

            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                //System.out.println("Deleted account: " + customerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCustomerByFullName(String firstName, String lastName) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call DeleteCustomer(?,?)");
            callableStatement.setString(1, firstName);
            callableStatement.setString(2, lastName);
            callableStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addNewAccountForCustomer(int customerID, double balance, double interestRate) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call AddNewAccountForCustomer(?,?,?)");
            callableStatement.setInt(1, customerID);
            callableStatement.setDouble(2, balance);
            callableStatement.setDouble(3, interestRate);

            callableStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean closeAccountForCustomer(int accountID, int customerID) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call closeAccountForCustomer(?,?)");
            callableStatement.setInt(1, accountID);
            callableStatement.setInt(2, customerID);


            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                //System.out.println("Customer: " + customerID + " had the following account deleted: " + accountID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean depositAmountOnAccount(int accountID, int amount) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call DepositAmountOnAccount(?,?)");
            callableStatement.setInt(1, accountID);
            callableStatement.setInt(2, amount);


            callableStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean withdrawAmountFromAccount(int accountID, int amount) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call WithdrawAmountFromAccount(?,?)");
            callableStatement.setInt(1, accountID);
            callableStatement.setInt(2, amount);

            callableStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean changeInterestRateOnAccount(int accountID, double interestRate) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call ChangeInterestRateOnAccount(?,?)");
            callableStatement.setInt(1, accountID);
            callableStatement.setDouble(2, interestRate);


            callableStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addNewLoan(int accountID, double balance, double interestRate, int paymentInterval) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call AddNewLoan(?,?,?,?)");
            callableStatement.setInt(1, accountID);
            callableStatement.setDouble(2, balance);
            callableStatement.setDouble(3, interestRate);
            callableStatement.setInt(4, paymentInterval);
            callableStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean changePaymentIntervalOnLoan(int accountID, int paymentInterval) {
        Connection con = ConnectionJDBC.getConnection();
        try {
            CallableStatement callableStatement = con.prepareCall("call ChangePaymentIntervalOnLoan(?,?)");
            callableStatement.setInt(1, accountID);
            callableStatement.setInt(2, paymentInterval);

            callableStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean changeInterestRateOnLoan(int loanID, double interestRate) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call ChangeInterestRateOnLoan(?,?)");
            callableStatement.setInt(1, loanID);
            callableStatement.setDouble(2, interestRate);


             callableStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<History> seeHistoryBetweenDate(int accountID, Date startDate, Date endDate) {
        List<History> historyList = new ArrayList<>();
        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement
                    ("select * from History " +
                            "where transactionDate BETWEEN ? AND ? having AccountId = ?");
            stmt.setDate(1, startDate);
            stmt.setDate(2, endDate);
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

    public boolean deleteAccountById(int id) {
        Connection con = ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement = con.prepareCall("call DeleteAccount(?)");
            callableStatement.setInt(1, id);

            callableStatement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}



    /*
    public double showTotalSumOwedWhenRepaidOfLoan(int loanID){
        double loanBalance = 0, interestRate = 0, sum = 0;
        int paymentInterval = 0;
        Connection con=ConnectionJDBC.getConnection();

        try {
            CallableStatement callableStatement=con.prepareCall("SELECT balance, paymentInterval, " +
                    "interestRate FROM Loan WHERE ID = ?");
            callableStatement.setInt(1,loanID);
            ResultSet rs = callableStatement.executeQuery();

            while(rs.next()){
                loanBalance = rs.getDouble("balance");
                paymentInterval = rs.getInt("paymentInterval");
                interestRate = rs.getDouble("interestRate");
            }
            //sum = balanceOwed(loanBalance,paymentInterval,interestRate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Account: " + loanID + " has total sum owed when repaid loan: " + sum);
        return sum;
    }
     */
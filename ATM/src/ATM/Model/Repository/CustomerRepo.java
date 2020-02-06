package ATM.Model.Repository;

import ATM.Model.Pojo.Account;
import ATM.Model.Pojo.Customer;
import ATM.Model.Repository.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerRepo {

    public Customer getCustomerByPin(String pin) {

        Customer customer = null;

        Connection con = ConnectionJDBC.getConnection();
        String query = "select * from SuperGruppen.Customer where pin=?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, pin + "");
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstName(rs.getString("firstName"));
                customer.setLastName(rs.getString("lastName"));
                customer.setPin(rs.getString("pin"));
                List<Account> accountsByCustomerID = new AccountRepo().getAccountsByCustomerID(customer.getId());
                customer.setAccountList(accountsByCustomerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

}

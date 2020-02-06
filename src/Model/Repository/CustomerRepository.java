package Model.Repository;


import Model.Pojo.Account;
import Model.Pojo.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerRepository {

    AccountRepository accountRepo = new AccountRepository();

    public Customer getCustomerById(int customerId) {

        Customer customer = new Customer();
        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT id, firstName, " +
                    "lastName, pin FROM Customer WHERE id = ?");
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                List<Account> accounts = accountRepo.getAccountsById(id);


                customer = new Customer(id, rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("pin"), accounts);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();
        List<Integer> customerIds = new ArrayList<>();

        Connection con = ConnectionJDBC.getConnection();

        try {
            PreparedStatement stmt = con.prepareStatement("SELECT id FROM Customer");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                customerIds.add(rs.getInt("id"));
            }
            customers = customerIds.stream().map(id -> getCustomerById(id)).collect(Collectors.toList());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Customer getLastAddedCustomer() {

        Customer customer = new Customer();
        Connection con = ConnectionJDBC.getConnection();

        try {

            Statement stmt =con.createStatement();

            ResultSet rs =stmt.executeQuery("SELECT id, firstName," +
                    "lastName,pin FROM SuperGruppen.Customer where id =(select id from Customer group by id order by id desc limit 1)");

            while (rs.next()) {
                int id = rs.getInt("id");
                List<Account> accounts = accountRepo.getAccountsById(id);


                customer = new Customer(id, rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("pin"), accounts);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }


}
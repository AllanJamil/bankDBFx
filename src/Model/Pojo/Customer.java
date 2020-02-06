package Model.Pojo;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String pin;
    private List<Account> accountList = new ArrayList<>();

    public Customer(int id, String firstName, String lastName, String pin, List<Account> accountList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.accountList = accountList;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<Account> getAccounts() {
        return accountList;
    }

    public void setAccounts(List<Account> accounts) {
        this.accountList = accounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pin='" + pin + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}

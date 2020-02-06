package ATM.Model.Pojo;

import java.util.List;

public class Customer {

    private String firstName;
    private String lastName;
    private int id;
    private String pin;
    private List<Account> accountList;

    public Customer(){
    }

    public Customer(String firstName, String lastName, int id, String pin,List<Account> accountList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.pin = pin;
        this.accountList = accountList;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}

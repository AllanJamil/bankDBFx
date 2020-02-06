package ModelView;

import Model.Pojo.Account;
import Model.Pojo.Customer;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

public class CustomerView {

    private int id;
    private SimpleStringProperty firstname;
    private SimpleStringProperty lastname;
    private SimpleStringProperty pin;
    private List<AccountView> accounts = new ArrayList<>();

    public CustomerView(int id, String firstname, String lastname, String pin, List<Account> accounts) {
        this.id = id;
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.pin = new SimpleStringProperty(pin);
        convertAccountsToView(accounts);
    }

    public CustomerView(Customer customer) {
        this.id = customer.getId();
        this.firstname = new SimpleStringProperty(customer.getFirstName());
        this.lastname = new SimpleStringProperty(customer.getLastName());
        this.pin = new SimpleStringProperty(customer.getPin());
        convertAccountsToView(customer.getAccounts());
    }

    public void convertAccountsToView(List<Account> accounts) {
        accounts.forEach(account -> this.accounts.add(new AccountView(account.getId(),
                account.getBalance(), account.getInterestRate(),account.getLoan(),account.getHistory())));
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getPin() {
        return pin.get();
    }

    public SimpleStringProperty pinProperty() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin.set(pin);
    }

    public List<AccountView> getAccounts() {
        return accounts;
    }

    public void addAcountView(AccountView accountView){
        accounts.add(accountView);
    }
}

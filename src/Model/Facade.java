package Model;

import Model.Pojo.Administrator;
import Model.Pojo.Customer;
import Model.Repository.*;
import ModelView.AccountView;
import ModelView.CustomerView;

import java.util.List;
import java.util.stream.Collectors;

public class Facade {

    AdministratorRepository administratorRepository;
    Administrator admin;
    CustomerRepository customerRepository;
    AccountRepository accountRepository;
    LoanRepository loanRepository;
    ModelLoan modelLoan;
    HistoryRepository historyRepository;
    public Facade() {
        this.administratorRepository=new AdministratorRepository();
        this.customerRepository = new CustomerRepository();
        this.accountRepository=new AccountRepository();
        this.loanRepository=new LoanRepository();
        this.modelLoan=new ModelLoan();
        this.historyRepository=new HistoryRepository();
    }

    public boolean verifyAdmin(String username, String password) {
        administratorRepository = new AdministratorRepository();
        admin = administratorRepository.getAdministrator(username, password);
        return admin != null;
    }


    public List<CustomerView> getCustomerViewList() {
       return  customerRepository.getAllCustomers().stream().map(e -> new CustomerView(e.getId(),
               e.getFirstName(),e.getLastName(),e.getPin(),e.getAccounts())).collect(Collectors.toList());
    }

    public AdministratorRepository getAdministratorRepository() {
        return administratorRepository;
    }

    public CustomerRepository getCustomerRepository() {
        return customerRepository;
    }

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public LoanRepository getLoanRepository() {
        return loanRepository;
    }

    public ModelLoan getModelLoan() {
        return modelLoan;
    }

    public HistoryRepository getHistoryRepository() {
        return historyRepository;
    }

    public List<AccountView> getAccountViewList(int customerID){
        return accountRepository.getAccountsById(customerID).stream()
                .map(e->new AccountView(e))
                .collect(Collectors.toList());
    }
}

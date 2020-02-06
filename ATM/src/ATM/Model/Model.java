package ATM.Model;

import ATM.Model.Pojo.Account;
import ATM.Model.Pojo.Customer;
import ATM.Model.Pojo.History;
import ATM.Model.Repository.AccountRepo;
import ATM.Model.Repository.CustomerRepo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Model {
    private Customer customer;
    private int choosenAccount;

    public Model() {

    }

    public boolean verifyCustomer(String pinCode){
        customer=new CustomerRepo().getCustomerByPin(pinCode);
        return customer != null;
    }

    public String getWelcomingMessage(){
        return String.format("%s %s %s","Welcome",customer.getFirstName(),customer.getLastName());
    }

    public boolean withdrawAmount(int amount){
        AccountRepo accountRepo = new AccountRepo();
        return  accountRepo.withdrawAmount(customer.getAccountList().get(choosenAccount).getId(), amount);

    }

    public String displayBalance(){
        List<Account> accountsByCustomerID =new AccountRepo().getAccountsByCustomerID(customer.getId());;

        String displayBalance = "Account Balance: " + accountsByCustomerID.get(choosenAccount).getBalance() +
                "\nAccount Interestrate: " + accountsByCustomerID.get(choosenAccount).getInterestRate() +
                "\nLoan Balance: " + accountsByCustomerID.get(choosenAccount).getLoan().getBalance() +
                "\nLoan Interestrate: " + accountsByCustomerID.get(choosenAccount).getLoan().getInterestRate() +
                "\nLoan Paymentinterval: " + accountsByCustomerID.get(choosenAccount).getLoan().getPaymentInterval();
        return  displayBalance;
    }

    public String displayHistory(){
        List<Account> accountsByCustomerID =new AccountRepo().getAccountsByCustomerID(customer.getId());;
        return  accountsByCustomerID.get(choosenAccount)
            .getHistoryList()
            .stream()
            .map(History::toString)
            .collect(Collectors.joining("\n     ","      Balance          Date     TransactionAmount\n\n     ",""));
    }

    public List<String> getAccountList(){
        return IntStream.range(0,customer.getAccountList().size())
            .mapToObj(e->"Konto "+(e+1))
            .collect(Collectors.toList());

    }

    public void setChoosenAccount(int choosenAccount) {
        this.choosenAccount = choosenAccount;
    }
}

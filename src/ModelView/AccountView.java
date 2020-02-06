package ModelView;

import Model.Pojo.Account;
import Model.Pojo.History;
import Model.Pojo.Loan;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;
import java.util.List;

public class AccountView {

    private int id;
    private SimpleDoubleProperty balance;
    private SimpleDoubleProperty interestRate;
    private LoanView loan;
    private List<HistoryView> histories = new ArrayList<>();



    public AccountView(int id, double balance, double interestRate, Loan loan, List<History> histories) {
        this.id = id;
        this.balance = new SimpleDoubleProperty(balance);
        this.interestRate = new SimpleDoubleProperty(interestRate);
       if(loan!=null)
           this.loan = new LoanView(loan);
       else
           this.loan=null;
       if(histories!=null)
           convertHistoryToHistoryView(histories);
       else
           this.histories=null;
    }

    public AccountView(Account account) {
        this.id = account.getId();
        this.balance = new SimpleDoubleProperty(account.getBalance());
        this.interestRate = new SimpleDoubleProperty(account.getInterestRate());
        this.loan = new LoanView(account.getLoan());
        convertHistoryToHistoryView(account.getHistory());
    }



    private void convertHistoryToHistoryView(List<History> histories) {
        histories.forEach(e->this.histories.add(new HistoryView(e)));
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance.set(balance);
    }

    public void setInterestRate(double interestRate) {
        this.interestRate.set(interestRate);
    }

    public void setLoan(LoanView loan) {
        this.loan = loan;
    }

    public void setHistories(List<HistoryView> histories) {
        this.histories = histories;
    }

    public double getBalance() {
        return balance.get();
    }

    public SimpleDoubleProperty balanceProperty() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate.get();
    }

    public SimpleDoubleProperty interestRateProperty() {
        return interestRate;
    }

    public LoanView getLoan() {
        return loan;
    }

    public List<HistoryView> getHistories() {
        return histories;
    }
}

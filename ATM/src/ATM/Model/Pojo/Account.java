package ATM.Model.Pojo;

import java.util.List;

public class Account {

    private int id;
    private double balance;
    private List<History> historyList;
    private Loan loan;
    private double interestRate;

    public Account(int id, double balance, List<History> historyList, Loan loan,
                   double interestRate) {
        this.id = id;
        this.balance = balance;
        this.historyList = historyList;
        this.loan = loan;
        this.interestRate = interestRate;
    }

    public Account(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


}

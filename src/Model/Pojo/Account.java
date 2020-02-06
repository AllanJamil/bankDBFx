package Model.Pojo;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private int id;
    private double balance;
    private double interestRate;
    private Loan loan;
    private List<History> history = new ArrayList<>();

    public Account(int id, double balance, double interestRate, Loan loan, List<History> history) {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
        this.loan = loan;
        this.history = history;
    }

    public Account(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public Account() {
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

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                ", loan=" + loan +
                '}';
    }
}

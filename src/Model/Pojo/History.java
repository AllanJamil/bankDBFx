package Model.Pojo;

import java.sql.Date;

public class History {
    private int id;
    private double balance;
    private double transactionAmount;
    private Date transactionDate;

    public History(int id, double balance, double transactionAmount, Date transactionDate) {
        this.id = id;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public History() {
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

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", balance=" + balance +
                ", transactionAmount=" + transactionAmount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}

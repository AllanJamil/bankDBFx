package ATM.Model.Pojo;

import java.sql.Date;

public class History {

    private int id;
    private double balance;
    private double transactionAmount;
    private Date transationDate;

    public History(){

    }

    public History(int id, double balance, double transactionAmount, Date transationDate) {
        this.id = id;
        this.balance = balance;
        this.transactionAmount = transactionAmount;
        this.transationDate = transationDate;
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

    public Date getTransationDate() {
        return transationDate;
    }

    public void setTransationDate(Date transationDate) {
        this.transationDate = transationDate;
    }

    @Override
    public String toString() {
        return this.balance + "      "
            +this.transationDate + "     "
            + this.transactionAmount;
    }
}

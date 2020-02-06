package Model.Pojo;

public class Loan {
    private int id;
    private double balance;
    private double interestRate;
    private int paymentInterval;

    public Loan(int id, double balance, double interestRate, int paymentInterval) {
        this.id = id;
        this.balance = balance;
        this.interestRate = interestRate;
        this.paymentInterval = paymentInterval;
    }

    public Loan() {

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

    public int getPaymentInterval() {
        return paymentInterval;
    }

    public void setPaymentInterval(int paymentInterval) {
        this.paymentInterval = paymentInterval;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", balance=" + balance +
                ", interestRate=" + interestRate +
                ", paymentInterval=" + paymentInterval +
                '}';
    }
}

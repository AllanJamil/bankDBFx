package ModelView;

import Model.Pojo.Loan;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class LoanView {

    private int id;
    private SimpleDoubleProperty balance;
    private SimpleDoubleProperty interestRate;
    private SimpleIntegerProperty paymentInterval;

    public LoanView(int id, double balance, double interestRate, int paymentInterval) {
        this.id = id;
        this.balance = new SimpleDoubleProperty(balance);
        this.interestRate = new SimpleDoubleProperty(interestRate);
        this.paymentInterval = new SimpleIntegerProperty(paymentInterval);
    }

    public LoanView(Loan loan) {
        this.id = loan.getId();
        this.balance = new SimpleDoubleProperty(loan.getBalance());
        this.interestRate = new SimpleDoubleProperty(loan.getInterestRate());
        this.paymentInterval = new SimpleIntegerProperty(loan.getPaymentInterval());
    }

    public int getId() {
        return id;
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

    public int getPaymentInterval() {
        return paymentInterval.get();
    }

    public SimpleIntegerProperty paymentIntervalProperty() {
        return paymentInterval;
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

    public void setPaymentInterval(int paymentInterval) {
        this.paymentInterval.set(paymentInterval);
    }
}

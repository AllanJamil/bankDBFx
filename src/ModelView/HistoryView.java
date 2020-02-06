package ModelView;

import Model.Pojo.History;
import javafx.beans.property.SimpleDoubleProperty;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.IntStream;

public class HistoryView {

    private int id;
    private SimpleDoubleProperty balance;
    private SimpleDoubleProperty transactionAmount;
    private SimpleDateFormat transactionDate;
    private Date transactionD;

    public HistoryView(int id, double balance, double transactionAmount, Date transactionDate) {
        this.id = id;
        this.balance = new SimpleDoubleProperty(balance);
        this.transactionAmount = new SimpleDoubleProperty(transactionAmount);
        this.transactionDate = new SimpleDateFormat("YYYY-MM-DD");
        this.transactionD = transactionDate;
    }


    public HistoryView(History history) {
        this.id=history.getId();
        this.balance=new SimpleDoubleProperty(history.getBalance());
        this.transactionAmount=new SimpleDoubleProperty(history.getTransactionAmount());
        this.transactionDate=new SimpleDateFormat(history.getTransactionDate().toString());
        this.transactionD=history.getTransactionDate();
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

    public double getTransactionAmount() {
        return transactionAmount.get();
    }

    public SimpleDoubleProperty transactionAmountProperty() {
        return transactionAmount;
    }

    public SimpleDateFormat getTransactionDate() {
        return transactionDate;
    }

    public Date getTransactionD() {
        return transactionD;
    }
}

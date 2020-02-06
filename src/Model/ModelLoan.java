package Model;

public class ModelLoan {

    public double balanceOwed(double loanBalance, int paymentInterval, double interestRate){
        if (paymentInterval == 0) {
            return loanBalance;
        }
        else{
            return balanceOwed(loanBalance, paymentInterval-1, interestRate)*(1+interestRate);
        }
    }
}

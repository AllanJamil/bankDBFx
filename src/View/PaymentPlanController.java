package View;

import Model.Facade;
import ModelView.LoanView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PaymentPlanController implements Initializable {

    @FXML
    private Button okButton;


    @FXML
    private Label infoLabel;

    public void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LoanView loan = new HomeController().getSelectedLoanView();
        double balanceOwed = new Facade().getModelLoan().balanceOwed(loan.getBalance(), loan.getPaymentInterval(), loan.getInterestRate());
        infoLabel.setText("Loan :\n\n"+
                "Balance : "+loan.getBalance()+"\n"+
                "Payment Interval : "+ loan.getPaymentInterval()+"\n"+
                "Interest Rate : "+loan.getInterestRate()+"\n"+
                "Balance Owed : "+balanceOwed);
    }
}

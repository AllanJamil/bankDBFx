package View;

import Model.Facade;
import Model.Pojo.Loan;
import ModelView.AccountView;
import ModelView.LoanView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class editAddLoanController implements Initializable {


    @FXML
    private TextField interestRateTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField balanceTextField;

    @FXML
    private TextField paymentIntervalTextField;

    @FXML
    private Button okButton;

    public void close() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void okButtonAction() {
        AccountView accountView = HomeController.getAccountView();
        double balance = Double.parseDouble(balanceTextField.getText());
        int paymentInterval = Integer.parseInt(paymentIntervalTextField.getText());
        double interestRate = Double.parseDouble(interestRateTextField.getText());


        if (HomeController.getButtonName().equalsIgnoreCase("Add")) {
            if (accountView.getLoan().getInterestRate() == 0) {
                new Facade().getAdministratorRepository().addNewLoan(accountView.getId(), balance, interestRate, paymentInterval);
                Loan lastAddedLoan = new Facade().getLoanRepository().getLastAddedLoan();
                LoanView loanView = new LoanView(lastAddedLoan);
                accountView.setLoan(loanView);
                new HomeController().addNewLoanToLoanTable(loanView);
            }
        }else{

            new Facade().getAdministratorRepository().changeInterestRateOnLoan(accountView.getId(),interestRate);
            new Facade().getAdministratorRepository().changePaymentIntervalOnLoan(accountView.getId(),paymentInterval);
            accountView.getLoan().setInterestRate(interestRate);
            accountView.getLoan().setPaymentInterval(paymentInterval);
        }


        close();
    }

    private void fillTextFields( LoanView loan) {

        balanceTextField.setText(String.valueOf(loan.getBalance()));
        paymentIntervalTextField.setText(String.valueOf(loan.getPaymentInterval()));
        interestRateTextField.setText(String.valueOf(loan.getInterestRate()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(HomeController.getButtonName().equalsIgnoreCase("Edit")){
            LoanView loan = new HomeController().getSelectedLoanView();
            fillTextFields(loan);
        }
    }
}

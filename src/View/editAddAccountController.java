package View;

import Model.Facade;
import Model.Pojo.Account;
import ModelView.AccountView;
import ModelView.CustomerView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editAddAccountController {


    @FXML
    private TextField interestRateTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField balanceTextField;

    @FXML
    private Button okButton;

    public void close() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void okButtonAction() {

        double newInterestRate = Double.parseDouble(interestRateTextField.getText());
        if(HomeController.getButtonName().equalsIgnoreCase("update")){
            AccountView account = HomeController.getAccountView();

            int id = account.getId();
            balanceTextField.setDisable(true);
            account.setInterestRate(newInterestRate);
            new Facade().getAdministratorRepository().changeInterestRateOnAccount(id,newInterestRate);
        }else {
            CustomerView customerId = HomeController.getSelectedCustomerView();
            double balance = Double.parseDouble(balanceTextField.getText());
            balanceTextField.setDisable(false);
            new Facade().getAdministratorRepository().addNewAccountForCustomer(customerId.getId(),balance,newInterestRate);
            Account lastAddedAccount = new Facade().getAccountRepository().getLastAddedAccount();
            AccountView accountView = new AccountView(lastAddedAccount);
            customerId.addAcountView(accountView);
            new HomeController().addNewAccountToTable(accountView);
        }
        close();

    }
}

package View;

import Model.Facade;
import ModelView.AccountView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WithdrawDepositController implements Initializable {
    Stage stage;
    @FXML
    private Button cancelButton;
    @FXML
    private TextField amountTextField;
    @FXML
    private Button withdrawDepositButton;

    public void close() {
        stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void okButtonAction() {
        AccountView account = HomeController.getAccountView();
        int accountId = account.getId();
        int sum = Integer.parseInt(amountTextField.getText());
        if (HomeController.getButtonName().equalsIgnoreCase("withdraw")) {
            new Facade().getAdministratorRepository().withdrawAmountFromAccount(accountId, sum);
            account.setBalance(account.getBalance()-sum);
        } else {
            new Facade().getAdministratorRepository().depositAmountOnAccount(accountId, sum);
            account.setBalance(account.getBalance()+sum);
        }
        close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


}

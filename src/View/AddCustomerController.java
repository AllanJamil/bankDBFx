package View;

import Model.Facade;
import Model.Pojo.Customer;
import ModelView.CustomerView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.security.auth.login.LoginContext;

public class AddCustomerController {

    private static CustomerView customerView;


    @FXML
    private TextField pinTextField;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private Button okButton;


    public void close() {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonAction() {
        close();
    }

    public void okButtonAction() {
        String firstname = firstnameTextField.getText();
        String lastname = lastnameTextField.getText();
        String pin = pinTextField.getText();
        new Facade().getAdministratorRepository().addNewCustomer(firstname,lastname,pin);
        Customer lastAddedCustomer = new Facade().getCustomerRepository().getLastAddedCustomer();
        CustomerView customerView = new CustomerView(lastAddedCustomer);
        new HomeController().addNewCustomerToTable(customerView);
        close();
    }
}

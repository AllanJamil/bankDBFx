package View;

import Model.Facade;
import ModelView.CustomerView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class editCustomerController implements Initializable {

    HomeController homeController = new HomeController();
    private static CustomerView customerView;

    @FXML
    private Button cancelButton;
    @FXML
    private TextField pinTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField firstnameTextField;


    public void close() {
       Stage stage = (Stage) cancelButton.getScene().getWindow();
       stage.close();
    }

    public void cancelButtonAction() {
        close();
    }

    public void setCustomerView() {
        if (!firstnameTextField.getText().isBlank() && !lastnameTextField.getText().isBlank() && !pinTextField.getText().isBlank()) {
            customerView.setFirstname(firstnameTextField.getText());
            customerView.setLastname(lastnameTextField.getText());
            customerView.setPin(pinTextField.getText());
        }
    }

    public void okButtonAction() {
        setCustomerView();
        homeController.setCustomerView(customerView);
        String firstname = firstnameTextField.getText();
        String lastName = lastnameTextField.getText();
        String pin = pinTextField.getText();
        new Facade().getAdministratorRepository().updateCustomerInfo(customerView.getId(),firstname,lastName,pin);
        close();
    }

    public void fillTextField() {
        if (customerView != null) {
            firstnameTextField.setText(customerView.getFirstname());
            lastnameTextField.setText(customerView.getLastname());
            pinTextField.setText(customerView.getPin());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       customerView = homeController.getSelectedCustomer();
       fillTextField();
    }

}

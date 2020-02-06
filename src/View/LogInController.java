package View;

import Model.Facade;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LogInController {

    private static Facade facade = new Facade();

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private TextField usernameTextField;

    public void loadUI(String fxmlFile) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Scene tempScene = new Scene(root, 1200,500);
        ObservableList<Window> windows = Stage.getWindows();
        Stage window = (Stage) windows.get(0);
        window.setScene(tempScene);
        window.show();
    }

    public void logInButtonAction() {

        if (usernameTextField.getText().equals("") && passwordTextField.getText().equals("") ||
                !usernameTextField.getText().equals("") && passwordTextField.getText().equals("") ||
                usernameTextField.getText().equals("") && !passwordTextField.getText().equals("")) {
            errorLabel.setText("Enter both username and password.");
        } else {
            boolean isVerified = facade.verifyAdmin(usernameTextField.getText(), passwordTextField.getText());

            if (!isVerified) {
                errorLabel.setText("The username or password is not correct.");
            } else {
                try {
                    loadUI("home.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public  Facade getFacade() {
        return facade;
    }
}

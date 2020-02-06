package ATM.Controller;

import ATM.Model.Model;
import ATM.View.ChooseAccountViewCustomer;
import ATM.View.LoginViewCustomer;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControllerLoginCustomer {

    Model model;
    LoginViewCustomer loginViewCustomer;

    public ControllerLoginCustomer(Model model, LoginViewCustomer loginViewCustomer) {
        this.model = model;
        this.loginViewCustomer = loginViewCustomer;
        this.loginViewCustomer.addLoginListener(logInClicked);
        this.loginViewCustomer.addLogInKeyListener(enterPressed);
        this.loginViewCustomer.addPinCodeListener(enterPressed);

    }

    private void getUserInput() {
        String pinCode = loginViewCustomer.getPinCode();
        changeView(model.verifyCustomer(pinCode));
    }

    private KeyAdapter enterPressed = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                getUserInput();
            }
        }
    };

    private ActionListener logInClicked = e -> {
        getUserInput();
    };

    private void changeView(boolean userValidated) {
        if (userValidated) {
            this.loginViewCustomer.dispose();
            new ControllerChooseAccount(new ChooseAccountViewCustomer(),model);
        } else {
            loginViewCustomer.addMesaggeToTheUser("Wrong Pincode");
            emptyInputFields();
        }
    }

    private void emptyInputFields() {
       loginViewCustomer.emptyPinCodeField();
    }

    public static void main(String[] args) {
        new ControllerLoginCustomer(new Model(),new LoginViewCustomer());
    }
}

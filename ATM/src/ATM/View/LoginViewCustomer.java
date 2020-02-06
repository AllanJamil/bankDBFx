package ATM.View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class LoginViewCustomer extends JFrame {

    private JPasswordField pinField;
    private JButton enterButton;
    private JLabel message;
    private JPanel panel;

    public LoginViewCustomer(){
        add(panel);
        setSize(200,150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getPinCode() {
        return new String(pinField.getPassword());
    }

    public void addMesaggeToTheUser(String  message){
        this.message.setText(message);
    }

    public void addLogInKeyListener(KeyAdapter keyAdapter){
        enterButton.addKeyListener(keyAdapter);
    }

    public void addLoginListener(ActionListener actionListener) {
        enterButton.addActionListener(actionListener);
    }

    public void addPinCodeListener(KeyListener keyListener) {
        pinField.addKeyListener(keyListener);
    }

    public void emptyPinCodeField(){
        pinField.setText("");
    }
}

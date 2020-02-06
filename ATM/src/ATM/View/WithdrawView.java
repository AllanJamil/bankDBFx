package ATM.View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;

public class WithdrawView extends JFrame {

    private JTextField textField1;
    private JButton withdrawButton;
    private JLabel messageToTheUser;
    private JPanel panel;

    public WithdrawView(){
        add(panel);
        setSize(300,250);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    public int getAmount() {
        return Integer.parseInt(textField1.getText());
    }

    public void addWithdrawAmountKeyListener(KeyAdapter keyAdapter){
        withdrawButton.addKeyListener(keyAdapter);
    }

    public void addWithdrawAmountListener(ActionListener actionListener) {
        withdrawButton.addActionListener(actionListener);
    }

    public void addAmountListener(KeyListener keyListener) {
        textField1.addKeyListener(keyListener);
    }

    public void addMesaggeToTheUser(String  message){
        this.messageToTheUser.setText(message);
    }

    public void emptyWithdrawAmount(){
        textField1.setText("");
    }

    public static void main(String[] args) {
        new WithdrawView();
    }

    public void makeFieldInvisble(){
        textField1.setVisible(false);
        withdrawButton.setVisible(false);
    }
}

package ATM.View;

import javax.swing.*;
import java.awt.event.ActionListener;

public class IntercationViewCustomer extends JFrame {

    private JPanel panel1;
    private JButton logoutButton;
    private JButton historyButton;
    private JButton balanceButton;
    private JButton withdrawButton;
    private JPanel panel;
    private JLabel message;

    public IntercationViewCustomer(){
        add(panel1);
        setSize(300,300);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void addListenerToLogoutButton(ActionListener actionListener){
        logoutButton.addActionListener(actionListener);
    }

    public void addMessageToTheCustomer(String message){
        this.message.setText(message);
    }

    public void addListenerToWithdrawButton(ActionListener actionListener){
        withdrawButton.addActionListener(actionListener);
    }

    public void addListenerToBalanceButton(ActionListener actionListener){
        balanceButton.addActionListener(actionListener);
    }

    public void addListenerToHistoryButton(ActionListener actionListener){
        historyButton.addActionListener(actionListener);
    }
}


package ATM.Controller;

import ATM.Model.Model;
import ATM.View.WithdrawView;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ControllerWithdrawCustomer {

    WithdrawView withdrawView;
    Model model;

    public ControllerWithdrawCustomer(WithdrawView withdrawView, Model model) {
        this.withdrawView = withdrawView;
        this.model = model;
        this.withdrawView.addWithdrawAmountListener(withdrawClicked);
        this.withdrawView.addWithdrawAmountKeyListener(enterPressed);
        this.withdrawView.addAmountListener(enterPressed);
    }

    private void getUserInput() {
        int amount = withdrawView.getAmount();
        withdrawAmount(amount);
    }

    private KeyAdapter enterPressed = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                getUserInput();
            }
        }
    };

    private ActionListener withdrawClicked = e -> {
        getUserInput();
    };

    public void withdrawAmount(int amount){
        boolean isTransactionCompleted = model.withdrawAmount(amount);

        if (isTransactionCompleted) {
            writeMessageToTheCustomer("Transaction successful");
        } else {
            writeMessageToTheCustomer("Transaction Failed");
        }

    }

    private void writeMessageToTheCustomer(String message) {
        this.withdrawView.addMesaggeToTheUser(message);
        this.withdrawView.makeFieldInvisble();
    }


}

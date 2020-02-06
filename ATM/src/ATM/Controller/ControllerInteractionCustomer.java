package ATM.Controller;

import ATM.Model.Model;
import ATM.View.*;

import java.awt.event.ActionListener;

public class ControllerInteractionCustomer {


    private IntercationViewCustomer intercationViewCustomer;
    private Model model;

    public ControllerInteractionCustomer(IntercationViewCustomer intercationViewCustomer, Model model) {
        this.intercationViewCustomer = intercationViewCustomer;
        this.model = model;

        this.intercationViewCustomer.addListenerToLogoutButton(logout);
        this.intercationViewCustomer.addMessageToTheCustomer(model.getWelcomingMessage());
        this.intercationViewCustomer.addListenerToWithdrawButton(withdrawListener);
        this.intercationViewCustomer.addListenerToBalanceButton(balanceListener);
        this.intercationViewCustomer.addListenerToHistoryButton(historyListener);
    }

    ActionListener logout=e->{
        this.intercationViewCustomer.dispose();
        new ControllerLoginCustomer(new Model(),new LoginViewCustomer());
    };

    ActionListener withdrawListener=e->{
        new ControllerWithdrawCustomer(new WithdrawView(),model);
    };

    ActionListener balanceListener=e->{
        new BalanceView(model.displayBalance());
    };

    ActionListener historyListener=e->{
        new HistoryViewCustomer(model.displayHistory());
    };



}

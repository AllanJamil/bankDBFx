package ATM.Controller;

import ATM.Model.Model;
import ATM.View.ChooseAccountViewCustomer;
import ATM.View.IntercationViewCustomer;

import java.awt.event.ActionListener;

public class ControllerChooseAccount {

    ChooseAccountViewCustomer view;
    Model model;

    public ControllerChooseAccount(ChooseAccountViewCustomer view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addChoicesToComboBox(model.getAccountList());
        this.view.addListenerOkButton(okButtonListener);
    }


    ActionListener okButtonListener=e->{
        model.setChoosenAccount(view.getSelectedChoice());
        new ControllerInteractionCustomer(new IntercationViewCustomer(),model);
        view.dispose();
    };

}

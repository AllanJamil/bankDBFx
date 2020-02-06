package ATM.View;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.List;

public class ChooseAccountViewCustomer extends JFrame {

    private JComboBox comboBox1;
    private JButton okButton;
    private JPanel panel;
    private JLabel label;

    public ChooseAccountViewCustomer(){
        add(panel);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    public void addChoicesToComboBox(List<String> choices){
        choices.forEach(comboBox1::addItem);
    }

    public void addListenerOkButton(ActionListener actionListener){
        okButton.addActionListener(actionListener);
    }

    public int getSelectedChoice(){
      return  comboBox1.getSelectedIndex();
    };
}

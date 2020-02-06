package ATM.View;

import javax.swing.*;

public class BalanceView extends JFrame {

    private JPanel panel1;
    private JLabel titleLabel;
    private JTextPane balanceLabel;

    public BalanceView(String balance) {
        add(panel1);
        balanceLabel.setText(balance);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addBalanceToTheBalanceLable(String balance) {
        this.balanceLabel.setText(balance);
    }
}

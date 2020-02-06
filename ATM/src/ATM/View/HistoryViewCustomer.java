package ATM.View;

import javax.swing.*;

public class HistoryViewCustomer extends JFrame {


    private JLabel historyLabel;
    private JScrollPane scrollPane;
    private JPanel panel1;
    private JTextArea textArea;

    public HistoryViewCustomer(String history){
        textArea.setLineWrap(true);
        textArea.setText(history);
        add(panel1);
        setSize(700,500);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}

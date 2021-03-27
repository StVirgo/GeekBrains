package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SqrtButtonListener implements ActionListener {
    private final JTextField in;
    private Double result;


    public SqrtButtonListener(JTextField in) {
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ResultButtonListener resultButtonListener = new ResultButtonListener(in);
        resultButtonListener.resultMethod();
        result = Math.sqrt(Double.parseDouble(in.getText()));
        in.setText("" + result);

    }
}

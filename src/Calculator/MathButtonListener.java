package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathButtonListener implements ActionListener {
    private final JTextField in;

    public MathButtonListener(JTextField in) {
        this.in = in;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String lastSymbol = in.getText().substring(in.getText().length()-1);

        if (lastSymbol.equals("1") || lastSymbol.equals("2") || lastSymbol.equals("3") || lastSymbol.equals("4") ||
                lastSymbol.equals("5") || lastSymbol.equals("6") || lastSymbol.equals("7") || lastSymbol.equals("8") ||
                lastSymbol.equals("9") || lastSymbol.equals("0")) {
            JButton btn = (JButton) e.getSource();
            StringBuilder stringBuilder = new StringBuilder(in.getText());
            stringBuilder.append(btn.getText());
            in.setText(stringBuilder.toString());
        }

    }

}

package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonListener implements ActionListener {
    private final JTextField in;

    public ClearButtonListener(JTextField in) {
        this.in = in;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        in.setText(null);
    }
}

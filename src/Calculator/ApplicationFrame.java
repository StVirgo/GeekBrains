package Calculator;

import javax.swing.*;
import java.awt.*;

public class ApplicationFrame extends JFrame {
    public ApplicationFrame(){
        setTitle("Calculator v1.0");
        setBounds(50,50,350,450);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setJMenuBar(showMenuBar());
        setLayout(new BorderLayout());

        JPanel top = createTop();
        add(top, BorderLayout.NORTH);

        Component component = top.getComponent(0);
        add(createBottom((JTextField) component), BorderLayout.CENTER);






        setVisible(true);
    }
    private JPanel createBottom(JTextField in){
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(4,3));

        JPanel right = new JPanel();
        add(right, BorderLayout.EAST);
        right.setLayout(new GridLayout(4,1));



        ButtonListener buttonListener = new ButtonListener(in);
        ResultButtonListener resultButtonListener = new ResultButtonListener(in);
        MathButtonListener mathButtonListener = new MathButtonListener(in);
        SqrtButtonListener sqrtButtonListener = new SqrtButtonListener(in);
        ClearButtonListener clearButtonListener = new ClearButtonListener(in);


        for (int i = 0; i < 10; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(buttonListener);
            bottom.add(btn);
        }
        JButton clear = new JButton("C");
        clear.addActionListener(clearButtonListener);
        right.add(clear);
        JButton calc = new JButton("=");
        calc.addActionListener(resultButtonListener);
        right.add(calc);
        JButton minus = new JButton("-");
        minus.addActionListener(mathButtonListener);
        right.add(minus);
        JButton plus = new JButton("+");
        plus.addActionListener(mathButtonListener);
        right.add(plus);
        JButton multiplication = new JButton("*");
        multiplication.addActionListener(mathButtonListener);
        right.add(multiplication);
        JButton division = new JButton("/");
        division.addActionListener(mathButtonListener);
        right.add(division);
        JButton sqrt = new JButton("sqrt");
        sqrt.addActionListener(sqrtButtonListener);
        right.add(sqrt);



        return bottom;
    }


    private JPanel createTop(){
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        JTextField in = new JTextField();
        in.setEditable(false);

        top.add(in, BorderLayout.NORTH);

        return top;
    }
    private JMenuBar showMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = menuBar.add(new JMenu("File"));

        JMenuItem exit = menu.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitButtonListener());

        setJMenuBar(menuBar);
        return menuBar;

    }
}
package Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultButtonListener implements ActionListener{

    private final JTextField in;


    public ResultButtonListener(JTextField in) {
        this.in = in;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resultMethod();
    }

    public void resultMethod() {
        String result;
        String inputString;
        String[] tempString = new String[1];
        String str;
        String[] newTempString;
        inputString = in.getText();
        if (in.getText() != null) {

            if (!mathEquals(inputString.charAt(inputString.length()-1))) {
                for (int j = 0; j < tempString.length; j++) {
                    inputString = inputString.substring(0,inputString.length()-1);
                }

            }


            int currentNumber = 0;
            tempString[currentNumber] = "" + inputString.charAt(0);

            for (int i = 1; i < inputString.length(); i++) {
                if (mathEquals(inputString.charAt(i))) {
                    tempString[currentNumber] = tempString[currentNumber] + inputString.charAt(i);
                } else {
                    newTempString = new String[tempString.length + 2];
                    for (int j = 0; j < tempString.length; j++) {
                        newTempString[j] = tempString[j];
                    }
                    newTempString[tempString.length] = "" + inputString.charAt(i);
                    newTempString[tempString.length + 1] = "";
                    currentNumber = currentNumber + 2;
                    tempString = newTempString;

                }

            }

            for (int i = 0; i < tempString.length; i++) {
                System.out.print(tempString[i] + " ");
            }
            System.out.println("");
            System.out.println("_________________");

            for (int i = 0; i < tempString.length; i++) {
                if (tempString[i].equals("*")){
                    String tempResult = "" + (Double.parseDouble(tempString[i-1]) * Double.parseDouble(tempString[i+1]));
                    tempString[i-1] = tempResult;
                    newTempString = new String[tempString.length - 2];
                    for (int j = 0; j < i; j++) {
                        newTempString[j] = tempString[j];
                    }
                    for (int m = i; m < newTempString.length; m++) {
                        newTempString[m] = tempString[m+2];
                    }
                    tempString = newTempString;
                    i = 0;
                }

            }
            for (int i = 0; i < tempString.length; i++) {
                System.out.print(tempString[i] + " ");
            }
            System.out.println("");
            System.out.println("_________________");
            for (int i = 0; i < tempString.length; i++) {
                if (tempString[i].equals("/")){
                    String tempResult = "" + (Double.parseDouble(tempString[i-1]) / Double.parseDouble(tempString[i+1]));
                    tempString[i-1] = tempResult;
                    newTempString = new String[tempString.length - 2];
                    for (int j = 0; j < i; j++) {
                        newTempString[j] = tempString[j];
                    }
                    for (int m = i; m < newTempString.length; m++) {
                        newTempString[m] = tempString[m+2];
                    }
                    tempString = newTempString;
                    i = 0;
                }

            }
            for (int i = 0; i < tempString.length; i++) {
                System.out.print(tempString[i] + " ");
            }
            System.out.println("");
            System.out.println("_________________");
            for (int i = 0; i < tempString.length; i++) {
                if (tempString[i].equals("+")){
                    String tempResult = "" + (Double.parseDouble(tempString[i-1]) + Double.parseDouble(tempString[i+1]));
                    tempString[i-1] = tempResult;
                    newTempString = new String[tempString.length - 2];
                    for (int j = 0; j < i; j++) {
                        newTempString[j] = tempString[j];
                    }
                    for (int m = i; m < newTempString.length; m++) {
                        newTempString[m] = tempString[m+2];
                    }
                    tempString = newTempString;
                    i = 0;
                }

            }
            for (int i = 0; i < tempString.length; i++) {
                System.out.print(tempString[i] + " ");
            }
            System.out.println("");
            System.out.println("_________________");
            for (int i = 0; i < tempString.length; i++) {
                if (tempString[i].equals("-")){
                    String tempResult = "" + (Double.parseDouble(tempString[i-1]) - Double.parseDouble(tempString[i+1]));
                    tempString[i-1] = tempResult;
                    newTempString = new String[tempString.length - 2];
                    for (int j = 0; j < i; j++) {
                        newTempString[j] = tempString[j];
                    }
                    for (int m = i; m < newTempString.length; m++) {
                        newTempString[m] = tempString[m+2];
                    }
                    tempString = newTempString;
                    i = 0;
                }

            }
            for (int i = 0; i < tempString.length; i++) {
                System.out.print(tempString[i] + " ");
            }
            System.out.println("");
            System.out.println("_________________");




            result = tempString[0];
        } else result = null;


        in.setText(result);
    }

    public boolean mathEquals(char ch){
        return ((ch == '0') || (ch == '1') || (ch == '2') || (ch == '3') || (ch == '4') || (ch == '5')
                || (ch == '6') || (ch == '7') || (ch == '8') || (ch == '9') || (ch == '.'));
    }
}

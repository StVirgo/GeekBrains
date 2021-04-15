package ru.geekbrains.HW_Lvl_2_lesson_2;

public class Main {

    public static void main(String[] args) {

        String[][] mass = {{"1","1","1","1"},{"1","1","x","x"},{"1","x","1","x"},{"1","1","1","1"},{"1","1","1","1"}};
        checkArrayLength(mass);
        System.out.println("Сумма элементов массива равна: " + sumMassive(mass));










    }
    private static boolean checkArrayLength(String[][] a){
        if ((a.length == 4) && (a[0].length == 4)){
            return true;
        }   else {try{
            throw new MyArraySizeException("Неверный размер массива");
        } catch (MyArraySizeException e){
            e.printStackTrace();
        } return false;
        }

    }
    private static int sumMassive(String[][] mass){
        int sum = 0;
        int m;
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[0].length; j++) {
                if (isDigit(mass[i][j])) {
                    m = Integer.parseInt(mass[i][j]);
                    sum = sum + m;
                } else {
                    try{
                        throw new MyArrayDataException("Неверный тип элемента", i, j);
                    } catch (MyArrayDataException e){
                        e.printStackTrace();
                    }

                }
            }
        }

        return sum;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

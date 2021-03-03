package com.company;

public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        int[] array = {4, 5, 2, -10, 234, 112, 2, 3, 11, 2};
        task5(array);
        task6(array);
        int k = -2;
        task7(array, k);
    }
    static void task1() {
        byte[] numbers = {1, 0, 1, 1, 0, 0, 0, 1};
        for (int i = 0;i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 1;
            }   else numbers[i] = 0;
        }
    }
    static void task2() {
        int[] numbers;
        numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) numbers[i] = i * 3;
    }
    static void task3() {
        int[] numbers = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 6) numbers[i] = numbers[i] * 2;
        }
    }
    static void task4() {
        int[][] numbers;
        numbers = new int[8][8];
        for (int i = 0; i < numbers.length; i++){
            numbers[i][i] = 1;
        }
    }
    static void task5(int[] numbers) {
        int min = numbers[0];
        int max = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            } else if (numbers[i] > max) {
                max = numbers[i];
            }
        }
    }
    static boolean task6(int[] numbers){
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum = sum + numbers[i];
        }
        if ((sum % 2) == 0) {
            int left = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (left == sum) {
                    return true;
                }   else if (left < sum) {
                    left = left + numbers[i];
                }   else return false;
            }
        }
        return false;
    }
    static void task7(int[] numbers, int k) {
        int temp;
        if (k >= 0){
            for (int j = k; j > 0; j--) {
                temp = numbers[numbers.length-1];
                for (int i = numbers.length; i > 1; i--) {    //Идея предложила замену на System.arraycopy решил не менять. Откоментите плиз этот момент. Может нужно было? я почитал документацию на этот метод и как я понял производиться копирование одного массива со сдвигом в другой массив. Если бы его можно было использовать имея один массив, тогда была бы одна строка. место того что я наворотил;
                    numbers[i-1]=numbers[i-2];
                }
                numbers[0] = temp;
            }
        } else {
            for (int j = Math.abs(k); j > 0; j--) {
                temp = numbers[0];
                for (int i = 0; i < numbers.length - 1; i++) {   // Тоже самое
                    numbers[i]=numbers[i+1];
                }
                numbers[numbers.length-1] = temp;
            }
        }
    }

}

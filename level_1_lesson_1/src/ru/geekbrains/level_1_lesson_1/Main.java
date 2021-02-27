package ru.geekbrains.level_1_lesson_1;


import java.util.Scanner;

public class Main {
    private static Scanner scanner;

    public static void main(String[] args) {
        task_2();

        float result = task_3();
        System.out.println(result);

        System.out.println("Введите два числа для проверки ");
        int number_1 = scanner.nextInt();
        int number_2 = scanner.nextInt();
        String result_task_4 = task_4(number_1, number_2);
        System.out.println(result_task_4);

        System.out.println("Введите число для проверки на положительность");
        int number_3 = scanner.nextInt();
        String result_task_5 = task_5(number_3);
        System.out.println(result_task_5);

        System.out.println("Введите число для задания шесть");
        int number_4 = scanner.nextInt();
        boolean result_task_6 = task_6(number_4);

        System.out.print("Введите ваше имя: ");
        String name_2 = scanner.next();
        task_7(name_2);

        System.out.println("Введите год");
        int number_5 = scanner.nextInt();
        task_8(number_5);

        scanner.close();

    }
    static void task_2(){       // второе задание
        byte bt = 120;
        short sh = 31690;
        int in = 3211123;
        long lg = 123434232;
        float flt = 1.2324f;
        double dbl = 1.2324;
        boolean bl = true;
        char ch = 'h';
    }

    static float task_3() {      // третье задание
        float a = 1.123f;
        float b = 4.324f;
        float c = 5.123f;
        float d = 9.265f;
        float result = a * ( b + ( c / d ));
        return result;
    }

    static String task_4(int a, int b) {        // четвертое задание
        if ((a + b) >= 10 && (a + b) <= 20) {
            return "Сумма чисел лежит в допустимых значениях";
        }   else return "Сумма чисел дежит за границами допустимых значений";
    }

    static String task_5(int a) {        // пятое задание
        if (a >= 0) {
            return "Число положительное";
        }   else return "Число отрицательное";
    }

    static boolean task_6(int a) {        // шестое задание
        if (a < 0) {
            return true;
        }   else return false;
    }

    static void task_7(String name){       // седьмое задание
        System.out.println("Привет, " + name);
    }


    static {
        scanner = new Scanner(System.in);
    }

    static void task_8(int a) {        // восьмое задание задание
        if (((a % 4 == 0) && (a % 100 != 0)) || ((a % 400) == 0)) {
            System.out.println("Год является високосным");
        }   else System.out.println("Год не является високосным");
    }


}

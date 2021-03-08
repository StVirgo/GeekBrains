package ru.geekbrains.Level_1_lesson_3;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        guessTheNumber(10, 3);
        guessTheWord(5);


        scanner.close();

    }
    static void guessTheWord(int a) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        int hidden = random.nextInt(25);
        int a1 = a;
        String wordHidden = words[hidden];
        String sample = wordHidden + "###############";

        System.out.printf("Программа загадала одно слово из пятнадцати. Попробуйте отгдадать его! Количество попыток: %d!%n", a);
        for (; a > 0; a--) {
            String result = "";
            System.out.println("Введите слово:");
            String word = scanner.next();
            String samplePlayer = word + "###############";
            if (word.equals(wordHidden)) {
                System.out.println("Поздравляем! Вы угадали!");
                break;
            } else {
                for (int j = 0; j < 15; j++) {

                }
                for (int i = 0; i < 15 ; i++) {
                    char c =samplePlayer.charAt(i);
                    char d = sample.charAt(i);
                    if (c == d) {
                        result = result + "" + c;
                    } else result = result + "#";
                }
            }
            System.out.printf("Неверно! Осталось попыток: %d. Отгаданные символы: %s.%n", a-1, result);
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int consent = scanner.nextInt();
        if (consent == 1) {
            guessTheWord(a1);
        } else System.out.println("Ну и не надо!!");


    }


    static void guessTheNumber(int a, int b){
        int hidden = random.nextInt(a);
        int b1 = b;
        System.out.printf("Программа загадала число в пределе от 0 и до %d. Попробуйте отгдадать его! Количество попыток: %d!%n", a-1, b);
        for (; b > 0; b--) {
            System.out.println("Введите число:");
            int number = scanner.nextInt();
            if (number == hidden) {
                System.out.println("Поздравляем! Вы угадали!");
                break;
            } else if (number < hidden) {
                System.out.printf("Неверно! Загаданное число больше! Осталось попыток: %d.%n", b-1);
            } else System.out.printf("Неверно! Загаданное число меньше! Осталось попыток: %d.%n", b-1);
        }
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int consent = scanner.nextInt();
        if (consent == 1) {
            guessTheNumber(a, b1);
        } else System.out.println("Ну и не надо!!");

    }




}
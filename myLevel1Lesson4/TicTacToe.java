package ru.geekbrains.myLevel1Lesson4;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    static void start(){
        char[][] field = newField();
        drawField(field);

        while (true) {
            int[] lastPlayerMove = playerMove(field);
            drawField(field);
            if (win(field, 'X')) {
                System.out.println("Поздравляем! Вы выйграли!!!");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Ничья! Игра закончена!");
                break;
            }
            compMove(field, lastPlayerMove);
            drawField(field);
            if (win(field, 'O')) {
                System.out.println("Вы проиграли");
                break;
            }
            if (isDraw(field)) {
                System.out.println("Ничья! Игра закончена!");
                break;
            }
        }

    }


    static  boolean win(char[][] field, char symbol){
        /**
         * Horizontal check
         */
        for (int i = 0; i < field.length; i++) {
            int check = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == symbol) {
                    check++;
                }
            }
            if (check > 3 && ((field[i][0] != symbol) || (field[i][field.length-1] != symbol) )) {
                return true;
            }
        }
        /**
         * Vertical check
         */
        for (int i = 0; i < field.length; i++) {
            int check = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[j][i] == symbol) {
                    check++;
                }
            }
            if (check > 3 && ((field[0][i] != symbol) || (field[field.length-1][i] != symbol) )) {
                return true;
            }
        }
        /**
         * Small diagonal
         */
        if (field[1][0] == symbol && field[2][1] == symbol && field[3][2] == symbol && field[4][3] == symbol) {
            return true;
        }
        if (field[0][1] == symbol && field[1][2] == symbol && field[2][3] == symbol && field[3][4] == symbol) {
            return true;
        }
        if (field[0][3] == symbol && field[1][2] == symbol && field[2][1] == symbol && field[3][0] == symbol) {
            return true;
        }
        if (field[4][1] == symbol && field[3][2] == symbol && field[2][3] == symbol && field[1][4] == symbol) {
            return true;
        }
        /**
         * Main diagonal
         */
        int check = 0;
        int j = 0;
        for (int i = 0; i < field.length; i++) {
                if (field[i][j] == symbol) {
                    check++;
                }
            ++j;
        }
        if (check > 3 && ((field[0][0] != symbol) || (field[field.length-1][field.length-1] != symbol) )) {
            return true;
        }
        /**
         * Second diagonal
         */
        check = 0;
        j = field.length-1;
        for (int i = 0; i < field.length; i++) {
            if (field[i][j] == symbol) {
                check++;
            }
            --j;
        }
        if (check > 3 && ((field[0][field.length-1] != symbol) || (field[field.length-1][0] != symbol) )) {
            return true;
        }




        return false;
    }
    static void compMove(char[][] field, int[] lastPlayerMove){
        Random random = new Random();
        int x, y;
        int leftBorder, rightBorder, topBorder, bottomBorder;
        if (lastPlayerMove[0] == 0) {
            topBorder = lastPlayerMove[0];
            bottomBorder = lastPlayerMove[0] + 1;
        }   else if (lastPlayerMove[0] == (field.length - 1)){
            bottomBorder = lastPlayerMove[0];
            topBorder = lastPlayerMove[0] - 1;
        }   else {
            bottomBorder = lastPlayerMove[0] + 1;
            topBorder = lastPlayerMove[0] - 1;
        }
        if (lastPlayerMove[1] == 0) {
            rightBorder = lastPlayerMove[1] + 1;
            leftBorder = lastPlayerMove[1];
        }   else if (lastPlayerMove[1] == (field.length - 1)){
            rightBorder = lastPlayerMove[1];
            leftBorder = lastPlayerMove[1] - 1;
        }   else {
            rightBorder = lastPlayerMove[1] + 1;
            leftBorder = lastPlayerMove[1] - 1;
        }
        int diffHorizontal = rightBorder - leftBorder;
        int diffVertical = bottomBorder - topBorder;

        for (int i = 0; i < 20; i++) {
            x = random.nextInt(diffVertical + 1) + topBorder;
            y = random.nextInt(diffHorizontal + 1) + leftBorder;
            if (isOkCell(field, x, y)) {
                field[x][y] = '0';
                return;
            }
        }

        do {
            x = random.nextInt(5);
            y = random.nextInt(5);
        } while (isBadCell(field, x, y));
        field[x][y] = '0';
    }


    static boolean isDraw (char[][] field){
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (isOkCell(field, i , j)){
                    return false;
                }
            }
        }
        return true;
    }




    static int[] playerMove (char[][] field){
        int x, y;
        do {
            x = getCoordinate(field.length, "по вертикале.");
            y = getCoordinate(field.length, "по горизонтале.");
        }   while (isBadCell(field, x, y));
        field[x][y] = 'X';
        int[] lastPlayerMove = {x, y};
        return lastPlayerMove;
    }


    static int getCoordinate(int length, String dim){
        Scanner scanner = new Scanner(System.in);
        int coordinate;

        do {
            System.out.printf("Введите координату %s...%n", dim);
            coordinate = scanner.nextInt() - 1;
        }   while (coordinate < 0 || coordinate >= length);
        return coordinate;
    }






    static boolean isOkCell(char[][] field, int x, int y){
        return !isBadCell(field, x, y);
    }


    static boolean isBadCell(char[][] field, int x, int y) {
        return field[x][y] != '-';
    }


    static void drawField(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static char[][] newField() {
        return new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'}
        };

    }
}

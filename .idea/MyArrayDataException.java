package ru.geekbrains.HW_Lvl_2_lesson_2;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(String message, int i, int j) {
        super(message + "Номер элемента: i=" + i + " j=" + j);
    }
}
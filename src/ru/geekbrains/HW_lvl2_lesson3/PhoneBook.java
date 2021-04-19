package ru.geekbrains.HW_lvl2_lesson3;


public class PhoneBook {
    private String[][] phoneBook = new String[2][1];

    public void add(String name, String phone){
        phoneBook[0][phoneBook[0].length-1] = name;
        phoneBook[1][phoneBook[0].length-1] = phone;
        extendArrays();

    }
    public void get(String name){
        for (int i = 0; i < phoneBook[0].length - 1; i++) {
            if (phoneBook[0][i].equals(name)) {
                System.out.println(name + ": " + phoneBook[1][i]);
            }
        }

    }


    private void extendArrays() {
        String[][] tempPhoneBook = new String[2][phoneBook[0].length+1];
        for (int i = 0; i < phoneBook[0].length; i++) {
            tempPhoneBook[0][i] = phoneBook[0][i];
            tempPhoneBook[1][i] = phoneBook[1][i];
        }
        phoneBook = tempPhoneBook;

    }

}

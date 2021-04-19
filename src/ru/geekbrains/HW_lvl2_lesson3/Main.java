package ru.geekbrains.HW_lvl2_lesson3;

public class Main {

    public static void main(String[] args) {

        String[] words = {"lang", "color", "eat", "eat", "color", "eat", "eat", "color", "color", "lang",
                "lang", "color", "eat", "lang", "eat"};
        Counter counter = new Counter();
        counter.count(words);
        counter.getCounter();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov","+77536868589");
        phoneBook.add("Ivanov","+79245248589");
        phoneBook.add("Sidorov","+79248528589");
        phoneBook.add("Ivanov","+79245243589");
        phoneBook.add("Ivanova","+79249512889");
        phoneBook.add("Markov","+79245868589");
        phoneBook.add("Gurbino","+79275368589");
        phoneBook.get("Ivanov");











    }

}

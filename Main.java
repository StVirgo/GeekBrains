package ru.geekbrains.level_1_lesson_5;

public class Main {

    public static void main(String[] args) {
        Worker[] workersArray = new Worker[5];
        workersArray[0] = new Worker("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 21);
        workersArray[1] = new Worker("Solno Oleg", "Worker", "sooleg@mailbox.com", "898459625", 27500, 56);
        workersArray[2] = new Worker("Ivanov Maks", "Engineer", "ivmaks@mailbox.com", "854861235", 30000, 42);
        workersArray[3] = new Worker("Bobodjonov Gurgali", "Worker", "bogurg@mailbox.com", "877561212", 17500, 27);
        workersArray[4] = new Worker("Dgimiev Victor", "Manager", "dgvictor@mailbox.com", "865231525", 45000, 46);

        for (int i = 0; i < workersArray.length; i++) {
            if (workersArray[i].getAge() >= 40) {
                workersArray[i].printData();
            }

        }

    }
}
package ru.geekbrains.level_1_lesson_5;

public class Worker {
    private String fullName;
    private String prof;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public int getAge() {
        return age;
    }

    public Worker(String fullName, String prof, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.prof = prof;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printData (){
        System.out.printf("Full name: %s, profession: %s, e-mail: %s, Phone Number: %s, Salary: %d, Age: %d.%n", this.fullName, this.prof, this.email, this.phoneNumber, this.salary, this.age);
    }
}

package HW_Zoo;

import java.util.Random;

public abstract class Animal {
    private final String name;
    private final String type;
    private final int appetite;
    private final int maxDistanceRun;
    private final int maxDistanceSwim;
    private boolean fullness;

    Random random = new Random();

    public Animal(String name, String type, int maxDistanceRun, int maxDistanceSwim) {
        this.name = name;
        this.type = type;
        this.appetite = random.nextInt(10) + 1;
        this.maxDistanceRun = maxDistanceRun;
        this.maxDistanceSwim = maxDistanceSwim;
        this.fullness = false;
    }


    public String getType() {
        return type;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public String isFullness() {
        return this.name + " fullness: " + fullness;
    }

    public int getAppetite() {
        return appetite;
    }

    public void run(int distance) {
        if (distance <= maxDistanceRun) {
            System.out.printf("%s with name %s run %s m.%n", type, name, distance);
        } else {
            System.out.printf("%s with name %s didn't run %s m.%n", type, name, distance);
        }
    }

    public void swim(int distance){
        if (distance <= maxDistanceSwim) {
            System.out.printf("%s with name %s swim %s m.%n", type, name, distance);
        } else {
            System.out.printf("%s with name %s didn't swim %s m.%n", type, name, distance);
        }
    }
    @Override
    public String toString() {
        return "Animal{" + "type=" + type + " Name=" + name + ", appetite=" + appetite + " Fullness:" + fullness + "}";
    }
}

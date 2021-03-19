package HW_Zoo;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Paddoсk paddock1 = new Paddoсk();
        Counter counter = new Counter();
        Plate plate = new Plate();
        paddock1.addAnimal(new Cat("Kitty"),
                new Cat("Pop"),
                new Dog("Doggy"),
                new Dog("Jimmy"),
                new Cat("Star"));
        paddock1.addAnimal(new Dog("Kitty"),
                new Cat("Bob"),
                new Dog("Lumber"));

        Animal[] animals = paddock1.getPaddock();

        counter.count(animals);
        counter.getCounter();
        counter.refreshCounter();

        counter.count(animals);
        counter.getCounter();

        plate.cleaningPlate();
        plate.increaseFood(15);

        for (Animal animal : animals) {
            animal.setFullness(plate.decreaseFood(animal.getAppetite()));
        }






        System.out.println(Arrays.toString(paddock1.getPaddock()));

        System.out.println("Amount Food = " + plate.getAmountFood());


        for (Animal animal : animals) {
            animal.swim(8);
        }
        for (Animal animal : animals) {
            animal.run(256);
        }
        for (Animal animal : animals) {
            System.out.println(animal.isFullness());
        }

    }


}

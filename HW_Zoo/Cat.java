package HW_Zoo;

public class Cat extends Animal{

    public Cat(String name) {
        super(name, "Cat",  200, -1);

    }

    @Override
    public void swim(int distance) {
        System.out.println("Cats cannot swim!");
    }
}

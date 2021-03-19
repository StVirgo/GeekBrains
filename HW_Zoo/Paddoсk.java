package HW_Zoo;

public class Paddoсk {

    private Animal[] paddock;

    public Animal[] getPaddock() {
        return paddock;
    }

    public Paddoсk() {
        paddock = new Animal[0];
    }

    public void addAnimal(Animal... animals) {
        Animal[] newAnimals = new Animal[paddock.length + animals.length];
        for (int i = 0; i < paddock.length; i++) {
            newAnimals[i] = paddock[i];
        }
        for (int i = paddock.length; i < newAnimals.length; i++) {
            newAnimals[i] = animals[i - paddock.length];
        }
        paddock = newAnimals;

    }






}

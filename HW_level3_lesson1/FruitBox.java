package HW_level3_lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitBox<T extends Fruit> {
    private List<T> box;

    public FruitBox() {
        this.box = new ArrayList<>();
    }

    public FruitBox(T... fruits) {
        this.box = new ArrayList(Arrays.asList(fruits));
    }



    public float getWeight(){
        float totalWeight = 0.0f;
        for (T fruit : box) {
            totalWeight += fruit.getWeightFruit();
        }
        return totalWeight;
    }

    public void add(T add){
        box.add(add);
    }

    public void compare(FruitBox<?> another){
        if (Math.abs(this.getWeight() - another.getWeight()) < 0.0001){
            System.out.println("Коробки одинакового веса");
        } else System.out.println("Коробки неодинакового веса");
    }

    public void transfer(FruitBox<? super T> anotherBox){
        if(anotherBox == this){
            return;
        }
        anotherBox.box.addAll(this.box);
        this.box.clear();
    }

}

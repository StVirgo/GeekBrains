package HW_Zoo;

public class Plate {
    private int amountFood;

    public int getAmountFood() {
        return amountFood;
    }

    public void increaseFood(int amount) {
        amountFood = amountFood + amount;
    }

    public boolean decreaseFood(int amount) {
        if (amountFood >= amount) {
            amountFood -= amount;
            return true;
        }   return false;
    }

    public void cleaningPlate() {
        amountFood = 0;
    }

}

package HW_Zoo;

public class Counter {
    private int counter;
    private String[] typeArray = {};
    private int[] amountAnimal = {};



    public void count(Animal[] paddock){
        extendArrays();
        typeArray[0] = paddock[0].getType();
        amountAnimal[0]++;
        for (int i = 1; i < paddock.length; i++) {
            for (int j = 0; j < typeArray.length;) {
                ++j;
                if (paddock[i].getType().equals(typeArray[j-1])) {
                    amountAnimal[j-1]++;
                    break;
                }   else if (j == typeArray.length){
                    extendArrays();
                    typeArray[typeArray.length-1] = paddock[i].getType();
                    amountAnimal[amountAnimal.length - 1]++;
                    break;
                }

            }
        }
    }


    public void extendArrays() {
        String[] newTypeArray = new String[typeArray.length + 1];
        int[] newAmountAnimal = new int[amountAnimal.length +1];
        for (int i = 0; i < typeArray.length; i++) {
            newTypeArray[i] = typeArray[i];
        }
        for (int i = 0; i < amountAnimal.length; i++) {
            newAmountAnimal[i] = amountAnimal[i];
        }
        typeArray = newTypeArray;
        amountAnimal = newAmountAnimal;
    }

    public String[] getTypeArray() {
        return typeArray;
    }

    public int[] getAmountAnimal() {
        return amountAnimal;
    }

    public void getCounter(){
        for (int i = 0; i < typeArray.length; i++) {
            System.out.printf("Type: %s amount: %s.%n", typeArray[i], amountAnimal[i]);
        }
    }
    public void refreshCounter(){
        String[] emptyStringArray = {};
        int [] emptyIntArray = {};
        typeArray = emptyStringArray;
        amountAnimal = emptyIntArray;
    }
}
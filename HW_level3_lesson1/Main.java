package HW_level3_lesson1;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {






        String[] stringsArray = {"one","two","three","four"};
        changePositions(stringsArray,1,5);
        for (int i = 0; i < stringsArray.length; i++) {
            System.out.println(stringsArray[i] + "   ");
        }

        ArrayList<String> arrayList = (ArrayList<String>) convertArrayToList(stringsArray);
        System.out.println(arrayList.toString());
    }



    public static <T> List<T> convertArrayToList(T[] array){
        return new ArrayList<>(Arrays.asList(array));       // Тут Идея сама предложила сжать) у меня было чуть больше буквочек ;D
    }


    public static <T> T[] changePositions(T[] array, int firstPos, int secondPos){
        int firstIndex = firstPos - 1;
        int secondIndex = secondPos - 1;
        if ((firstIndex < array.length) && (secondIndex < array.length)){
            T tempElement;
            tempElement = array[firstIndex];
            array[firstIndex] = array[secondIndex];
            array[secondIndex] = tempElement;
        } else {
            System.out.println("Смена символов не удалась, неверные позиции.");
        }
        return array;
    }
}

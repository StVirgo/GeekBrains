import java.util.Arrays;

public class TestApp {

    public static void main(String[] args) throws InterruptedException {
        int[] test1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] test2 = { 1 ,2, 4, 4 ,2, 3, 4};
        int[] test3 = {1 ,2 ,44 ,2 ,34, 1, 2};
        int[] test4 = { 1, 2, 1, 7};
        tryConvertArray(test1);
        tryConvertArray(test2);
        tryConvertArray(test3);
        tryConvertArray(test4);

        //   [ 1 1 1 4 4 1 4 4 ] -> true
        //   [ 1 1 1 1 1 1 ] -> false
        //   [ 4 4 4 4 ] -> false
        //   [ 1 4 4 1 1 4 3 ] -> false

        Thread.sleep(2000);
        int[] test5 = {1 ,1, 1, 4 ,4 ,1 ,4 ,4 };
        System.out.println(testArrayForSevenAndFour(test5));
        int[] test6 = {1 ,1 ,1, 1 ,1 ,1};
        System.out.println(testArrayForSevenAndFour(test6));
        int[] test7 = {4 ,4, 4 ,4 };
        System.out.println(testArrayForSevenAndFour(test7));
        int[] test8 = {1 ,4 ,4 ,1, 1, 4 ,3 };
        System.out.println(testArrayForSevenAndFour(test8));
    }

    public static boolean testArrayForSevenAndFour(int[] inputMassive){
        boolean checkOne = false;
        boolean checkFour = false;
        for (int i = 0; i < inputMassive.length; i++) {
            if (inputMassive[i] == 1){
                checkOne = true;
            } else if (inputMassive[i] == 4){
                checkFour = true;
            }   else return false;
        }
        if ((checkFour == true)&&(checkOne == true)){
            return true;
        } else return false;
    }





    public static int[] convertArray(int[] inputMassive){
        int lastIndex = -1;
        int[] returnMassive;
        for (int i = 0; i < inputMassive.length; i++) {
            if (inputMassive[i] == 4){
                lastIndex = i;
            }
        }

        if (lastIndex == -1) {
            throw new RuntimeException();
        } else {
            returnMassive = new int[inputMassive.length - lastIndex - 1];
            for (int i = 0; i < (inputMassive.length-lastIndex - 1); i++) {
                returnMassive[i] = inputMassive[i + lastIndex + 1];
            }
            return returnMassive;
        }
    }

    public static void tryConvertArray(int[] inputArray){
        try{
            System.out.println(Arrays.toString(convertArray(inputArray)));
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}


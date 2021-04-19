package ru.geekbrains.HW_lvl2_lesson3;


public class Counter {
    private String[] wordsArray = new String[1];
    private Integer[] amountWords = new Integer[1];


    public void count(String[] words){
        wordsArray[0] = words[0];
        amountWords[0] = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < wordsArray.length;) {
                ++j;
                if (words[i].equals(wordsArray[j-1])) {
                    amountWords[j-1]++;
                    break;
                }   else if (j == wordsArray.length){
                    extendArrays();
                    wordsArray[wordsArray.length-1] = words[i];
                    amountWords[amountWords.length - 1] = 1;
                    break;
                }

            }
        }
    }
    private void extendArrays() {
        String[] newWordsArray = new String[wordsArray.length + 1];
        Integer[] newAmountWords = new Integer[amountWords.length +1];
        for (int i = 0; i < wordsArray.length; i++) {
            newWordsArray[i] = wordsArray[i];
        }
        for (int i = 0; i < amountWords.length; i++) {
            newAmountWords[i] = amountWords[i];
        }
        wordsArray = newWordsArray;
        amountWords = newAmountWords;
    }

    public void getCounter(){
        for (int i = 0; i < wordsArray.length; i++) {
            System.out.printf("Words: %s amount: %s.%n", wordsArray[i], amountWords[i]);
        }
    }



}

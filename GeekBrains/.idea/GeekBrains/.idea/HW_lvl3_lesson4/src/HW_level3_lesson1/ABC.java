package HW_level3_lesson1;

public class ABC {
    private final Object mon = new Object();
    private String example;
    public char nextChar;

    public ABC(String example) {
        this.example = example;
        createThread(example);
    }

    private void createThread(String example){
        char[] exampleCharArray = example.toCharArray();
        nextChar = exampleCharArray[0];
        for (int i = 0; i < exampleCharArray.length; i++) {
            int current = i;
            if (i == exampleCharArray.length -1 ){

                new Thread(() -> worker(exampleCharArray[current], exampleCharArray[0])).start();
            }  else {
                new Thread(() -> worker(exampleCharArray[current], exampleCharArray[current+1])).start();
            }


        }
    }

    private void worker(char mainChar, char nextCharForThread){
        for (int i = 0; i < 5; i++) {
            synchronized (mon){
                while (mainChar != nextChar){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(mainChar);
                nextChar = nextCharForThread;
                mon.notifyAll();
            }
        }
    }



}

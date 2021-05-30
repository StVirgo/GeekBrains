package HW_level3_lesson1;

public class ABC_2 {
    private final Object mon = new Object();
    private String example;
    public int nextNumber;

    public ABC_2(String example) {
        this.example = example;
        createThread(example);
    }

    private void createThread(String example){
        char[] exampleCharArray = example.toCharArray();
        nextNumber = 0;
        for (int i = 0; i < exampleCharArray.length; i++) {
            int current = i;
            if (i == exampleCharArray.length -1 ){

                new Thread(() -> worker(exampleCharArray[current], current, 0)).start();
            }  else {
                new Thread(() -> worker(exampleCharArray[current], current,current + 1 )).start();
            }


        }
    }

    private void worker(char mainChar, int myNumber, int nextNumberForThread){
        for (int i = 0; i < 5; i++) {
            synchronized (mon){
                while (myNumber != nextNumber){
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(mainChar);
                nextNumber = nextNumberForThread;
                mon.notifyAll();
            }
        }
    }
}

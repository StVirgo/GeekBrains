import org.junit.jupiter.api.Assertions;

public class Test {
    @org.junit.jupiter.api.Test
    public void test1(){
        int[] in = new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] out = new int[]{1, 7};
        Assertions.assertArrayEquals(out, TestApp.convertArray(in));
    }

    @org.junit.jupiter.api.Test
    public void test2(){
        int[] in = new int[]{1 ,2, 4, 4 ,2, 3, 4};
        int[] out = new int[]{};
        Assertions.assertArrayEquals(out, TestApp.convertArray(in));
    }
    @org.junit.jupiter.api.Test
    public void test3(){
        int[] in = new int[]{1 ,2 ,44 ,2 ,34, 1, 2};
        Assertions.assertThrows(RuntimeException.class, ()->{
            TestApp.convertArray(in);
        });
    }
    @org.junit.jupiter.api.Test
    public void test4(){
        int[] in = new int[]{1, 2, 1, 7};
        Assertions.assertThrows(RuntimeException.class, ()->{
            TestApp.convertArray(in);
        });
    }

    @org.junit.jupiter.api.Test
    public void test5(){
        int[] in = new int[]{1 ,1, 1, 4 ,4 ,1 ,4 ,4};
        Assertions.assertTrue(TestApp.testArrayForSevenAndFour(in));
    }
    @org.junit.jupiter.api.Test
    public void test6(){
        int[] in = new int[]{1 ,1 ,1, 1 ,1 ,1};
        Assertions.assertFalse(TestApp.testArrayForSevenAndFour(in));
    }

    @org.junit.jupiter.api.Test
    public void test7(){
        int[] in = new int[]{4 ,4, 4 ,4};
        Assertions.assertFalse(TestApp.testArrayForSevenAndFour(in));
    }

    @org.junit.jupiter.api.Test
    public void test8(){
        int[] in = new int[]{1 ,4 ,4 ,1, 1, 4 ,3};
        Assertions.assertFalse(TestApp.testArrayForSevenAndFour(in));
    }


}

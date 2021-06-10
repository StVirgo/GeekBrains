package TestApp;

public class Tests {

    @BeforeSuite
    public static void testBefore(){
        System.out.println("testBefore");
    }

    @Test
    public static void test1(){
        System.out.println("test1 priority = default");
    }

    @Test
    public static void test2(){
        System.out.println("test2 priority = default");
    }

    @Test(priority = 2)
    public static void test3(){
        System.out.println("test3 priority = 2");
    }

    @Test(priority = 1)
    public static void test4(){
        System.out.println("test4 priority = 1");
    }

    @Test(priority = 3)
    public static void test5(){
        System.out.println("test5 priority = 3");
    }

    @Test(priority = 9)
    public static void test6(){
        System.out.println("test6 priority = 9");
    }

    @Test(priority = 6)
    public static void test7(){
        System.out.println("test7 priority = 6");
    }

    @Test(priority = 7)
    public static void test8(){
        System.out.println("test8 priority = 7");
    }

    @AfterSuite
    public static void testAfter() {
        System.out.println("testAfter");
    }



}

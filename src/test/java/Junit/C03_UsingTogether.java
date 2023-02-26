package Junit;

import org.junit.*;

public class C03_UsingTogether {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class worked\n===============");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("===============\nAfter class worked ");
    }
    @Before
    public void before(){
        System.out.println("\nBefore worked");
    }
    @After
    public void after(){
        System.out.println("After worked");
    }
    @Test
    public void test01(){
        System.out.println("test01 worked");
    }
    @Test
    public void test02(){
        System.out.println("test02 worked");
    }
    @Test
    public void test03(){
        System.out.println("test03 worked");
    }
}

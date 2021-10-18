import org.testng.annotations.*;

public class BasicAnnotation {
    @Test
    public static void testCase1(){
        System.out.println("这是测试用例1");
    }

    /**
    public static void main(String[] args) {
        System.out.println("我是main 方法");
        testCase1();
    }
     */

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod");
    }

    @Test
    public void testCase2(){
        System.out.println("这是测试用例2");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass ");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite 测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite 测试套件");
    }
}

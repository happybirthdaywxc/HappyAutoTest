import org.testng.annotations.Test;


public class IgnoreTest {
    //忽略测试
    @Test
    public void ignore1(){
        System.out.println("ignore 1执行");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore22执行");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore33执行");
    }


}

package paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//切记Method包不能错
import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("name = " + name+ ";age=" + age);
    }

    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20},
                {"wangli", 30}
        };
        return o;
    }
    @Test(dataProvider = "methodData")
    public void test1(String name, int age){
        System.out.println("test11111方法 name=" + name+ ";age=" +age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name, int age){
        System.out.println("test222222方法 name=" + name+ ";age=" +age);
    }
    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){//重要：Method method
        Object[][] result=null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan", 20},
                    {"lisi", 25}
            };
        }else if(method.getName().equals("test2")){
            result = new Object[][]{
                    {"wangwu", 33},
                    {"zhaoliu", 55}
            };
        }
        return result;
    }
}

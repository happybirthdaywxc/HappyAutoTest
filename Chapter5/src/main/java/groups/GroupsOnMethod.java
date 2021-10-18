package groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组1111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组2222");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组3333");
    }

    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组444");
    }

    /**
     @BeforeGroups("server")
     public void beforeGroupsOnServer(){
     System.out.println("这是服务端组的运行之前的方法");
     }
     @AfterGroups("server")
     public void afterGroupsOnServer(){
     System.out.println("这是服务端组的运行之后的方法");
     }
     */
    @BeforeGroups("client")
    public void beforeGroupsOnServer(){
        System.out.println("这是客户端组的运行之前的方法");
    }
    @AfterGroups("client")
    public void afterGroupsOnServer(){
        System.out.println("这是客户端组的运行之后的方法");
    }
}

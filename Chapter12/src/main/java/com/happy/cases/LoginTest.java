package com.happy.cases;

import com.happy.config.TestConfig;
import com.happy.model.InterfaceName;
import com.happy.utils.ConfigFile;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.BeforeTest;

public class LoginTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作")
    public void beforeTest(){
        //
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl = ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.addUserUrl = ConfigFile.getUrl(InterfaceName.ADDUSERINFO);
        TestConfig.loginUrl = ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.updateUserInfoUrl = ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);

        TestConfig.defaultHttpClient = new DefaultHttpClient();


    }
}

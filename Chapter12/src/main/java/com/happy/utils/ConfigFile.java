package com.happy.utils;

import com.happy.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    //****** 来加载配置的变量
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        //最终的测试地址
        String testUrl;
        if(name == InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");
        }
        if(name.equals(InterfaceName.LOGIN)){
            uri = bundle.getString("login.uri");
        }
        if(name.equals(InterfaceName.UPDATEUSERINFO)){
            uri = bundle.getString("updateUserInfo.uri");
        }
        if(name.equals(InterfaceName.GETUSERINFO)){
            uri = bundle.getString("getUserInfo.uri");
        }
        if(name.equals(InterfaceName.ADDUSERINFO)){
            uri = bundle.getString("addUser.uri");
        }

        testUrl = address + uri;
        return null;
    }
}

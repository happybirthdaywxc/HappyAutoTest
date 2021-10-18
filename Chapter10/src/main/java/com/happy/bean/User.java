package com.happy.bean;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Data
@RestController
@Api(value = "/",description = "返回user数据的全部请求")
public class User {
    private String userName;
    private String password;
    private String name;
    private String age;
    private String sex;

    @RequestMapping(value = "getUserList",method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表",httpMethod = "POST")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User u
                            ){
        User user = new User();

        //获取cookies
        Cookie[] cookies = request.getCookies();
        //验证cookies是否合法
        for (Cookie c : cookies) {
            //字符串的比较必须用equals
            if(c.getName().equals("login")  && c.getValue().equals("true") && u.getUserName().equals("zhangsan")  && u.getPassword().equals("123456")){
                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return  user.toString();
            }
        }
        return "参数不合法";

    }

}

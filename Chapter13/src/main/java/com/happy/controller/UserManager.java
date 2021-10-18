package com.happy.controller;

import com.happy.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Value;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Objects;

//@Log4j
@RestController
@Api(value = "v1",description = "用户管理系统")
@RequestMapping("v1")
public class UserManager {
    @Autowired
    private SqlSession template;

    @ApiOperation(value = "登录接口",httpMethod = "POST")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Boolean login(HttpServletResponse response,
                            @RequestBody User user){
        int i = template.selectOne("login",user);

        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
//        log.info("查询到的结果是"  + i);
        if(i==1){
//            log.info("登录的用户是：" + user.getUserName());
                    return true;
        }
        return false;
    }

    @ApiOperation(value = "添加用户接口",httpMethod = "POST")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public boolean addUser(HttpServletRequest request,@RequestBody User user){
        Boolean x = verifyCookies(request);
        int result = 0;
        if(x != null){
            result = template.insert("addUser",user);
        }
        if(result > 0){
//            log.info("添加用户的数量是： "+ result);
        }
        return false;
    }

    private Boolean verifyCookies(HttpServletRequest request){
        Cookie[] cookies =request.getCookies();
        if(Objects.isNull(cookies)){
//            log.info("cookies 为空");
            return false;
        }

        for(Cookie cookie : cookies){
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
//                log.info("cookie 验证通过");
                return true;
            }
        }
        return false;
    }
    @ApiOperation(value = "获取用户（列表）信息接口",httpMethod = "POST")
    @RequestMapping(value = "/getUserInfo",method = RequestMethod.POST)
    public List<User> getUserInfo(HttpServletRequest request, @RequestBody User user){
        Boolean x = verifyCookies((request));
        if(x == true){
            List<User>users = template.selectList("getUserInfo");
//            log.info("getUserInfo 获取到的用户数量是：" + users.size());
        }
        return null;

    }

    @ApiOperation(value = "更新用户信息",httpMethod = "POST")
    @RequestMapping(value = "/updateUserInfo",method = RequestMethod.POST)
    public int updateUser(HttpServletRequest request, @RequestBody User user){
        Boolean x = verifyCookies((request));
        int i = 0;
        if(x == true){
            i = template.update("updateUserInfo",user);
//            log.info("更新数据的条目数是：" + i);
        }
        return i;
    }


}
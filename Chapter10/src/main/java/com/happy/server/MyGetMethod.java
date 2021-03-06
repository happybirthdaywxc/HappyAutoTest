package com.happy.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//10-4 jmeter设置访问
@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过此方法可以获取到cookie值",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息的类
        //HttpServerletResponse 装响应信息的类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies信息成功";
    }

    /**
     * 要求客户端携带cookies访问
     * 这是一个携带cookies信息才能访问的请求
     */
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie:cookies) {
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜你访问成功";
            }
        }
        return "你必须携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能呢官方问的get请求
     * 第一种实现方式 url:key=value&key=value
     * 我们来模拟获取商品的列表
     */
    @RequestMapping(value = "getWithParam",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能呢官方问的get请求",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam(value = "start",required = true) Integer start,
                                       @RequestParam Integer end){
        Map<String,Integer>myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url: ip:port/getWithParam/10//20
     */
    @RequestMapping(value = "getWithParam/{start}/{end}")
    @ApiOperation(value = "第二种需要携带参数访问的get请求",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,
                         @PathVariable Integer end){
        Map<String,Integer>myList = new HashMap<>();
        myList.put("鞋子",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }
}

package com.happy.controller;

import com.happy.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Log4j
@RestController
@Api(value = "v1",description = "这是我的第一个版本的demo")
@RequestMapping("v1")
public class Demo {
    //首先获取一个执行Sql语句的对象
    //autowired 启动及加载
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount",method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数",httpMethod = "GET")
    public int getUserCount(){
       return template.selectOne("getUserCount");//mysql.xml中的select id
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户",httpMethod = "POST")
    public int addUser(@RequestBody User user){
        int result = template.insert("addUser",user);
        return result;
    }

    @ApiOperation(value = "更新用户",httpMethod = "POST")
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public int updateUser(@RequestBody User user){
        return template.update("updateUser",user);
    }

    @ApiOperation(value = "删除用户",httpMethod = "DELETE")
    @RequestMapping(value = "deleteUser",method = RequestMethod.DELETE)
    public int deleteUser(@RequestParam int id){
        return template.delete("deleteUser",id);
    }

}

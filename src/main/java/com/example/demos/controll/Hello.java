package com.example.demos.controll;


import com.example.demos.model.User;
import com.example.demos.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/s")
public class Hello {


    @Autowired
    private UserService us;


    @ApiOperation(value = "获取单个User",notes = "获取单个User的JSON数据")
    @ApiImplicitParam(name = "id",value = "用户id",required = true,dataType = "int")
    @GetMapping(value = "/s/{id}")
    public User search(@PathVariable(value = "id") Integer id) {
        System.out.println(id);
        return us.getUser();
    }

    @GetMapping(value = "/d")
    public List<User> data() {
        return us.getUsers();
    }
}

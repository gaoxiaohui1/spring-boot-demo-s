package com.example.demos.controll;

import com.example.demos.model.UserInfo;
import com.example.demos.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "user")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    /**
     * 获取UserInfo
     * @param id
     * @return
     */
    @ApiOperation(value = "获取单个用户",notes = "获取单个用户的JSON数据")
    @GetMapping(value = "{id}")
    public UserInfo getUser(@PathVariable(value = "id") Integer id) {
        return service.getSingleUser(id);
    }

    /**
     * 获取UserInfo列表
     * @param key
     * @param value
     * @return
     */
    @ApiOperation(value = "获取用户列表",notes = "获取多个个用户的JSON数据")
    @GetMapping(value = "list")
    public List<UserInfo> getUsers(@RequestParam(value = "key",required = false) String key,
                                   @RequestParam(value = "value",required = false) String value) {
        ArrayList<String> list=new ArrayList<String>();
        if(key==null|| key.isEmpty()) {
            list.add("0");
        }else{
            list.add(key);
        }
        list.add(value);
        return service.getUsers(list);
    }

    /**
     * 新增UserInfo
     * @param name
     * @param gender
     * @param age
     * @param height
     * @return
     */
    @ApiOperation(value = "新增用户信息",notes = "返回新增用户的JSON数据")
    @PostMapping(value = "add")
    public UserInfo addUser(@RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "gender",required = false) String gender,
                            @RequestParam(value = "age",required = false) Integer age,
                            @RequestParam(value = "height",required = false) Double height) {
        UserInfo user=new UserInfo();
        user.setAge(age);
        user.setGender(gender);
        user.setHeight(height);
        user.setName(name);
        return service.addUser(user);
    }

    /**
     * 修改UserInfo
     * @param id
     * @param name
     * @param gender
     * @param age
     * @param height
     * @return
     */
    @ApiOperation(value = "修改用户信息",notes = "修改用户信息并返回用户的JSON数据")
    @PostMapping(value = "update")
    public UserInfo updateUser(@RequestParam(value = "id",required = false) Integer id,
                               @RequestParam(value = "name",required = false) String name,
                               @RequestParam(value = "gender",required = false) String gender,
                               @RequestParam(value = "age",required = false) Integer age,
                               @RequestParam(value = "height",required = false) Double height) {
        UserInfo user=new UserInfo();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setHeight(height);
        return service.updateUser(user);
    }


}

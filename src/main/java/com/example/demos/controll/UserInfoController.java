package com.example.demos.controll;

import com.example.demos.model.Search;
import com.example.demos.model.UserInfo;
import com.example.demos.model.UserInfoList;
import com.example.demos.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "user")
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    /**
     * 获取UserInfo
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "获取单个用户", notes = "获取单个用户的JSON数据")
    @GetMapping(value = "{id}")
    public UserInfo getUser(@PathVariable(value = "id") Integer id) {
        return service.getSingleUser(id);
    }

    /**
     * 获取UserInfo列表
     *
     * @param search
     * @return
     */
    @ApiOperation(value = "获取用户列表", notes = "获取多个个用户的JSON数据")
    @PostMapping(value = "list")
    public UserInfoList getUsers(@RequestBody Search search, BindingResult bindingResult) {
        return service.getUsers(search);
    }

    /**
     * 新增UserInfo
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "新增用户信息", notes = "返回新增用户的JSON数据")
    @PostMapping(value = "add")
    public UserInfo addUser(UserInfo user, BindingResult bindingResult) {
        return service.addUser(user);
    }

    /**
     * 修改UserInfo
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "修改用户信息", notes = "修改用户信息并返回用户的JSON数据")
    @PostMapping(value = "update")
    public UserInfo updateUser(UserInfo user, BindingResult bindingResult) {
        return service.updateUser(user);
    }


}

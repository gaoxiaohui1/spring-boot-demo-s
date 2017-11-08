package com.example.demos.controll;


import com.example.demos.model.User;
import com.example.demos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/s")
public class Hello {


    @Autowired
    private UserService us;

    @GetMapping(value = "/s")
    public User search() {
        return us.getUser();
    }

    @GetMapping(value = "/d")
    public List<User> data() {
        return us.getUsers();
    }
}

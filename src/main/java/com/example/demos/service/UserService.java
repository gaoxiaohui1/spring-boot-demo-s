package com.example.demos.service;

import com.example.demos.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public User getUser() {
        return new User("0","f",31);
    }
    public List<User> getUsers() {
        List<User> users=new ArrayList<User>();
        users.add(new User("1","f",31));
        users.add(new User("2","f",31));
        users.add(new User("3","f",31));
        users.add(new User("4","f",31));
        return users;
    }
}

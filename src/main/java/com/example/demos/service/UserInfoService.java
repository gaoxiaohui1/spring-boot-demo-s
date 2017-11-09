package com.example.demos.service;

import com.example.demos.dao.UserInfoRepository;
import com.example.demos.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;
    /**
     * 获取单个UserInfo
     * @param id
     * @return
     */
    public UserInfo getSingleUser(Integer id) {
        return userInfoRepository.findOne(id);
    }

    /**
     * 获取多个UserInfos
     * @param list
     * @return
     */
    public List<UserInfo> getUsers(ArrayList<String> list) {
        Integer key=Integer.parseInt(list.get(0));
        switch (key) {
            case 1 :
                return userInfoRepository.findByGender(list.get(1));
            case 2 :
                return userInfoRepository.findByAge(Integer.parseInt(list.get(1)));
            default:
                return userInfoRepository.findAll();
        }
    }

    /**
     * 新增UserInfo
     * @param user
     * @return
     */
    public UserInfo addUser(UserInfo user) {
        return userInfoRepository.save(user);
    }

    /**
     * 修改UserInfo
     * @param user
     * @return
     */
    public UserInfo updateUser(UserInfo user) {
        return userInfoRepository.save(user);
    }

    /**
     * 删除UserInfo
     * @param id
     * @return
     */
    public UserInfo deleteUser(Integer id) {
        UserInfo user=userInfoRepository.findOne(id);
        user.setDataStatus(9);
        return userInfoRepository.save(user);
    }
}

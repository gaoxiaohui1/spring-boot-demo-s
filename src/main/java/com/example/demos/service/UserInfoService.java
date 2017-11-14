package com.example.demos.service;

import com.example.demos.dao.UserInfoRepository;
import com.example.demos.model.Search;
import com.example.demos.model.UserInfo;
import com.example.demos.model.UserInfoList;
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
     *
     * @param id
     * @return
     */
    public UserInfo getSingleUser(Integer id) {
        UserInfo res = userInfoRepository.findOne(id);
        return res;
    }

    /**
     * 获取多个UserInfos
     *
     * @param search
     * @return
     */
    public UserInfoList getUsers(Search search) {
        UserInfoList res = new UserInfoList();
        List<UserInfo> totalUsers = new ArrayList<UserInfo>();
        Integer key = search.getKey();
        switch (key) {
            case 1:
                totalUsers = userInfoRepository.findByGender(search.getValue());
                res.setTotalCount(totalUsers.size());
                break;
            case 2:
                totalUsers = userInfoRepository.findByAge(Integer.parseInt(search.getValue()));
                res.setTotalCount(totalUsers.size());
                break;
            default:
                totalUsers = userInfoRepository.findAll();
                res.setTotalCount(totalUsers.size());
                break;
        }
        if (totalUsers.size() > 0) {
            Integer begin = (search.getPage() - 1) * search.getPageSize();
            Integer end = search.getPage() * search.getPageSize();
            if (end > totalUsers.size()) {
                end = totalUsers.size();
            }
            res.setUsers(totalUsers.subList(begin, end));
        }
        return res;
    }

    /**
     * 新增UserInfo
     *
     * @param user
     * @return
     */
    public UserInfo addUser(UserInfo user) {
        UserInfo res = userInfoRepository.save(user);
        return res;
    }

    /**
     * 修改UserInfo
     *
     * @param user
     * @return
     */
    public UserInfo updateUser(UserInfo user) {
        UserInfo res = userInfoRepository.save(user);
        return res;
    }

    /**
     * 删除UserInfo
     *
     * @param id
     * @return
     */
    public UserInfo deleteUser(Integer id) {
        UserInfo user = userInfoRepository.findOne(id);
        user.setDataStatus(9);
        UserInfo res = userInfoRepository.save(user);
        return res;
    }
}

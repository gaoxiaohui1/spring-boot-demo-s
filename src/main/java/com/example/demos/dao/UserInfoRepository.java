package com.example.demos.dao;

import com.example.demos.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

    /**
     * 根据gender获取UserInfos
     * @param gender
     * @return
     */
    public List<UserInfo> findByGender(String gender);

    /**
     * 根据age获取UserInfos
     * @param age
     * @return
     */
    public List<UserInfo> findByAge(Integer age);
}

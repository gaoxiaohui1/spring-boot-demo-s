package com.example.demos.dao;

import com.example.demos.model.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    /**
     * 根据gender获取UserInfos
     *
     * @param gender
     * @return
     */
    List<UserInfo> findByGender(String gender);

    /**
     * 根据age获取UserInfos
     *
     * @param age
     * @return
     */
    List<UserInfo> findByAge(Integer age);

    /**
     * 根据gender按照ID倒序获取分页的UserInfo
     *
     * @param gender
     * @param pageable
     * @return
     */
    Page<UserInfo> findByGenderOrderByIdDesc(String gender, Pageable pageable);

    /**
     * sql查询
     *
     * @param gender
     * @param age
     * @return
     */
    @Query("select id,name,gender,age from UserInfo where gender=?1 and age=?2")
    List<UserInfo> findThroughSql(String gender, Integer age);

    /**
     * sql修改
     *
     * @param id
     * @param name
     * @return
     */
    @Transactional
    @Modifying
    @Query("update UserInfo set name = ?1 where id = ?2")
    int updateThroughSql(String name, Integer id);
}

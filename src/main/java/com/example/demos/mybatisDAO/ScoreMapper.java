package com.example.demos.mybatisDAO;

import com.example.demos.mybatisEntity.ScoreEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper {

    @Insert("INSERT INTO score(user_id,course,score) VALUES (#{userId},#{course},#{score})")
    Integer insert(ScoreEntity scoreEntity);

    @Select("SELECT * FROM score WHERE course = '${course'")
    @Results({
            @Result(property = "userId",column = "user_id")
    })
    List<ScoreEntity> getByCourse(String course);

    @Select("SELECT * FROM score")
    @Results({
            @Result(property = "userId",column = "user_id")
    })
    List<ScoreEntity> getAll();

    @Select("SELECT * FROM score WHERE id = #{id}")
    @Results({
            @Result(property = "userId",column = "user_id")
    })
    ScoreEntity getOne(Integer id);

    @Update("UPDATE score SET user_id = #{userId},course = #{course},score = #{score} WHERE id = #{id}")
    Integer update(ScoreEntity scoreEntity);
}

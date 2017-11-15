package com.example.demos.mybatisService;

import com.example.demos.mybatisDAO.ScoreMapper;
import com.example.demos.mybatisEntity.ScoreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;

    public Integer insert(ScoreEntity scoreEntity) {
        Integer res = scoreMapper.insert(scoreEntity);
        return res;
    }

    public List<ScoreEntity> getByCourse(String course) {
        List<ScoreEntity> res = scoreMapper.getByCourse(course);
        return res;
    }

    public List<ScoreEntity> getAll() {
        List<ScoreEntity> res = scoreMapper.getAll();
        return res;
    }

    public ScoreEntity getOne(Integer id) {
        ScoreEntity res = scoreMapper.getOne(id);
        return res;
    }

    public Integer update(ScoreEntity scoreEntity) {
        Integer res = scoreMapper.update(scoreEntity);
        return res;
    }
}

package com.example.demos.controll;

import com.example.demos.mybatisEntity.ScoreEntity;
import com.example.demos.mybatisService.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping("/add")
    public Integer insert(@RequestBody ScoreEntity scoreEntity) {
        Integer res = scoreService.insert(scoreEntity);
        return res;
    }

    @GetMapping("/list1/{course}")
    public List<ScoreEntity> getByCourse1(@PathVariable(value = "course") String course) {
        List<ScoreEntity> res = scoreService.getByCourse1(course);
        return res;
    }

    @GetMapping("/list2/{course}")
    public List<ScoreEntity> getByCourse2(@PathVariable(value = "course") String course) {
        List<ScoreEntity> res = scoreService.getByCourse2(course);
        return res;
    }

    @GetMapping("/listAll")
    public List<ScoreEntity> getAll() {
        List<ScoreEntity> res = scoreService.getAll();
        return res;
    }

    @GetMapping("/detail/{id}")
    public ScoreEntity getOne(@PathVariable(value = "id") Integer id) {
        ScoreEntity res = scoreService.getOne(id);
        return res;
    }

    @PostMapping("/update")
    public Integer update(@RequestBody ScoreEntity scoreEntity) {
        Integer res = scoreService.update(scoreEntity);
        return res;
    }
}

package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.PlanWord;
import com.cn.SpringBootEnglishWordApp.Service.PlanWordService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.PlanWordMapper;

@Service
public class PlanWordServiceImpl implements PlanWordService {

    @Autowired
    private PlanWordMapper planWordMapper;
    @Override
    public List<PlanWord> getPlanWords(Integer id) {
        return planWordMapper.getPlanWords(id);
    }
    @Override
    public void postPlan(PlanWord plan) {
        planWordMapper.postPlan(plan);
    }
    @Override
    public void deletePlan(Integer id, String word, LocalDateTime createTime) {
        planWordMapper.deletePlan(id, word, createTime);
    }
}

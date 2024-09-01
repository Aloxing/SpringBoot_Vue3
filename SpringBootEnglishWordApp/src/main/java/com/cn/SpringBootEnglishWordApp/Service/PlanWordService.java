package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.PlanWord;

import java.util.List;
import java.time.LocalDateTime;

public interface PlanWordService {
    List<PlanWord> getPlanWords(Integer id);
    void postPlan(PlanWord plan);
    void deletePlan(Integer id,String word,LocalDateTime createTime);
}

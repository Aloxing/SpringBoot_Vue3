package com.cn.SpringBootEnglishWordApp.Mapper;

import com.cn.SpringBootEnglishWordApp.Pojo.PlanWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.time.LocalDateTime;

@Mapper
public interface PlanWordMapper {
    List<PlanWord> getPlanWords(Integer id);
    void postPlan(PlanWord plan);
    void deletePlan(Integer id,String word,LocalDateTime createTime);
}

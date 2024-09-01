package com.cn.SpringBootEnglishWordApp.Controller;


import com.cn.SpringBootEnglishWordApp.Pojo.PlanWord;
import com.cn.SpringBootEnglishWordApp.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Util.JwtUtil;
import com.cn.SpringBootEnglishWordApp.Service.PlanWordService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/plan")
@Slf4j
public class PlanWordController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PlanWordService planWordService;

    @GetMapping("/words")
    public Result getPlanWords(String token){
        List<User> list = jwtUtil.parseToken(token);
        //String username = list.get(0).getUsername();
        Integer ID = list.get(0).getId();
        return Result.success(planWordService.getPlanWords(ID));
    }

    @PostMapping("/insert")
    public Result postPlan(@RequestBody PlanWord plan,@RequestHeader("token") String token){
        
        List<User> list = jwtUtil.parseToken(token);
        Integer ID = list.get(0).getId();
        plan.setId(ID);
        plan.setCreateTime(LocalDateTime.now());
        planWordService.postPlan(plan);
        return Result.success();

    }

    @DeleteMapping("/delete")
    public Result deletePlan(String token,String word,LocalDateTime createTime ){
        log.info("{}",token);
        List<User> list = jwtUtil.parseToken(token);
        Integer ID = list.get(0).getId();
        planWordService.deletePlan(ID,word,createTime);
        return Result.success();
    }

}

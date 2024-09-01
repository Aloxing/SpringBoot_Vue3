package com.cn.SpringBootEnglishWordApp.Controller;


import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import com.cn.SpringBootEnglishWordApp.Pojo.User;
import com.cn.SpringBootEnglishWordApp.Util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import com.cn.SpringBootEnglishWordApp.Service.MasterWordService;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestBody;
import com.cn.SpringBootEnglishWordApp.Pojo.MasterWord;

@RestController
@RequestMapping("/api")
@Slf4j
public class MasterWordController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private MasterWordService masterWordService;

    @GetMapping("/master/words")
    public Result getMasterWords(String token){
        List<User> list = jwtUtil.parseToken(token);
        //String username = list.get(0).getUsername();
        Integer ID = list.get(0).getId();
        return Result.success(masterWordService.getMasterWords(ID));
    }

    @DeleteMapping("/master/delete")
    public Result deleteMaster(String token,String word,LocalDateTime createTime){
        List<User> list = jwtUtil.parseToken(token);
        Integer ID = list.get(0).getId();
        masterWordService.deleteMaster(ID, word, createTime);
        return Result.success();
    }

    @PostMapping("/master/insert")
    public Result insertMaster(@RequestHeader("token")String token,@RequestBody MasterWord masterWord){
        List<User> list = jwtUtil.parseToken(token);
        Integer ID = list.get(0).getId();
        masterWord.setId(ID);
        masterWord.setCreateTime(LocalDateTime.now());
        masterWordService.insertMaster(masterWord);
        return Result.success();
    }

}

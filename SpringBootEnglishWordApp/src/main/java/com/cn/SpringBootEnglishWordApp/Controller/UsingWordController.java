package com.cn.SpringBootEnglishWordApp.Controller;


import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import com.cn.SpringBootEnglishWordApp.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cn.SpringBootEnglishWordApp.Pojo.UsingWord;
import org.springframework.web.bind.annotation.RequestHeader;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Util.JwtUtil;
import com.cn.SpringBootEnglishWordApp.Service.UsingWordService;
import lombok.Delegate;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/using")
@Slf4j
public class UsingWordController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsingWordService usingWordService;

    @PostMapping("/insert")
    public Result insertUsing(@RequestBody UsingWord usingWord,@RequestHeader("token") String token){
        
        log.info("{}",token);
        usingWord.setUsingTime(LocalDateTime.now());
        List<User> list = jwtUtil.parseToken(token);
        Integer ID = list.get(0).getId();
        usingWord.setId(ID);
        usingWordService.insertUsing(usingWord);
        return Result.success();
    }

    @GetMapping("/words")
    public Result getUsing(String token){
        List<User> list = jwtUtil.parseToken(token);
        Integer ID = list.get(0).getId();
        return Result.success(usingWordService.getUsing(ID));
    }

    @DeleteMapping("/delete")
    public Result deleteUsing(String token,String word,LocalDateTime usingTime){
        List<User> list = jwtUtil.parseToken(token);
        Integer ID = list.get(0).getId();
        usingWordService.deleteUsing(ID,word,usingTime);
        return Result.success();
    }
}

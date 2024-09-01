package com.cn.SpringBootEnglishWordApp.Controller;


import com.cn.SpringBootEnglishWordApp.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Util.JwtUtil;
import com.cn.SpringBootEnglishWordApp.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Autowired 
    private JwtUtil jwtUtil;
    @Autowired
    private UserService userService;

    @GetMapping("/user/data")
    public Result getUser(String token){
        List<User> list = jwtUtil.parseToken(token);
        String username = list.get(0).getUsername();
        return Result.success(userService.getUser(username));
    }

    @GetMapping("/user/update/username")
    public Result updateUsername(String name,String token){
        List<User> list = jwtUtil.parseToken(token);
        String username = list.get(0).getUsername();
        userService.updateUsername(name,username);
        return Result.success();
    }

    @GetMapping("/user/update/password")
    public Result updatePassword(String word,String token){
        List<User> list = jwtUtil.parseToken(token);
        String username = list.get(0).getUsername();
        userService.updatePassword(word,username);
        return Result.success();
    }

    @GetMapping("/user/update/email")
    public Result updateEmail(String mail,String token){
        List<User> list = jwtUtil.parseToken(token);
        String username = list.get(0).getUsername();
        userService.updateEmail(mail,username);
        return Result.success();
    }

    @GetMapping("/user/update/content")
    public Result updateContent(String tent,String token){
        List<User> list = jwtUtil.parseToken(token);
        String username = list.get(0).getUsername();
        userService.updateContent(tent,username);
        return Result.success();
    }
}

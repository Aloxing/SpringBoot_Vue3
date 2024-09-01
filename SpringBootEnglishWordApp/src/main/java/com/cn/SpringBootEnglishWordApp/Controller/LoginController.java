package com.cn.SpringBootEnglishWordApp.Controller;


import com.cn.SpringBootEnglishWordApp.Pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.LoginService;
import com.cn.SpringBootEnglishWordApp.Util.JwtUtil;
import com.cn.SpringBootEnglishWordApp.Service.UserService;

@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @GetMapping("/aloxing/login")
    public Result postLogin(String username,String password){
        
        List<User> user = loginService.postLogin(username,password);
        if(user.isEmpty())return Result.error("登录失败!");
        String token = jwtUtil.getToken(username,password,userService.getId(username));
       return Result.success(token); 
    }

    @GetMapping("/aloxing/login/token")
    public Result tokenLogin(String token){
        if(!jwtUtil.trueToken(token))return Result.error("无效token!");
        return Result.success("验证成功!");
    }

    @GetMapping("/aloxing/user/data")
    public Result getUserData(String token){
        return Result.success(jwtUtil.parseToken(token));
    }

}

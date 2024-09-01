package com.cn.SpringBootEnglishWordApp.Controller;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import com.cn.SpringBootEnglishWordApp.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import java.sql.ResultSet;

@RestController
@RequestMapping
@Slf4j
public class TestController {

    @Autowired
    private  JwtUtil jwtUtil;

    @GetMapping("/hello")
    public String getHello (){
        return "Hello World!";
    }

    @GetMapping("/token")
    public String getToken(String username,String password){
        return jwtUtil.getToken(username,password,null);
    }

    @GetMapping("/token/result")
    public Result getTokenResult(String token){
        return Result.success(jwtUtil.trueToken(token));
    }
    
}

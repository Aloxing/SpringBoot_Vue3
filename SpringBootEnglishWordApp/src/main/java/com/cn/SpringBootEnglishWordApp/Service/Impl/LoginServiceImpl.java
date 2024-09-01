package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Mapper.LoginMapper;
import com.cn.SpringBootEnglishWordApp.Pojo.User;
import com.cn.SpringBootEnglishWordApp.Service.LoginService;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public List<User> postLogin(String username, String password) {
        return loginMapper.postLogin(username,password);
    }
}

package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.User;

import java.util.List;

public interface LoginService {
    List<User> postLogin(String username,String password);
}

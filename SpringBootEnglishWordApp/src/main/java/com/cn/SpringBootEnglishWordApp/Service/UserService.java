package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.User;

import java.util.List;

public interface UserService {
    List<User> getUser(String username);
    void updateUsername(String name,String username);
    void updatePassword(String word,String username);
    void updateEmail(String mail,String username);
    void updateContent(String tent,String username);
    Integer getId(String username);
}

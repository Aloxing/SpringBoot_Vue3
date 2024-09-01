package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.User;
import com.cn.SpringBootEnglishWordApp.Service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser(String username) {
        return userMapper.getUser(username);
    }

    @Override
    public void updateUsername(String name, String username) {
        userMapper.updateUsername(name,username);
    }

    @Override
    public void updatePassword(String word, String username) {
        userMapper.updatePassword(word, username);
    }

    @Override
    public void updateEmail(String mail, String username) {
        userMapper.updateEmail(mail, username);
    }

    @Override
    public void updateContent(String tent, String username) {
        userMapper.updateContent(tent, username);
    }

    @Override
    public Integer getId(String username) {
        return userMapper.getId(username);
    }
}

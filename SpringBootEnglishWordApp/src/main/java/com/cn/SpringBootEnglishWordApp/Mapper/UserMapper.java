package com.cn.SpringBootEnglishWordApp.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> getUser(String username);
    void updateUsername(String name,String username);
    void updatePassword(String word,String username);
    void updateEmail(String mail,String username);
    void updateContent(String tent,String username);
    Integer getId(String username);
}

package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.UsingWord;

import java.time.LocalDateTime;
import java.util.List;

public interface UsingWordService {
    void insertUsing(UsingWord usingWord);
    List<UsingWord> getUsing(Integer id);
    void deleteUsing(Integer id,String word,LocalDateTime usingTime);

}

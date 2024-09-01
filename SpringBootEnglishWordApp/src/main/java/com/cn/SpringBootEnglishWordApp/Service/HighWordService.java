package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.HighWord;

import java.util.List;

public interface HighWordService {
    List<HighWord> getHighWords(Integer pageSize,Integer offset);
    Integer getHighWordNums();
    List<HighWord> selectHighWords(String word);
    List<HighWord> selectAnyHighWords(String word);
}

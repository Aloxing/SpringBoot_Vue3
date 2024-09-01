package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.SatWord;

import java.util.List;

public interface SatWordService {
    List<SatWord> getSatWords(Integer pageSize,Integer offset);
    Integer getSatWordNums();
    List<SatWord> selectSatWords(String word);
    List<SatWord> selectAnySatWords(String word);
}

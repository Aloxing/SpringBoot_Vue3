package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.ToeflWord;

import java.util.List;

public interface ToeflWordService {
    List<ToeflWord> getToeflWords(Integer pageSize,Integer offset);
    Integer getToeflWordNums();
    List<ToeflWord> selectToeflWords(String word);
    List<ToeflWord> selectAnyToeflWords(String word);
}

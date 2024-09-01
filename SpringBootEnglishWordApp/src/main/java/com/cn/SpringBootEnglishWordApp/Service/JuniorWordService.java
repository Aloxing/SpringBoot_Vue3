package com.cn.SpringBootEnglishWordApp.Service;
import com.cn.SpringBootEnglishWordApp.Pojo.JuniorWord;

import java.util.List;

public interface JuniorWordService {
    List<JuniorWord> getJuniorWords(Integer pageSize,Integer offset);
    Integer getJuniorWordNums();
    List<JuniorWord> selectJuniorWords(String word);
    List<JuniorWord> selectAnyJuniorWords(String word);
}

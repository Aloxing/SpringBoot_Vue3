package com.cn.SpringBootEnglishWordApp.Service;
import com.cn.SpringBootEnglishWordApp.Pojo.EnglishWord;

import java.util.List;

public interface EnglishWordService {
    List<EnglishWord> getEnglishWords(Integer pageSize,Integer offset);
    Integer getEnglishWordNums();
    List<EnglishWord> selectEnglishWords(String word);
}

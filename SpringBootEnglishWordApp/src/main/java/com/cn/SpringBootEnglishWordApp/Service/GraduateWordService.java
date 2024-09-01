package com.cn.SpringBootEnglishWordApp.Service;
import com.cn.SpringBootEnglishWordApp.Pojo.GraduateWord;

import java.util.List;
public interface GraduateWordService {
    List<GraduateWord> getGraduateWords(Integer pageSize,Integer offset);
    Integer getGraduateWordNums();
    List<GraduateWord> selectGraduateWords(String word);
    List<GraduateWord> selectAnyGraduateWords(String word);
}

package com.cn.SpringBootEnglishWordApp.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.GraduateWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GraduateWordMapper {
    List<GraduateWord> getGraduateWords(Integer pageSize,Integer offset);
    Integer getGraduateWordNums();
    List<GraduateWord> selectGraduateWords(String word);
    List<GraduateWord> selectAnyGraduateWords(String word);
}

package com.cn.SpringBootEnglishWordApp.Mapper;
import org.apache.ibatis.annotations.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.JuniorWord;

import java.util.List;

@Mapper
public interface JuniorWordMapper {
    List<JuniorWord> getJuniorWords(Integer pageSize,Integer offset);
    Integer getJuniorWordNums();
    List<JuniorWord> selectJuniorWords(String word);
    List<JuniorWord> selectAnyJuniorWords(String word);
}


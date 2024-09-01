package com.cn.SpringBootEnglishWordApp.Mapper;
import org.apache.ibatis.annotations.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.HighWord;

import java.util.List;

@Mapper
public interface HighWordMapper {
    List<HighWord> getHighWords(Integer pageSize,Integer offset);
    Integer getHighWordNums();
    List<HighWord> selectHighWords(String word);
    List<HighWord> selectAnyHighWords(String word);
}


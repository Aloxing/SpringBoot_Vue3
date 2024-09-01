package com.cn.SpringBootEnglishWordApp.Mapper;
import org.apache.ibatis.annotations.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.EnglishWord;

import java.util.List;

@Mapper
public interface EnglishWordMapper {
    List<EnglishWord> getEnglishWords(Integer pageSize,Integer offset);
    Integer getEnglishWordNums();
    List<EnglishWord> selectEnglishWords(String word);
}

package com.cn.SpringBootEnglishWordApp.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.ToeflWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ToeflWordMapper {
    List<ToeflWord> getToeflWords(Integer pageSize,Integer offset);
    Integer getToeflWordNums();
    List<ToeflWord> selectToeflWords(String word);
    List<ToeflWord> selectAnyToeflWords(String word);
}

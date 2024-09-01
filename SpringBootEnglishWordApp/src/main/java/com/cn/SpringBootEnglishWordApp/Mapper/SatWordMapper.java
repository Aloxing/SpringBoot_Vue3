package com.cn.SpringBootEnglishWordApp.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.SatWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SatWordMapper {
    List<SatWord> getSatWords(Integer pageSize,Integer offset);
    Integer getSatWordNums();
    List<SatWord> selectSatWords(String word);
    List<SatWord> selectAnySatWords(String word);
}

package com.cn.SpringBootEnglishWordApp.Mapper;
import org.apache.ibatis.annotations.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.UsingWord;

import java.util.List;
import java.time.LocalDateTime;

@Mapper
public interface UsingWordMapper {
    void insertUsing(UsingWord uword);
    List<UsingWord> getUsing(Integer id);
    void deleteUsing(Integer id,String word,LocalDateTime usingTime);
}

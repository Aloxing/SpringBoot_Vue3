package com.cn.SpringBootEnglishWordApp.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.MasterWord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.time.LocalDateTime;

@Mapper
public interface MasterWordMapper {
    List<MasterWord> getMasterWords(Integer id);
    void deleteMaster(Integer id,String word,LocalDateTime createTime);
    void insertMaster(MasterWord masterWord);
}

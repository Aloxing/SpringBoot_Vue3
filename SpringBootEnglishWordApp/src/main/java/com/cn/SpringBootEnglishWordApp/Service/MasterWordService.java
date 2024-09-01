package com.cn.SpringBootEnglishWordApp.Service;

import com.cn.SpringBootEnglishWordApp.Pojo.MasterWord;

import java.time.LocalDateTime;
import java.util.List;

public interface MasterWordService {
    List<MasterWord> getMasterWords(Integer id);
    void deleteMaster(Integer id,String word,LocalDateTime createTime);
    void insertMaster(MasterWord masterWord);
}

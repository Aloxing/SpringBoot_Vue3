package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.MasterWord;
import com.cn.SpringBootEnglishWordApp.Service.MasterWordService;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.MasterWordMapper;

@Service
public class MasterWordServiceImpl implements MasterWordService {

    @Autowired
    private MasterWordMapper masterWordMapper;

    @Override
    public List<MasterWord> getMasterWords(Integer id) {
        return masterWordMapper.getMasterWords(id);
    }

    @Override
    public void deleteMaster(Integer id, String word, LocalDateTime createTime) {
        masterWordMapper.deleteMaster(id, word, createTime);
    }


    @Override
    public void insertMaster(MasterWord masterWord) {
        masterWordMapper.insertMaster(masterWord);
    }
}

package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.HighWord;
import org.springframework.stereotype.Service;
import com.cn.SpringBootEnglishWordApp.Service.HighWordService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.HighWordMapper;

@Service
public class HighWordServiceImpl implements HighWordService {

    @Autowired
    private HighWordMapper highWordMapper;

    @Override
    public List<HighWord> getHighWords(Integer pageSize, Integer offset) {
        return highWordMapper.getHighWords(pageSize, offset);
    }

    @Override
    public Integer getHighWordNums() {
        return highWordMapper.getHighWordNums();
    }

    @Override
    public List<HighWord> selectHighWords(String word) {
        return highWordMapper.selectHighWords(word);
    }

    @Override
    public List<HighWord> selectAnyHighWords(String word) {
        return highWordMapper.selectAnyHighWords(word);
    }
}

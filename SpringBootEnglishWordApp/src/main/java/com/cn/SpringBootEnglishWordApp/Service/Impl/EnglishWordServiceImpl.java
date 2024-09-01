package com.cn.SpringBootEnglishWordApp.Service.Impl;
import org.springframework.stereotype.Service;
import com.cn.SpringBootEnglishWordApp.Service.EnglishWordService;
import com.cn.SpringBootEnglishWordApp.Pojo.EnglishWord;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.EnglishWordMapper;

@Service
public class EnglishWordServiceImpl implements EnglishWordService {
    
    @Autowired
    private EnglishWordMapper englishWordMapper;

    public List<EnglishWord> getEnglishWords(Integer pageSize,Integer offset){
        return englishWordMapper.getEnglishWords(pageSize,offset);
    }

    @Override
    public Integer getEnglishWordNums() {
        return englishWordMapper.getEnglishWordNums();
    }

    @Override
    public List<EnglishWord> selectEnglishWords(String word) {
        return englishWordMapper.selectEnglishWords(word);
    }
}

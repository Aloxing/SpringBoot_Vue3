package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.JuniorWord;
import org.springframework.stereotype.Service;
import com.cn.SpringBootEnglishWordApp.Service.JuniorWordService;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.JuniorWordMapper;

import java.util.List;

@Service
public class JuniorWordServiceImpl implements JuniorWordService {

    @Autowired
    private JuniorWordMapper juniorWordMapper;
    @Override
    public List<JuniorWord> getJuniorWords(Integer pageSize,Integer offset) {
        return juniorWordMapper.getJuniorWords(pageSize,offset);
    }
    @Override
    public Integer getJuniorWordNums() {
        return juniorWordMapper.getJuniorWordNums();
    }

    @Override
    public List<JuniorWord> selectJuniorWords(String word) {
        return juniorWordMapper.selectJuniorWords(word);
    }

    @Override
    public List<JuniorWord> selectAnyJuniorWords(String word) {
        return juniorWordMapper.selectAnyJuniorWords(word);
    }
}

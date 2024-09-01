package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.GraduateWord;
import com.cn.SpringBootEnglishWordApp.Service.GraduateWordService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.GraduateWordMapper;
import org.springframework.stereotype.Service;

@Service
public class GraduateWordServiceImpl implements GraduateWordService {

    @Autowired
    private GraduateWordMapper graduateWordMapper;

    @Override
    public List<GraduateWord> getGraduateWords(Integer pageSize, Integer offset) {
        return graduateWordMapper.getGraduateWords(pageSize, offset);
    }

    @Override
    public Integer getGraduateWordNums() {
        return graduateWordMapper.getGraduateWordNums();
    }

    @Override
    public List<GraduateWord> selectGraduateWords(String word) {
        return graduateWordMapper.selectGraduateWords(word);
    }

    @Override
    public List<GraduateWord> selectAnyGraduateWords(String word) {
        return graduateWordMapper.selectAnyGraduateWords(word);
    }
}

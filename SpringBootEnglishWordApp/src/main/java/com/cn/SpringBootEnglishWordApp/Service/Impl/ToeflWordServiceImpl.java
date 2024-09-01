package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.ToeflWord;
import com.cn.SpringBootEnglishWordApp.Service.ToeflWordService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.ToeflWordMapper;
import org.springframework.stereotype.Service;

@Service
public class ToeflWordServiceImpl implements ToeflWordService {

    @Autowired
    private ToeflWordMapper toeflWordMapper;

    @Override
    public List<ToeflWord> getToeflWords(Integer pageSize, Integer offset) {
        return toeflWordMapper.getToeflWords(pageSize, offset);
    }

    @Override
    public Integer getToeflWordNums() {
        return toeflWordMapper.getToeflWordNums();
    }

    @Override
    public List<ToeflWord> selectToeflWords(String word) {
        return toeflWordMapper.selectToeflWords(word);
    }

    @Override
    public List<ToeflWord> selectAnyToeflWords(String word) {
        return toeflWordMapper.selectAnyToeflWords(word);
    }
}

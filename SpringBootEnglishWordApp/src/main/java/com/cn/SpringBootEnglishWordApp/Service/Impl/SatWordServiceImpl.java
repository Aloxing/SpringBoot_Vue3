package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.SatWord;
import com.cn.SpringBootEnglishWordApp.Service.SatWordService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.SatWordMapper;
import org.springframework.stereotype.Service;

@Service
public class SatWordServiceImpl implements SatWordService {

    @Autowired
    private SatWordMapper satWordMapper;

    @Override
    public List<SatWord> getSatWords(Integer pageSize, Integer offset) {
        return satWordMapper.getSatWords(pageSize, offset);
    }

    @Override
    public Integer getSatWordNums() {
        return satWordMapper.getSatWordNums();
    }

    @Override
    public List<SatWord> selectSatWords(String word) {
        return satWordMapper.selectSatWords(word);
    }

    @Override
    public List<SatWord> selectAnySatWords(String word) {
        return satWordMapper.selectAnySatWords(word);
    }
}

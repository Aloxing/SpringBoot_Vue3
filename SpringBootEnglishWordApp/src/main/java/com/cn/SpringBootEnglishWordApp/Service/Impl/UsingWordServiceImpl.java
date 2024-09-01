package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.UsingWord;
import com.cn.SpringBootEnglishWordApp.Service.UsingWordService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.UsingWordMapper;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsingWordServiceImpl implements UsingWordService {

    @Autowired
    private UsingWordMapper usingWordMapper;
    @Override
    public void insertUsing(UsingWord usingWord) {
        usingWordMapper.insertUsing(usingWord);
        
    }

    @Override
    public List<UsingWord> getUsing(Integer id) {
        return usingWordMapper.getUsing(id);
    }

    @Override
    public void deleteUsing(Integer id, String word, LocalDateTime usingTime) {
        usingWordMapper.deleteUsing(id, word, usingTime);
    }
}

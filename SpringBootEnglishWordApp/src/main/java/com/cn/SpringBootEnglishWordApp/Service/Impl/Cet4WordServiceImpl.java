package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.Cet4Word;
import com.cn.SpringBootEnglishWordApp.Service.Cet4WordService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.Cet4WordMapper;
import org.springframework.stereotype.Service;

@Service
public class Cet4WordServiceImpl implements Cet4WordService {

    @Autowired
    private Cet4WordMapper cet4WordMapper;

    @Override
    public List<Cet4Word> getCet4Words(Integer pageSize, Integer offset) {
        return cet4WordMapper.getCet4Words(pageSize, offset);
    }

    @Override
    public Integer getCet4WordNums() {
        return cet4WordMapper.getCet4WordNums();
    }

    @Override
    public List<Cet4Word> selectCet4Words(String word) {
        return cet4WordMapper.selectCet4Words(word);
    }

    @Override
    public List<Cet4Word> selectAnyCet4Words(String word) {
        return cet4WordMapper.selectAnyCet4Words(word);
    }
}

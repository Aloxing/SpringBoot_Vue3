package com.cn.SpringBootEnglishWordApp.Service.Impl;
import com.cn.SpringBootEnglishWordApp.Pojo.Cet6Word;
import com.cn.SpringBootEnglishWordApp.Service.Cet6WordService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Mapper.Cet6WordMapper;
import org.springframework.stereotype.Service;

@Service
public class Cet6WordServiceImpl implements Cet6WordService {

    @Autowired
    private Cet6WordMapper cet6WordMapper;

    @Override
    public List<Cet6Word> getCet6Words(Integer pageSize, Integer offset) {
        return cet6WordMapper.getCet6Words(pageSize, offset);
    }

    @Override
    public Integer getCet6WordNums() {
        return cet6WordMapper.getCet6WordNums();
    }

    @Override
    public List<Cet6Word> selectCet6Words(String word) {
        return cet6WordMapper.selectCet6Words(word);
    }

    @Override
    public List<Cet6Word> selectAnyCet6Words(String word) {
        return cet6WordMapper.selectAnyCet6Words(word);
    }
}

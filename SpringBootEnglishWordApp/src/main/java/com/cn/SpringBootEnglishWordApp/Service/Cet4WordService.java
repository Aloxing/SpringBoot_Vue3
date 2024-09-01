package com.cn.SpringBootEnglishWordApp.Service;
import com.cn.SpringBootEnglishWordApp.Pojo.Cet4Word;

import java.util.List;
public interface Cet4WordService {
    List<Cet4Word> getCet4Words(Integer pageSize,Integer offset);
    Integer getCet4WordNums();
    List<Cet4Word> selectCet4Words(String word);
    List<Cet4Word> selectAnyCet4Words(String word);
}

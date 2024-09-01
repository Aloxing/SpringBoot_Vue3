package com.cn.SpringBootEnglishWordApp.Service;
import com.cn.SpringBootEnglishWordApp.Pojo.Cet6Word;

import java.util.List;
public interface Cet6WordService {
    List<Cet6Word> getCet6Words(Integer pageSize,Integer offset);
    Integer getCet6WordNums();
    List<Cet6Word> selectCet6Words(String word);
    List<Cet6Word> selectAnyCet6Words(String word);
}

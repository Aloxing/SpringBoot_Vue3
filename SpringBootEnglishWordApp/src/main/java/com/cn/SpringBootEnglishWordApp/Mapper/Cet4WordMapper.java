package com.cn.SpringBootEnglishWordApp.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.Cet4Word;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface Cet4WordMapper {
    List<Cet4Word> getCet4Words(Integer pageSize,Integer offset);
    Integer getCet4WordNums();
    List<Cet4Word> selectCet4Words(String word);
    List<Cet4Word> selectAnyCet4Words(String word);
}

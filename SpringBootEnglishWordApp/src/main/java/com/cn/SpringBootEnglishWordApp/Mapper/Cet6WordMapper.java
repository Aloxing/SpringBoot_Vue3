package com.cn.SpringBootEnglishWordApp.Mapper;
import com.cn.SpringBootEnglishWordApp.Pojo.Cet6Word;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface Cet6WordMapper {
    List<Cet6Word> getCet6Words(Integer pageSize,Integer offset);
    Integer getCet6WordNums();
    List<Cet6Word> selectCet6Words(String word);
    List<Cet6Word> selectAnyCet6Words(String word);
}

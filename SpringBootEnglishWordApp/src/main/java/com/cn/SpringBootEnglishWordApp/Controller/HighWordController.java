package com.cn.SpringBootEnglishWordApp.Controller;

import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.HighWordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class HighWordController {

    @Autowired
    private HighWordService highWordService;

    @GetMapping("/high/words")
    public Result getHighWords(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(highWordService.getHighWords(pageSize,offset));
    }

    @GetMapping("/high/words/sum")
    public Result getHighWordNums(){
        return Result.success(highWordService.getHighWordNums());
    }

    @GetMapping("/high/words/select")
    public Result selectHighWords(String word){
        return Result.success(highWordService.selectHighWords(word));
    }

    @GetMapping("/high/words/selectany")
    public Result selectAnyHighWords(String word){
        return Result.success(highWordService.selectAnyHighWords(word));
    }
}

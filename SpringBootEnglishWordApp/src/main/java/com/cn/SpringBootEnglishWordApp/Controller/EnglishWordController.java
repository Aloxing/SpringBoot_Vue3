package com.cn.SpringBootEnglishWordApp.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.EnglishWordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class EnglishWordController {

    @Autowired
    private EnglishWordService englishWordService;

    @GetMapping("/english/words")
    public Result getEngineWords(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(englishWordService.getEnglishWords(pageSize,offset));
    }
    @GetMapping("/english/words/sum")
    public Result getEngineWordNums(){
        return Result.success(englishWordService.getEnglishWordNums());
    }
    @GetMapping("/english/words/select")
    public Result getEngineWordNums(String word){
        return Result.success(englishWordService.selectEnglishWords(word));
    }
}

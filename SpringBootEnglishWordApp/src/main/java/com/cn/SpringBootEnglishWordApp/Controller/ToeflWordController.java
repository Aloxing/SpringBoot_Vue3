package com.cn.SpringBootEnglishWordApp.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.ToeflWordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class ToeflWordController {
    @Autowired
    private ToeflWordService toeflWordService;

    @GetMapping("/toefl/words")
    public Result getToeflWords(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(toeflWordService.getToeflWords(pageSize,offset));
    }

    @GetMapping("/toefl/words/sum")
    public Result getToeflWordNums(){
        return Result.success(toeflWordService.getToeflWordNums());
    }

    @GetMapping("/toefl/words/select")
    public Result selectToeflWords(String word){
        return Result.success(toeflWordService.selectToeflWords(word));
    }

    @GetMapping("/toefl/words/selectany")
    public Result selectAnyToeflWords(String word){
        return Result.success(toeflWordService.selectAnyToeflWords(word));
    }
}

package com.cn.SpringBootEnglishWordApp.Controller;

import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.GraduateWordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class GraduateWordController {

    @Autowired
    private GraduateWordService graduateWordService;

    @GetMapping("/graduate/words")
    public Result getGraduateWords(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(graduateWordService.getGraduateWords(pageSize,offset));
    }

    @GetMapping("/graduate/words/sum")
    public Result getGraduateWordNums(){
        return Result.success(graduateWordService.getGraduateWordNums());
    }

    @GetMapping("/graduate/words/select")
    public Result selectGraduateWords(String word){
        return Result.success(graduateWordService.selectGraduateWords(word));
    }

    @GetMapping("/graduate/words/selectany")
    public Result selectAnyGraduateWords(String word){
        return Result.success(graduateWordService.selectAnyGraduateWords(word));
    }
}

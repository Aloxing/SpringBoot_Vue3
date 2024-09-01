package com.cn.SpringBootEnglishWordApp.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.JuniorWordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class JuniorWordController {

    @Autowired
    private JuniorWordService juniorWordService;

    @GetMapping("/junior/words")
    public Result getJuniorWords(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(juniorWordService.getJuniorWords(pageSize,offset));
    }

    @GetMapping("/junior/words/sum")
    public Result getJuniorWordNums(){
        return Result.success(juniorWordService.getJuniorWordNums());
    }

    @GetMapping("/junior/words/select")
    public Result selectJuniorWords(String word){
        return Result.success(juniorWordService.selectJuniorWords(word));
    }

    @GetMapping("/junior/words/selectany")
    public Result selectAnyJuniorWords(String word){
        return Result.success(juniorWordService.selectAnyJuniorWords(word));
    }

}

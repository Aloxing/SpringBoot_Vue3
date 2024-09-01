package com.cn.SpringBootEnglishWordApp.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.SatWordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class SatWordController {
    @Autowired
    private SatWordService satWordService;

    @GetMapping("/sat/words")
    public Result getSatWords(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(satWordService.getSatWords(pageSize,offset));
    }

    @GetMapping("/sat/words/sum")
    public Result getSatWordNums(){
        return Result.success(satWordService.getSatWordNums());
    }

    @GetMapping("/sat/words/select")
    public Result selectSatWords(String word){
        return Result.success(satWordService.selectSatWords(word));
    }

    @GetMapping("/sat/words/selectany")
    public Result selectAnySatWords(String word){
        return Result.success(satWordService.selectAnySatWords(word));
    }
}

package com.cn.SpringBootEnglishWordApp.Controller;

import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.Cet6WordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class Cet6WordController {

    @Autowired
    private Cet6WordService cet6WordService;

    @GetMapping("/cet6/words")
    public Result getCet6Words(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(cet6WordService.getCet6Words(pageSize,offset));
    }

    @GetMapping("/cet6/words/sum")
    public Result getCet6WordNums(){
        return Result.success(cet6WordService.getCet6WordNums());
    }

    @GetMapping("/cet6/words/select")
    public Result selectCet6Words(String word){
        return Result.success(cet6WordService.selectCet6Words(word));
    }

    @GetMapping("cet6/words/selectany")
    public Result selectAnyCet6Words(String word){
        return Result.success(cet6WordService.selectAnyCet6Words(word));
    }
}

package com.cn.SpringBootEnglishWordApp.Controller;

import com.cn.SpringBootEnglishWordApp.Pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.cn.SpringBootEnglishWordApp.Service.Cet4WordService;

@RestController
@RequestMapping("/api")
@Slf4j
public class Cet4WordController {
    @Autowired 
    private Cet4WordService cet4WordService;

    @GetMapping("/cet4/words")
    public Result getCet4Words(Integer currentPage,Integer pageSize){
        Integer offset = (currentPage-1)*pageSize;
        return Result.success(cet4WordService.getCet4Words(pageSize,offset));
    }

    @GetMapping("/cet4/words/sum")
    public Result getCet4WordNums(){
        return Result.success(cet4WordService.getCet4WordNums());
    }

    @GetMapping("/cet4/words/select")
    public Result selectCet4Words(String word){
        return Result.success(cet4WordService.selectCet4Words(word));
    }

    @GetMapping("cet4/words/selectany")
    public Result selectAnyCet4Words(String word){
        return Result.success(cet4WordService.selectAnyCet4Words(word));
    }
}

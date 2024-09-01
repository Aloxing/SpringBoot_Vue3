package com.cn.SpringBootEnglishWordApp.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanWord {
    private Integer id;
    private String word;
    private String translate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

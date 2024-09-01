package com.cn.SpringBootEnglishWordApp.Pojo;
import org.springframework.context.annotation.Bean;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnglishWord {
    private String word;
    private String translation;
}

package com.cn.SpringBootEnglishWordApp.Config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加映射路径  
        registry.addMapping("/**") // 允许所有路径
            .allowedOrigins("http://localhost:8081") // 只允许来自example.com的请求
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的方法
            .allowedHeaders("*") // 允许任何头信息
            .allowCredentials(true) // 允许凭证共享（如Cookies、HTTP认证信息）
            .maxAge(168000); // 预检请求的有效期
    }
}

package com.cn.SpringBootEnglishWordApp.Interceptor;
import com.cn.SpringBootEnglishWordApp.Util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpSession;

import java.util.Objects;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    JwtUtil jwtUtil;
    @Value("${token.refreshTime}")
    private Long refreshTime;
    @Value("${token.expiresTime}")
    private Long expiresTime;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        log.info("=======进入拦截器========");
        String ip = request.getRemoteAddr();
        HttpSession session = request.getSession();
        Integer count = (Integer)session.getAttribute("count");
        count = Objects.isNull(count)?1:++count;
        System.out.println("ip:"+ip+" count:"+count);
        session.setAttribute("count",count);

        return true;
    }

}

package com.myproject.interceptor;

import com.myproject.utils.CurrentHolder;
import com.myproject.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Token攔截器類
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    // 在Controller請求處理前進行攔截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, @NonNull Object handler) throws Exception {
        // 獲取請求Header中的token
        String token = request.getHeader("token");

        // 檢查token是否存在
        if(token == null || token.isEmpty()){
            log.warn("缺少token，拒絕請求");
            // 返回狀態碼401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 驗證token是否有效
        try{
            // 驗證token
            Claims claims = JwtUtils.parseJwt(token);
            Integer id = (Integer)claims.get("id");
            CurrentHolder.setCurrentId(id);
        }
        catch(Exception e){
            log.warn("token驗證失敗，拒絕請求");
            // 返回狀態碼401
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // token驗證成功，放行
        log.info("token驗證成功，放行");
        return true;
    }
    // 在Controller返回回應後進行攔截
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        CurrentHolder.removeCurrentId();
    }
}

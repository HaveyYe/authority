package com.havey.service;

import com.alibaba.fastjson.JSON;
import com.havey.model.ResponseBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
*@描述 匿名用户无法访问权限资源时的异常
*@参数 
*@返回 
*@作者 yehw
*@日期 2020/3/19
*@时间 14:43
*/
@Component
public class CustomizeAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseBean bean=ResponseBean.error("用户未登录");
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //fashjson
        httpServletResponse.getWriter().write(JSON.toJSONString(bean));
    }
}

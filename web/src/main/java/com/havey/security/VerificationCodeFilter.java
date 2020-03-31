package com.havey.security;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.havey.model.ResponseBean;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class VerificationCodeFilter extends GenericFilterBean {

    private String processUrl = "/doLogin";//默认登录路径

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        if("POST".equalsIgnoreCase(req.getMethod()) && processUrl.equalsIgnoreCase(req.getServletPath())) {
            // 验证码验证
            String requestCaptcha = request.getParameter("code");//前端传来的codde
            String genCaptcha = (String)req.getSession().getAttribute("ver_code");//后端生成的code
            if(StringUtils.isEmpty(requestCaptcha)||!requestCaptcha.toLowerCase().equals(genCaptcha.toLowerCase())){
                resp.setContentType("application/json;charset=utf-8");
                PrintWriter writer=resp.getWriter();
                writer.write(new ObjectMapper().writeValueAsString(ResponseBean.error("验证码错误")));
                writer.flush();
                writer.close();
            }else{
                chain.doFilter(request, response);
            }
        }else{
            chain.doFilter(request, response);
        }

    }
}

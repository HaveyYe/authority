package com.havey.service;

import com.alibaba.fastjson.JSON;
import com.havey.model.ResponseBean;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
*@描述 登录失败的操作
*@参数 
*@返回 
*@作者 yehw
*@日期 2020/3/19
*@时间 15:08
*/
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResponseBean bean=null;
        if(e instanceof AccountExpiredException){
            //账号过期的处理
            bean =ResponseBean.error("账号过期");
        }else if(e instanceof BadCredentialsException){
            bean =ResponseBean.error("密码错误");
        }else if(e instanceof CredentialsExpiredException){
            bean =ResponseBean.error("密码过期");
        }else if(e instanceof DisabledException){
            bean =ResponseBean.error("账号不可用");
        }else if(e instanceof LockedException){
            bean =ResponseBean.error("账号锁定");
        }else if (e instanceof InternalAuthenticationServiceException){
            bean=ResponseBean.error("用户不存在");
        }else{
            bean=ResponseBean.error("登录失败");
        }
        //处理编码方式，防止中文乱码的情况
        httpServletResponse.setContentType("text/json;charset=utf-8");
        //塞到HttpServletResponse中返回给前台
        httpServletResponse.getWriter().write(JSON.toJSONString(bean));
    }
}

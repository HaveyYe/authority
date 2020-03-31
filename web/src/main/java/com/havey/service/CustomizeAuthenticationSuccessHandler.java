package com.havey.service;

import com.alibaba.fastjson.JSON;
import com.havey.model.ResponseBean;
import com.havey.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
*@描述 登录成功调用的方法
*@参数 
*@返回 
*@作者 yehw
*@日期 2020/3/19
*@时间 14:53
*/
@Component
public class CustomizeAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    SysUserService sysUserService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User userDetails=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //登录用户操作修改登录时间
        SysUser sysUser = sysUserService.selectByName(userDetails.getUsername());
        sysUser.setLastLoginTime(new Date());
        sysUser.setUpdateTime(new Date());
        sysUser.setUpdateUser(sysUser.getId());
        sysUserService.update(sysUser);
        //登录成功返回消息操作，
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out=httpServletResponse.getWriter();
        ResponseBean bean=ResponseBean.ok("登录成功",sysUser);
        out.write(JSON.toJSONString(bean));
        out.flush();
        out.close();
    }
}

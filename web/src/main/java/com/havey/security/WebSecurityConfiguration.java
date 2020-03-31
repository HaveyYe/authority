package com.havey.security;

import com.havey.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Autowired
    CustomizeAuthenticationEntryPoint customizeAuthenticationEntryPoint;
    @Autowired
    CustomizeAuthenticationSuccessHandler customizeAuthenticationSuccessHandler;
    @Autowired
    CustomizeAuthenticationFailureHandler customizeAuthenticationFailureHandler;
    @Autowired
    CustomizeLogoutSuccessHandler customizeLogoutSuccessHandler;

    @Autowired
    VerificationCodeFilter verificationCodeFilter;//验证码
    /**
     * @描述 要求必须密码加密
     * @参数 []
     * @返回 org.springframework.security.crypto.password.PasswordEncoder
     * @作者 yehw
     * @日期 2020/3/19
     * @时间 14:35
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDeatilsServiceImp();
    }

    /**
     * @描述 这里是具体的相关配置
     * @参数 [http]
     * @返回 void
     * @作者 yehw
     * @日期 2020/3/19
     * @时间 14:37
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(verificationCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests()//所有请求
                .anyRequest().authenticated()
                .and().formLogin()//自定义表单登录
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginProcessingUrl("/doLogin")
                .successHandler(customizeAuthenticationSuccessHandler)
                .failureHandler(customizeAuthenticationFailureHandler)
                .and().logout()
                .permitAll()//允许所有用户登出
                .logoutSuccessHandler(customizeLogoutSuccessHandler)
                .deleteCookies("JESSIONID")
                .permitAll()
                .and().csrf().disable().exceptionHandling()
                .authenticationEntryPoint(customizeAuthenticationEntryPoint);//匿名用户不得返回访问。

    }

    /**
     * @描述 这里就是用来去欸的那个，认证信息是通过数据库来的
     * @参数 [auth]
     * @返回 void
     * @作者 yehw
     * @日期 2020/3/19
     * @时间 14:36
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/login").antMatchers("/verificode");
    }
}

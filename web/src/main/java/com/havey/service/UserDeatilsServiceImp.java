package com.havey.service;

import com.alibaba.druid.util.StringUtils;
import com.havey.mapper.dao.SysPermissionDao;
import com.havey.model.entity.SysPermission;
import com.havey.model.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
*@描述 这里是通过数据库查询权限。主要实现UserDetailsService。也可以直接让SysUserService实现。
*@参数
*@返回
*@作者 yehw
*@日期 2020/3/19
*@时间 14:14
*/
@Service
public class UserDeatilsServiceImp  implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysPermissionService sysPermissionService;
    /**
    *@描述 重写唯一的LadUserByUserName
    *@参数 [s]
    *@返回 org.springframework.security.core.userdetails.UserDetails
    *@作者 yehw
    *@日期 2020/3/19
    *@时间 14:17
    */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(StringUtils.isEmpty(s)){
            throw new RuntimeException("用户名不能为空");
        }
        //根据用户名查询用户
        SysUser sysUser = sysUserService.selectByName(s);
        if(sysUser==null){
            throw new RuntimeException("用户名不存在");
        }
        //定义权限集合
        List<GrantedAuthority> grantedAuthorities =new ArrayList<>();
        //获得用户所有权限
        List<SysPermission> sysPermissions=sysPermissionService.selectListByUser(sysUser.getId());
        //声明授权
        sysPermissions.forEach(sysPermission -> {
            GrantedAuthority grantedAuthority=new SimpleGrantedAuthority(sysPermission.getPath());
            grantedAuthorities.add(grantedAuthority);
        });
        return new User(sysUser.getUsername(),//查询到的用户名
                sysUser.getPassword(),//查询到的密码
                sysUser.getEnabled(),//查询到用户是否可用
                sysUser.getIsExpired(),//查询到用户是否过期
                true,//证书是否过期
                sysUser.getIsLocked(),//是否锁定
                grantedAuthorities);//最后的权限
    }
}

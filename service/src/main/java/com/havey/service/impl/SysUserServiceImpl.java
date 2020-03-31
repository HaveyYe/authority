package com.havey.service.impl;

import com.havey.mapper.dao.SysUserDao;
import com.havey.model.entity.SysUser;
import com.havey.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public SysUser selectByName(String userName) {
        return sysUserDao.queryByUserName(userName);
    }

    @Override
    public SysUser queryById(Integer id) {
        return sysUserDao.queryById(id);
    }

    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return sysUserDao.queryAllByLimit(offset,limit);
    }

    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserDao.deleteById(id) > 0;
    }
}

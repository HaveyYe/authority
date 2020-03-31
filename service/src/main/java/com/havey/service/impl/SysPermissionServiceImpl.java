package com.havey.service.impl;

import com.havey.mapper.dao.SysPermissionDao;
import com.havey.model.entity.SysPermission;
import com.havey.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionDao sysPermissionDao;

    @Override
    public List<SysPermission> selectListByUser(Integer userId) {
        return sysPermissionDao.selectListByUser(userId);
    }

    @Override
    public SysPermission queryById(Integer id) {
        return null;
    }

    @Override
    public List<SysPermission> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public SysPermission insert(SysPermission sysPermission) {
        return null;
    }

    @Override
    public SysPermission update(SysPermission sysPermission) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}

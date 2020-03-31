package com.havey.service;

import com.havey.model.entity.SysPermissionRole;

import java.util.List;

/**
 * 角色权限表，一个角色对应多个权限。(SysPermissionRole)表服务接口
 *
 * @author makejava
 * @since 2020-03-19 14:07:23
 */
public interface SysPermissionRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermissionRole queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermissionRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysPermissionRole 实例对象
     * @return 实例对象
     */
    SysPermissionRole insert(SysPermissionRole sysPermissionRole);

    /**
     * 修改数据
     *
     * @param sysPermissionRole 实例对象
     * @return 实例对象
     */
    SysPermissionRole update(SysPermissionRole sysPermissionRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
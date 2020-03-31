package com.havey.mapper.dao;

import com.havey.model.entity.SysPermissionRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色权限表，一个角色对应多个权限。(SysPermissionRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-17 22:00:29
 */
public interface SysPermissionRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysPermissionRole queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SysPermissionRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPermissionRole 实例对象
     * @return 对象列表
     */
    List<SysPermissionRole> queryAll(SysPermissionRole sysPermissionRole);

    /**
     * 新增数据
     *
     * @param sysPermissionRole 实例对象
     * @return 影响行数
     */
    int insert(SysPermissionRole sysPermissionRole);

    /**
     * 修改数据
     *
     * @param sysPermissionRole 实例对象
     * @return 影响行数
     */
    int update(SysPermissionRole sysPermissionRole);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}
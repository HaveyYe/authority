package com.havey.model.entity;

import java.io.Serializable;

/**
 * 角色权限表，一个角色对应多个权限。(SysPermissionRole)实体类
 *
 * @author makejava
 * @since 2020-03-17 21:46:56
 */
public class SysPermissionRole implements Serializable {
    private static final long serialVersionUID = 707728711587106373L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 角色ID
    */
    private Integer roleId;
    /**
    * 权限ID
    */
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}
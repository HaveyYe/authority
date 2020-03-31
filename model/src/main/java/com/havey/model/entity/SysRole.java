package com.havey.model.entity;

import java.io.Serializable;

/**
 * 角色表(SysRole)实体类
 *
 * @author makejava
 * @since 2020-03-17 21:46:56
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 825165123591029304L;
    /**
    * 主键id
    */
    private Integer id;
    /**
    * 角色名字
    */
    private String roleName;
    /**
    * 角色描述
    */
    private String roleDescription;
    /**
    * 角色代码
    */
    private String roleCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

}
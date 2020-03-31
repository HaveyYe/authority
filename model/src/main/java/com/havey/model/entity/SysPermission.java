package com.havey.model.entity;

import java.io.Serializable;

/**
 * 权限表，主要是路劲和菜单名字。(SysPermission)实体类
 *
 * @author makejava
 * @since 2020-03-17 21:46:51
 */
public class SysPermission implements Serializable {
    private static final long serialVersionUID = 195654868621428075L;
    /**
    * 主键ID
    */
    private Integer id;
    /**
    * 权限名称
    */
    private String permissionName;
    /**
    * 权限路劲
    */
    private String url;
    /**
    * 权限地址
    */
    private String path;
    /**
    * 组件
    */
    private String component;
    /**
    * 菜单栏icon样式
    */
    private String iconcls;
    /**
    * 保持连接
    */
    private String keepalive;
    /**
    * 父权限ID
    */
    private Integer parentid;
    /**
    * 是否可用（可用默认是1）
    */
    private Object enabled;
    /**
    * 是否需要认证（默认是1需要认证）
    */
    private Object requireauth;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIconcls() {
        return iconcls;
    }

    public void setIconcls(String iconcls) {
        this.iconcls = iconcls;
    }

    public String getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(String keepalive) {
        this.keepalive = keepalive;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Object getEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = enabled;
    }

    public Object getRequireauth() {
        return requireauth;
    }

    public void setRequireauth(Object requireauth) {
        this.requireauth = requireauth;
    }

}
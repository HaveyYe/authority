package com.havey.model.entity;

import com.havey.model.Constants;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(SysUser)实体类
 *
 * @author makejava
 * @since 2020-03-17 21:46:56
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 391045531309031369L;
    /**
    * 主键
    */
    private Integer id;
    /**
    * 姓名
    */
    private String name;
    /**
    * 手机号码
    */
    private String mobilephone;
    /**
    * 固定电话
    */
    private String telephone;
    /**
    * 住址
    */
    private String address;
    /**
    * 登录用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 是否可用
    */
    private Boolean enabled;
    /**
    * 头像
    */
    private String userface;
    /**
    * 上次登录时间
    */
    private Date lastLoginTime;
    /**
    * 是否过期（默认是1不过其）
    */
    private Boolean isExpired;
    /**
    * 账号是否锁定，默认是1不锁定
    */
    private Boolean isLocked;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 创建人ID
    */
    private Integer createUser;
    /**
    * 更新人ID
    */
    private Integer updateUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled=Constants.IS_ENABLED.equals(enabled);
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public void setIsExpired(String isExpired) {

        this.isExpired = Constants.IS_NOT_EXPIRED.equals(isExpired);
    }

    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {

        this.isLocked = Constants.IS_NOT_LOCKED.equals(isLocked);
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

}
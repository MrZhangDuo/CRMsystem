package com.hy.crmsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-02
 */
@TableName("authority")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限主键
     */
    @TableId(value = "authorityId",type = IdType.AUTO)
    private Integer authorityId;

    /**
     * 权限
     */
    private String authority;

    /**
     * 父级权限
     */
    private Integer perentauthority;

    /**
     * 权限地址
     */
    private String authorityAddess;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
    public Integer getPerentauthority() {
        return perentauthority;
    }

    public void setPerentauthority(Integer perentauthority) {
        this.perentauthority = perentauthority;
    }
    public String getAuthorityAddess() {
        return authorityAddess;
    }

    public void setAuthorityAddess(String authorityAddess) {
        this.authorityAddess = authorityAddess;
    }

    @Override
    public String toString() {
        return "Authority{" +
        "authorityId=" + authorityId +
        ", authority=" + authority +
        ", perentauthority=" + perentauthority +
        ", authorityAddess=" + authorityAddess +
        "}";
    }
}

package com.hy.crmsystem.mrli.utils;

import com.hy.crmsystem.mrli.entity.User;

import java.util.List;

/**
 * @author licheng
 * @date 2020/4/13 16:46
 */
public class ActivierUser {

    private User user;
    private List<String> roles;
    private List<String> permissions;

    public ActivierUser() {
    }

    public ActivierUser(User user, List<String> roles, List<String> permissions) {
        this.user = user;
        this.roles = roles;
        this.permissions = permissions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}

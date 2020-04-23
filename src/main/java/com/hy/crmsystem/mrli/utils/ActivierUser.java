package com.hy.crmsystem.mrli.utils;

import com.hy.crmsystem.mrli.entity.User;

import java.util.List;
import java.util.Set;

/**
 * @author licheng
 * @date 2020/4/13 16:46
 */
public class ActivierUser {

    private User user;
    private Set<String> roles;
    private Set<String> permissions;

    public ActivierUser() {
    }

    public ActivierUser(User user, Set<String> roles, Set<String> permissions) {
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}

package com.hy.crmsystem.mrli.controller;

import com.hy.crmsystem.mrli.entity.Permission;
import com.hy.crmsystem.mrli.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author licheng
 * @date 2020/4/22 9:53
 */
@RestController
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/loadAllPermision")
    public Object loadAllPermision(Permission permission){
        return this.permissionService.loadAllPermision(permission);
    }



}

package com.hy.crmsystem.mrli.controller;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.service.LoginfoService;
import com.hy.crmsystem.mrli.utils.ResultObj;
import com.hy.crmsystem.mrli.vo.LoginfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author licheng
 * @date 2020/4/15 17:04
 */
@RequestMapping("/loginfo")
@RestController
public class LoginfoController {


    @Autowired
    private LoginfoService loginfoService;

    @RequestMapping("/loadAllLoginfo")
    public DataGridView loadAllLoginfo(LoginfoVo loginfoVo) {
        return this.loginfoService.queryAllLoginfo(loginfoVo);
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteLoginfo")
    public ResultObj deleteLoginfo(Integer id) {
        try {
            this.loginfoService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }


    /**
     * 批量删除
     */
    @RequestMapping("/batchDeleteLoginfo")
    public ResultObj batchDeleteLoginfo(Integer[] ids) {
        try {
            if (null != ids && ids.length > 0) {
                List<Integer> idsList = new ArrayList<>();
                for (Integer id : ids) {
                    idsList.add(id);
                }
                this.loginfoService.removeByIds(idsList);
                return ResultObj.DELETE_SUCCESS;
            } else {
                return new ResultObj(-1, "删除项为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

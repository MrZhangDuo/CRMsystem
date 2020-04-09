package com.hy.crmsystem.mrli.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hy.crmsystem.mrli.entity.BaseEntity;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Documentary;
import com.hy.crmsystem.mrli.service.IDocumentaryService;
import com.hy.crmsystem.mrli.vo.DocumentaryVo;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Controller
@RequestMapping("/documentary")
public class DocumentaryController {


    @Autowired
    private IDocumentaryService documentaryService;
    @Autowired
    private IBusinessService businessService;


    /**
     * 查询全部跟单
     */
    @RequestMapping(value = "/queryAllDocumentary")
    @ResponseBody
    public DataGridView loadAllDocumentary(DocumentaryVo documentaryVo) {

        return this.documentaryService.queryAllDocumentary(documentaryVo);
    }

    /**
     * 查询商机名称 为新增跟单下拉框赋值
     */
    @RequestMapping(value = "/queryBusName")
    @ResponseBody
    public List<Business> queryBusName(){
        return this.businessService.queryBusName();
    }
}

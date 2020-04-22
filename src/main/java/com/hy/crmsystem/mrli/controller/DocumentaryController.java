package com.hy.crmsystem.mrli.controller;


import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.service.IDocumentaryService;
import com.hy.crmsystem.mrli.vo.DocumentaryVo;
import com.hy.crmsystem.mrpan.entity.Business;
import com.hy.crmsystem.mrpan.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03*/


@Controller
@RequestMapping("/documentary")
public class DocumentaryController {


    @Autowired
    private IDocumentaryService documentaryService;
    @Autowired
    private IBusinessService businessService;


/**
     * 查询全部跟单*/


    @RequestMapping(value = "/queryAllDocumentary")
    @ResponseBody
    public DataGridView loadAllDocumentary(DocumentaryVo documentaryVo) {

        return this.documentaryService.queryAllDocumentary(documentaryVo);
    }

/*
*
     * 查询商机名称 为新增跟单下拉框赋值
*/


    @RequestMapping(value = "/queryBusName")
    @ResponseBody
    public List<Business> queryBusName() {
        return this.businessService.list();
    }


/*
*
     * 新增跟单记录

*/

    @RequestMapping("/addDocumentary")
    @ResponseBody
    public Map addDocumentary(DocumentaryVo documentaryVo) {
        Map map = new HashMap<>(16);
        try {
            this.documentaryService.addDocumentary(documentaryVo);
            map.put("flag", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("flag", false);
        }
        return map;
    }

    /**
     查询历史跟单记录
     */
    @RequestMapping("/queryOldDocumentart")
    @ResponseBody
    public DataGridView queryOldDocumentart(String docTitle){
        return this.documentaryService.queryOldDocumentary(docTitle);
    }
}

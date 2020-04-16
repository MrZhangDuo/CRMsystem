package com.hy.crmsystem.mrpan.controller;

import com.hy.crmsystem.mrpan.service.impl.MoneyinforServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@RestController
@RequestMapping("/moneyinfor")
public class MoneyinforController {

    @Autowired
    private MoneyinforServiceImpl moneyinforService;



}

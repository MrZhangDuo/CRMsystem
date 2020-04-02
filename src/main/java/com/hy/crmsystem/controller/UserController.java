package com.hy.crmsystem.controller;


import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-02
 */
@RestController
@RequestMapping("/crmsystem/user")
public class UserController {
    @RequestMapping("test.do")
    public void test(){
        Logger logger=Logger.getLogger(UserController.class);
        logger.info("测试=======================================================成功");
    }

}

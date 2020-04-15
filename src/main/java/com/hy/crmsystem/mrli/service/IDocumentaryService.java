package com.hy.crmsystem.mrli.service;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Documentary;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hy.crmsystem.mrli.vo.DocumentaryVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
public interface IDocumentaryService extends IService<Documentary> {

    /**
     * 查询全部跟单
     * @param documentaryVo
     * @return
     */
    DataGridView queryAllDocumentary(DocumentaryVo documentaryVo);


    /**
     * 新增跟单
     * @param documentaryVo
     */
    void addDocumentary(DocumentaryVo documentaryVo);
}

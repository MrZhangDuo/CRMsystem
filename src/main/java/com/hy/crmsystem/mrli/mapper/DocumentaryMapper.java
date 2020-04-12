package com.hy.crmsystem.mrli.mapper;

import com.hy.crmsystem.mrli.entity.Documentary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrli.vo.DocumentaryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */

public interface DocumentaryMapper extends BaseMapper<Documentary> {

    /**
     * 查询全部跟单
     *
     * @param documentaryVo
     * @return
     */
    List<Documentary> queryAllDocumentary(DocumentaryVo documentaryVo);

}

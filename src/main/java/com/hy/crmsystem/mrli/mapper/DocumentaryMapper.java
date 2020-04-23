package com.hy.crmsystem.mrli.mapper;

import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Documentary;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hy.crmsystem.mrli.vo.DocumentaryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
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

    /**
     * 根据跟单标题 查询历史跟单记录
     *
     * @param docTitle
     * @return
     */
    List<Documentary> queryOldDocumentByDocTitle(String docTitle);


    /**
     * 根据登录人查询全部跟单
     *
     * @param documentaryVo
     * @return
     */
    List<Documentary> queryAllDocumentaryByUserName( DocumentaryVo documentaryVo, @Param("realname") String realname);
}

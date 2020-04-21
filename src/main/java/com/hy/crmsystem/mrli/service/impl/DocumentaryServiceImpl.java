package com.hy.crmsystem.mrli.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hy.crmsystem.mrli.entity.DataGridView;
import com.hy.crmsystem.mrli.entity.Documentary;
import com.hy.crmsystem.mrli.mapper.DocumentaryMapper;
import com.hy.crmsystem.mrli.service.IDocumentaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hy.crmsystem.mrli.vo.DocumentaryVo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhangduo
 * @since 2020-04-03
 */
@Service
public class DocumentaryServiceImpl extends ServiceImpl<DocumentaryMapper, Documentary> implements IDocumentaryService {

    private static final Logger LOGGER = Logger.getLogger(DocumentaryServiceImpl.class);

    @Autowired
    private DocumentaryMapper documentaryMapper;

    @Override
    public DataGridView queryAllDocumentary(DocumentaryVo documentaryVo) {
//        IPage<Documentary> page = new Page<>(documentaryVo.getPage(), documentaryVo.getLimit());
//        LOGGER.info(page.getTotal()+"--------------------------------");
//        QueryWrapper<Documentary> qw = new QueryWrapper<>();
//        qw.like(StringUtils.isNotEmpty(documentaryVo.getDocPeople()),"DocPeople",documentaryVo.getDocPeople());
//        qw.like(StringUtils.isNotEmpty(documentaryVo.getDocTitle()), "DocTitle", documentaryVo.getDocTitle());
//        /*qw.ge(documentaryVo.getDocTime() != null, "DocTime", documentaryVo.getDocTime());
//        qw.le(documentaryVo.getEndTime() != null, "endtime", documentaryVo.getEndTime());*/
//        qw.orderByDesc("DocTime");
//        this.documentaryMapper.selectPage(page, qw);
//        return new DataGridView(Long.parseLong(String.valueOf(page.getRecords().size())),page.getRecords());
        Page<Object> page = PageHelper.startPage(documentaryVo.getPage(), documentaryVo.getLimit());
        List<Documentary> data = this.documentaryMapper.queryAllDocumentary(documentaryVo);
        return new DataGridView(page.getTotal(), data);
    }


    @Override
    public void addDocumentary(DocumentaryVo documentaryVo) {
        this.documentaryMapper.insert(documentaryVo);
    }


    @Override
    public DataGridView queryOldDocumentary(String docTitle) {
        List<Documentary> data = this.documentaryMapper.queryOldDocumentByDocTitle(docTitle);
        return new DataGridView(data);
    }
}

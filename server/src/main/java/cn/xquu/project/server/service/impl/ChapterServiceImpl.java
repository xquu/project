package cn.xquu.project.server.service.impl;

import cn.xquu.project.server.domain.Chapter;
import cn.xquu.project.server.domain.ChapterExample;
import cn.xquu.project.server.mapper.ChapterMapper;
import cn.xquu.project.server.service.ChapterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-10 15:19
 */
@Service("chapterService")
public class ChapterServiceImpl implements ChapterService {
    @Resource
    ChapterMapper chapterMapper;

    @Override
    public List<Chapter> list() {
        ChapterExample chapterExample = new ChapterExample();
        chapterExample.createCriteria().andIdEqualTo("1");
        chapterExample.setOrderByClause("id desc");
        return chapterMapper.selectByExample(chapterExample);
    }
}

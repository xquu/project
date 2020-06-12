package cn.xquu.project.server.service.impl;

import cn.xquu.project.server.domain.Chapter;
import cn.xquu.project.server.domain.ChapterExample;
import cn.xquu.project.server.dto.ChapterDto;
import cn.xquu.project.server.mapper.ChapterMapper;
import cn.xquu.project.server.service.ChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
    public List<ChapterDto> list() {
        ChapterExample chapterExample = new ChapterExample();
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        for (Chapter  chapter: chapterList) {
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter,chapterDto);
            chapterDtoList.add(chapterDto);
        }
        return chapterDtoList;
    }
}

package cn.xquu.project.server.service.impl;

import cn.xquu.project.server.domain.Chapter;
import cn.xquu.project.server.domain.ChapterExample;
import cn.xquu.project.server.dto.ChapterDto;
import cn.xquu.project.server.dto.util.PageDto;
import cn.xquu.project.server.mapper.ChapterMapper;
import cn.xquu.project.server.service.ChapterService;
import cn.xquu.project.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
    public void list(PageDto pageDto) {
        //分页从1开始,作用于距离最近的select语句
        PageHelper.startPage(pageDto.getPage(),pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<ChapterDto> chapterDtoList = new ArrayList<>();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo pageInfo = new PageInfo(chapterList);
        pageDto.setTotal(pageInfo.getTotal());
        for (Chapter  chapter: chapterList) {
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter, chapterDto);
            chapterDtoList.add(chapterDto);
        }
        pageDto.setList(chapterDtoList);
    }
    public void save(ChapterDto chapterDto){
        chapterDto.setId(UuidUtil.getShortUuid());
        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterDto, chapter);
        chapterMapper.insert(chapter);
    }
}

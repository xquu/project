package cn.xquu.project.server.service;

import cn.xquu.project.server.domain.Chapter;
import cn.xquu.project.server.domain.ChapterExample;
import cn.xquu.project.server.dto.ChapterDto;
import cn.xquu.project.server.dto.util.PageDto;
import cn.xquu.project.server.mapper.ChapterMapper;
import cn.xquu.project.server.util.CopyUtil;
import cn.xquu.project.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-10 15:19
 */
@Service("chapterService")
public class ChapterService {
    @Resource
    ChapterMapper chapterMapper;

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
        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        if(StringUtils.isEmpty(chapterDto.getId())){
            this.insert(chapter);
        }else{
            this.update(chapter);
        }
    }

    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }

    private void insert(Chapter chapter) {
        chapter.setId(UuidUtil.getShortUuid());
        chapterMapper.insert(chapter);
    }

    private void update(Chapter chapter){
        chapterMapper.updateByPrimaryKey(chapter);
    }
}

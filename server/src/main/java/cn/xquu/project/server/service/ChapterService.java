package cn.xquu.project.server.service;

import cn.xquu.project.server.dto.ChapterDto;
import cn.xquu.project.server.dto.util.PageDto;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-10 15:15
 */
public interface ChapterService {
    public void list(PageDto pageDto);

    public void save(ChapterDto chapterDto);

    public void delete(String id);
}

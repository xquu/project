package cn.xquu.project.server.service;

import cn.xquu.project.server.dto.ChapterDto;
import cn.xquu.project.server.dto.PageDto;

import java.util.List;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-10 15:15
 */
public interface ChapterService {
    public void list(PageDto pageDto);
}

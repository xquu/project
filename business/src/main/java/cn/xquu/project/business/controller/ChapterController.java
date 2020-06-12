package cn.xquu.project.business.controller;

import cn.xquu.project.server.domain.Chapter;
import cn.xquu.project.server.service.ChapterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-12 11:28
 */
@RestController
//@RequestMapping("chapter")
public class ChapterController {
    @Resource
    ChapterService chapterService;

    @GetMapping("list")
    private List<Chapter> list(){
        return  chapterService.list();
    }
}

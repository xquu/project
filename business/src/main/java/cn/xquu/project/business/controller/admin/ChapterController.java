package cn.xquu.project.business.controller.admin;

import cn.xquu.project.server.dto.ChapterDto;
import cn.xquu.project.server.service.ChapterService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-12 11:28
 */
@RestController
@RequestMapping(value = "admin/chapter",produces = MediaType.APPLICATION_JSON_VALUE)
//@RequestMapping(value = "chapter",produces = MediaType.APPLICATION_XML_VALUE)
public class ChapterController {
    @Resource
    ChapterService chapterService;

    @GetMapping("list")
    private List<ChapterDto> list(){
        return  chapterService.list();
    }
}

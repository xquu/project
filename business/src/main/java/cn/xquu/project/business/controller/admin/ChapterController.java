package cn.xquu.project.business.controller.admin;

import cn.xquu.project.server.dto.ChapterDto;
import cn.xquu.project.server.dto.util.PageDto;
import cn.xquu.project.server.dto.util.ResponseDto;
import cn.xquu.project.server.service.ChapterService;
import cn.xquu.project.server.util.ValidatorUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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


    @PostMapping("list")
    //axios默认以流的方式传递参数，这里加上@RequestBody才行
    private ResponseDto list(@RequestBody PageDto pageDto){
        ResponseDto responseDto = new ResponseDto();
        chapterService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("save")
    private ResponseDto save(@RequestBody ChapterDto chapterDto){

        ValidatorUtil.require(chapterDto.getName(),"名称");
        ValidatorUtil.require(chapterDto.getcourseId(),"名称");
        ValidatorUtil.length(chapterDto.getcourseId(),"名称",1,8);

        ResponseDto responseDto = new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    @DeleteMapping("delete/{id}")
    private ResponseDto save(@PathVariable String id){
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }
}

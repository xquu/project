package cn.xquu.project.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-05 17:19
 */
@RestController
public class TestController {
    @GetMapping("/test")
    private String test(){
        return "success";
    }
}

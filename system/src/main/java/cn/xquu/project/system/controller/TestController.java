package cn.xquu.project.system.controller;

import cn.xquu.project.server.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-05 17:19
 */
@RestController
public class TestController {
    @Resource
    TestService testService;
    @GetMapping("/test")
    private Object test(){
        return testService.hello();
    }
}

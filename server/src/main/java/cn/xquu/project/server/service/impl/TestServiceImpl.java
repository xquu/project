package cn.xquu.project.server.service.impl;

import cn.xquu.project.server.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author ：小七
 * @description：TODO
 * @date ：2020-06-10 15:19
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    @Override
    public Object hello() {
        return "success";
    }
}

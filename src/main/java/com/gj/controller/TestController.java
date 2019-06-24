package com.gj.controller;

import cn.gjing.lock.Lock;
import com.gj.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@RestController
public class TestController {

    @Resource
    private DemoService demoService;

    private static int num = 10;

    @GetMapping("/set")
    @Lock(key = "set", timeout = 3000, retry = 500)
    public void set() {
        if (num == 0) {
            System.out.println("卖完了");
            return;
        }
        num--;
        System.out.println("还剩余：" + num);
    }

    @GetMapping("/demo")
    public void demo() {
        demoService.decr();
    }
}

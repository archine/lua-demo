package com.gj.service;

import cn.gjing.lock.AbstractLock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Gjing
 **/
@Service
public class DemoService {
    @Resource
    private AbstractLock abstractLock;

    private static int num = 10;

    public void decr() {
        String lock = null;
        try {
            lock = abstractLock.lock("decr", UUID.randomUUID().toString().replaceAll("-",""), 20, 10000, 1000);
            if (num == 0) {
                System.out.println("卖完了");
            }else {
                num--;
                System.out.println("还剩余：" + num);
            }
        } finally {
            String release = abstractLock.release("decr", lock);
            if (release != null) {
                System.out.println("锁释放成功：" + release);
            } else {
                System.out.println("锁释放失败，锁已失效或已解锁");
            }
        }
    }
}

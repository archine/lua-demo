package com.gj;

import cn.gjing.lock.EnableRedisLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedisLock
public class LuaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuaDemoApplication.class, args);
    }

}

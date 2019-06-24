package com.gj;

import cn.gjing.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRedis
public class LuaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuaDemoApplication.class, args);
    }

}

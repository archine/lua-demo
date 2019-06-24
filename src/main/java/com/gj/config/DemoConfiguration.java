package com.gj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

/**
 * @author Gjing
 **/
@Configuration
public class DemoConfiguration {
    @Bean
    public DefaultRedisScript<String> lock() {
        DefaultRedisScript<String> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/Lock.lua")));
        defaultRedisScript.setResultType(String.class);
        return defaultRedisScript;
    }

    @Bean
    public DefaultRedisScript<String> release() {
        DefaultRedisScript<String> defaultRedisScript = new DefaultRedisScript<>();
        defaultRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("script/Release.lua")));
        defaultRedisScript.setResultType(String.class);
        return defaultRedisScript;
    }
}

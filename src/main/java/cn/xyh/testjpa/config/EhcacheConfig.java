package cn.xyh.testjpa.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Create by xyh on 2019/1/17
 */
@Configuration
public class EhcacheConfig {

    @Resource
    private CacheManager cacheManager;

    @Bean("messageCache")
    public Cache getMessageCache() {
        return cacheManager.getCache("messageCache");
    }
}

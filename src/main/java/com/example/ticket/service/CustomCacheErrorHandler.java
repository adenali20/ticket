package com.example.ticket.service;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

public class CustomCacheErrorHandler implements CacheErrorHandler {
    @Override
    public void handleCacheGetError(RuntimeException exception,
                                    Cache cache, Object key) {
        //Do something on Get Error in cache
        System.out.println("Do something on Get Error in cache");
    }
    @Override
    public void handleCachePutError(RuntimeException exception, Cache cache,
                                    Object key, Object value) {
        //Do something on Put error in cache
        System.out.println("Do something on Put error in cache");

    }
    @Override
    public void handleCacheEvictError(RuntimeException exception, Cache cache,
                                      Object key) {
        //Do something on error while Evict cache
        System.out.println("Do something on error while Evict cache");

    }
    @Override
    public void handleCacheClearError(RuntimeException exception,Cache cache){
        //Do something on error while clearing cache
        System.out.println("Do something on error while clearing cache");

    }
}

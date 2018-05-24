package com.twitter.dare.daretwitter.redis.cache.errorhandler;

import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.Cache;

public class CustomCacheErrorHandler implements CacheErrorHandler {

	@Override
	public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
		System.out.println("Cache " + cache.getName() + " is down to search for key :" + key + " with exception :"
				+ exception.getMessage());
	}

	@Override
	public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {
		System.out.println("Cache " + cache.getName() + " is down to put for key :" + key + " with exception :"
				+ exception.getMessage());
	}

	@Override
	public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
		System.out.println("Cache " + cache.getName() + " is down to evict for key :" + key + " with exception :"
				+ exception.getMessage());
	}

	@Override
	public void handleCacheClearError(RuntimeException exception, Cache cache) {
		System.out.println("Cache " + cache.getName() + " is down to clear with exception :" + exception.getMessage());
	}

}

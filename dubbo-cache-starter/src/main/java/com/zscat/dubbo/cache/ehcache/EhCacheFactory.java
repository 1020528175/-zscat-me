package com.zscat.dubbo.cache.ehcache;

import com.alibaba.dubbo.cache.Cache;
import com.alibaba.dubbo.cache.support.AbstractCacheFactory;
import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.utils.StringUtils;

import com.zscat.dubbo.cache.config.CacheConfig;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author : zscat
 * @version : 1.0
 * @created on  : 2017/07/22  下午3:19
 */
public class EhCacheFactory extends AbstractCacheFactory {
    private ConcurrentHashMap<String,Cache> CACHE_MAP =new ConcurrentHashMap<String, Cache>();

    private static final String DEFAULT_WHITE_REGEX="^((select)|(get)|(query)|(load))[\\w-]*$";

    private static final String DEFAULT_BLACK_REGEX="^((insert)|(add)|(save)|(update))[\\w-]*$";

    private static String[] cacheMethodWhiteList;

    private static String[] cacheMethodBlackList;

    static {
        String configWhiteList= CacheConfig.getProperty("cache.method.white.list");
        String configBlackList = CacheConfig.getProperty("cache.method.black.list");
        if(!StringUtils.isEmpty(configBlackList)){
            cacheMethodBlackList= Constants.COMMA_SPLIT_PATTERN.split(configBlackList);
        }else{
            cacheMethodBlackList=new String[]{DEFAULT_BLACK_REGEX};
        }
        if(!StringUtils.isEmpty(configWhiteList)){
            cacheMethodWhiteList=Constants.COMMA_SPLIT_PATTERN.split(configWhiteList);
        }else{
            cacheMethodWhiteList=new String[]{DEFAULT_WHITE_REGEX};
        }
    }
    protected boolean needCache(String method){
        for(String regex:cacheMethodBlackList){
            if(method.matches(regex)){
                return false;
            }
        }
        for(String regex:cacheMethodWhiteList){
            if(method.matches(regex)){
                return true;
            }
        }
        return false;
    }

    protected String generateCacheName(URL url){
        return url.getParameter(Constants.INTERFACE_KEY)+"."+url.getParameter(Constants.METHOD_KEY);
    }


    @Override
    public Cache getCache(URL url) {
        String method=url.getParameter(Constants.METHOD_KEY);
        if(!needCache(method)){
            return null;
        }
        String cacheName = generateCacheName(url);
        if(CACHE_MAP.containsKey(cacheName)){
            return CACHE_MAP.get(cacheName);
        }
        Cache cache = generateNewCache(cacheName,url);
        cache=putCacheIfAbsent(cacheName,cache);
        return cache;
    }

    @Override
    protected Cache createCache(URL url) {
       return new EhCache(url);
    }


    protected Cache putCacheIfAbsent(String cacheName,Cache cache){
        if(CACHE_MAP.containsKey(cacheName)){
            return CACHE_MAP.get(cacheName);
        }
        Cache oldCache = CACHE_MAP.putIfAbsent(cacheName, cache);
        if(oldCache==null){
            return cache;
        }
        return oldCache;
    }

    protected Cache generateNewCache(String cacheName, URL url) {
        return new EhCache(cacheName,url);
    }
}

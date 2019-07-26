package com.liu.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.InputStream;
import java.util.Properties;

/**
 * redis数据库连接池
 * **/
public class RedisSource {
    private static JedisPool jedisPool = null;
        /*静态语句块 类被加载的时候调用*/
    private static  Properties properties;
    static {
            try {
                InputStream inputStream  = RedisSource.class.getClassLoader().getResourceAsStream( "dataSource.properties" );
                properties =   new  Properties();
                properties.load(inputStream);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            jedisPool();
        }





    /*数据库连接池*/
        private static void jedisPool(){
            /*数据库连接池的一些配置*/
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            /*最大数据源*/
            jedisPoolConfig.setMaxTotal(1000);
            /*最大闲置数*/
            jedisPoolConfig.setMaxIdle(300);
            /*最小闲置数*/
            jedisPoolConfig.setMinIdle(100);
            jedisPoolConfig.setTestOnBorrow(true);
            jedisPoolConfig.setTestOnReturn(true);
            /*连接*/
            String host = properties.getProperty("redis.host");
            String port = properties.getProperty("redis.port");
            jedisPool = new JedisPool(jedisPoolConfig,host,Integer.parseInt(port));
        }

        public static Jedis infoRedis(){
            return jedisPool.getResource();
        };

}

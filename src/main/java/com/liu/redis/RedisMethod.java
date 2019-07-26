package com.liu.redis;

import redis.clients.jedis.Jedis;

/**
 * redis的一些方法
 * */
public class RedisMethod {

    public static void expire(String key,int time){
        Jedis jedis = null;
        try {
            jedis = RedisSource.infoRedis();
            jedis.expire(key, time);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if(null != jedis){
            jedis.close();
            }
        }
    }

    public static Boolean exists(String key){
        Jedis jedis = null;
        Boolean exists = null;
        try {
            jedis = RedisSource.infoRedis();
            exists = jedis.exists(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
        return exists;
    }
    /*set方法*/
    public static void set(String key, String value){
        Jedis jedis = null;
        try {
            jedis = RedisSource.infoRedis();
            jedis.set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
    }


    /*get方法*/
    public static String get(String key){
        Jedis jedis = null;
        String s = null;
        try {
            jedis = RedisSource.infoRedis();
            s = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if(null != s){
                jedis.close();
            }
        }
        return s;
    }

    /*删除方法*/
    public static void del(String key){
        Jedis jedis = null;
        try {
            jedis = RedisSource.infoRedis();
            jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            jedis.close();
        }
    }
    /*定时*/
    public static void setEx(String key,int time, String value){
        Jedis jedis = null;
        try {
            jedis = RedisSource.infoRedis();
            String setex = jedis.setex(key, time, value);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if(jedis != null){
                jedis.close();
            }
        }
    }

}

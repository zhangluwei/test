package com.luwei.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

    private static  JedisPool jedisPool;
    private static boolean init = false;

    public static Jedis getInstance() {
        if (!init) {
            
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(100);
             config.setTestOnBorrow(true);
            jedisPool = new JedisPool(config, "39.108.134.191", 6379, 5000);
//            jedisPool = new JedisPool(config, "127.0.0.1", 6379, 5000);
            
        }
        
        System.out.println("poooooooooool stat : " 
        +jedisPool.getNumActive() 
        +" ,"+jedisPool.getNumIdle()
        +" ,"+jedisPool.getNumWaiters()
        );
        
        return jedisPool.getResource();
        
    }
    
    public static  void close(Jedis jedis){
        jedis.close();
    }
    
    
    

}

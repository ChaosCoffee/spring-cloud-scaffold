package com.server.servers.redis;

import javafx.beans.binding.ObjectExpression;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.jws.Oneway;


/**
 * Created by chaos on 2017/7/11 0011.
 */

/**
 * java连接Jedis进行redis的存储
 * redis的连接池设置
 */
public class JedisUtil {
    private static String JEDIS_IP;
    private static int JEDIS_PORT;
    private static String JEDIS_PASSWORD;

    private static JedisPool jedisPool;

    static {
        Configuration configuration = Configuration.getInstance();
        JEDIS_IP = configuration.getString("jedis.ip", "127.0.0.1");
        JEDIS_PORT = configuration.getInt("jedis.port", 6379);
        JEDIS_PASSWORD = configuration.getString("jedis.password", null);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(5000);
        jedisPoolConfig.setMaxIdle(256);
        jedisPoolConfig.setMaxWaitMillis(5000L);
        jedisPoolConfig.setTestOnBorrow(true);
        jedisPoolConfig.setTestOnReturn(true);
        jedisPoolConfig.setTestWhileIdle(true);
        jedisPoolConfig.setMinEvictableIdleTimeMillis(60000L);
        jedisPoolConfig.setTimeBetweenEvictionRunsMillis(3000L);
        jedisPoolConfig.setNumTestsPerEvictionRun(-1);
        jedisPool = new JedisPool(jedisPoolConfig, JEDIS_IP, JEDIS_PORT, 60000);
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        String value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //返还连接池
            close(jedis);
        }
        return value;
    }

    /**
     * 获取数据
     *
     * @param key
     * @return
     */
    public static byte[] get(byte[] key) {
        byte[] value = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            value = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(jedis);
        }
        return value;
    }

    public static Long lpush(byte[] key, byte[] value) {
        Jedis jedis = null;
        Long result = null;
        try {
            jedis = jedisPool.getResource();
            result = jedis.lpush(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(jedis);
        }
        return result;
    }

    /**
     * 获取队列数据
     *
     * @param key
     * @return
     */
    public static byte[] rpop(byte[] key) {
        byte[] bytes = null;
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            bytes = jedis.rpop(key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(jedis);
        }
        return bytes;
    }

    /**
     * 关闭资源
     *
     * @param jedis
     */
    public static void close(Jedis jedis) {
        try {
            jedis.close();
        } catch (Exception e) {
            if (jedis.isConnected()) {
                jedis.quit();
                jedis.disconnect();
            }
        }
    }
}

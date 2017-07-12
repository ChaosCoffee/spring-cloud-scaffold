package com.server.servers.redis;

import com.netflix.eureka.util.MeasuredRate;
import redis.clients.jedis.Jedis;


import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chaos on 2017/7/12 0012.
 */
public class RedisQueneTest {
    public static byte[] key = "row_key".getBytes();

    static {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            InputStream inputStream = Configuration.class.getClassLoader().getSystemResourceAsStream("config.xml");
            System.out.println("inputStream = " + inputStream);
            pop();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private static void pop() throws IOException, ClassNotFoundException {
        byte[] bytes = JedisUtil.rpop(key);
        Message message = (Message) ObjectUtil.byteToObject(bytes);
        if (message != null) {
            System.out.println("message.getId()+\"\"+message.getContent() = " + message.getId() + "||" + message.getContent());
        }
    }

    private static void init() throws IOException {
        Message message1 = new Message(1, "消息1");
        Long lpush1 = JedisUtil.lpush(key, ObjectUtil.objectToByte(message1));
        System.out.println("lpush1 = " + lpush1);
        Message message2 = new Message(2, "消息2");
        Long lpush2 = JedisUtil.lpush(key, ObjectUtil.objectToByte(message2));
        System.out.println("lpush2 = " + lpush2);
        Message message3 = new Message(3, "消息3");
        Long lpush3 = JedisUtil.lpush(key, ObjectUtil.objectToByte(message3));
        System.out.println("lpush3 = " + lpush3);
    }
}

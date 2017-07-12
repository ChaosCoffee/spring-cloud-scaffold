package com.server.servers.redis;

import java.io.*;

/**
 * Created by chao on 2017/7/11 0011.
 */
public class ObjectUtil {
    /**
     * 对象转byte[]字节
     *
     * @param obj
     * @return
     * @throws IOException
     */
    public static byte[] objectToByte(Object obj) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(os);
        oo.writeObject(obj);
        byte[] bytes = os.toByteArray();
        os.close();
        oo.close();
        return bytes;
    }

    /**
     * byte[]字节转对象
     *
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object byteToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        ObjectInputStream os = new ObjectInputStream(is);
        Object obj = os.readObject();
        is.close();
        os.close();
        return obj;
    }
}

package com.oszhugc.serialize;

import com.oszhugc.serialize.impl.JSONSerializer;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:32
 **/
public interface Serializer {

    Serializer DEFAULT = new JSONSerializer();

    /**
     * 序列化算法
     *
     * @return
     */
    byte getSerializerAlgorithm();

    /**
     * java对象转为二进制
     * @param object
     * @return
     */
    byte[] serialize(Object object);

    /**
     * 二进制转换为java对象
     * @param tClass
     * @param bytes
     * @param <T>
     * @return
     */
    <T> T deserializer(Class<T> tClass,byte[] bytes);
}

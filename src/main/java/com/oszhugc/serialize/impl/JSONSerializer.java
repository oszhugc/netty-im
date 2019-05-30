package com.oszhugc.serialize.impl;

import com.alibaba.fastjson.JSON;
import com.oszhugc.serialize.Serializer;
import com.oszhugc.serialize.SerializerAlgorithm;

import java.io.Serializable;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:35
 **/
public class JSONSerializer implements Serializer {


    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserializer(Class<T> tClass, byte[] bytes) {
        return JSON.parseObject(bytes,tClass);
    }
}

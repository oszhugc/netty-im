package com.oszhugc.protocol;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 21:53
 **/
@Data
public abstract class Packet {

    /**
     * 协议版本号
     */
    @JSONField(deserialize = false,serialize = false)
    private Byte version = 1;

    @JSONField(serialize = false)
    public abstract Byte getCommond();
}

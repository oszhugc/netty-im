package com.oszhugc.attributes;

import com.oszhugc.session.Session;
import io.netty.util.AttributeKey;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 21:46
 **/
public interface Attributes {

    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}

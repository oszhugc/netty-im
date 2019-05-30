package com.oszhugc.util;

import java.util.UUID;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 6:52
 **/
public class IDUtil {

    public static String randomId(){
        return UUID.randomUUID().toString().split("-")[0];
    }
}

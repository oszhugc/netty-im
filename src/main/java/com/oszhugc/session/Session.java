package com.oszhugc.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 21:47
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Session {

    /**
     * 用户唯一性标识
     */
    private String userId;

    private String userName;

}

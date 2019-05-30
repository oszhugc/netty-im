package com.oszhugc.protocol.response;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import com.oszhugc.session.Session;
import lombok.Data;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:20
 **/
@Data
public class GroupMessageResponsePacket extends Packet {

    private String fromGroupId;
    private Session fromUser;
    private String message;

    @Override
    public Byte getCommond() {
        return Command.GROUP_MESSAGE_RESPONSE;
    }
}

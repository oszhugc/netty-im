package com.oszhugc.protocol.request;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import lombok.Data;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:10
 **/
@Data
public class JoinGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommond() {
        return Command.JOIN_GROUP_REQUEST;
    }
}

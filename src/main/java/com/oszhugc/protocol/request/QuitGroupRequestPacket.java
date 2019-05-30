package com.oszhugc.protocol.request;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import lombok.Data;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:17
 **/
@Data
public class QuitGroupRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommond() {
        return Command.QUIT_GROUP_REQUEST;
    }
}

package com.oszhugc.protocol.response;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import lombok.Data;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:29
 **/
@Data
public class QuitGroupResponsePacket extends Packet {

    private String groupId;
    private boolean success;
    private String reason;

    @Override
    public Byte getCommond() {
        return Command.QUIT_GROUP_RESPONSE;
    }
}

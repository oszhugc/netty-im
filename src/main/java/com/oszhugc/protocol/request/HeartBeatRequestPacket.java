package com.oszhugc.protocol.request;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:09
 **/

public class HeartBeatRequestPacket extends Packet {

    @Override
    public Byte getCommond() {
        return Command.HEARTBEAT_REQUEST;
    }
}

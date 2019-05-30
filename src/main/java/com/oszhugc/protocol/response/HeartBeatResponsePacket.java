package com.oszhugc.protocol.response;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:21
 **/
public class HeartBeatResponsePacket extends Packet {

    @Override
    public Byte getCommond() {
        return Command.HEARTBEAT_RESPONSE;
    }
}

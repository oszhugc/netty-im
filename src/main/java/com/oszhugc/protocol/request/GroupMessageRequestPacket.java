package com.oszhugc.protocol.request;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:07
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMessageRequestPacket extends Packet {

    private String toGroupId;
    private String message;

    @Override
    public Byte getCommond() {
        return Command.GROUP_MESSAGE_REQUEST;
    }
}

package com.oszhugc.protocol.request;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import lombok.Data;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:12
 **/
@Data
public class ListGroupMembersRequestPacket extends Packet {

    private String groupId;

    @Override
    public Byte getCommond() {
        return Command.LIST_GROUP_MEMBERS_REQUEST;
    }
}

package com.oszhugc.protocol.response;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import com.oszhugc.session.Session;
import lombok.Data;

import java.util.List;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:24
 **/

@Data
public class ListGroupMembersResponsePacket extends Packet {

    private String groupId;

    private List<Session> sessionList;


    @Override
    public Byte getCommond() {
        return Command.LIST_GROUP_MEMBERS_RESPONSE;
    }
}

package com.oszhugc.protocol.response;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import lombok.Data;

import java.util.List;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:18
 **/
@Data
public class CreateGroupResponsePacket extends Packet {

    private boolean success;

    private String groupId;

    private List<String> userNameList;

    @Override
    public Byte getCommond() {
        return Command.CREATE_GROUP_RESPONSE;
    }
}

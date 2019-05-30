package com.oszhugc.protocol.request;

import com.oszhugc.protocol.Packet;
import com.oszhugc.protocol.command.Command;
import lombok.Data;

import java.util.List;

/**
 * @author oszhugc
 * @Date 2019\5\28 0028 22:04
 **/
@Data
public class CreateGroupRequestPacket extends Packet {

    private List<String> userIdList;


    @Override
    public Byte getCommond() {
        return Command.CREATE_GROUP_REQUEST;
    }
}

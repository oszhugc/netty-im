package com.oszhugc.client.handler;

import com.oszhugc.protocol.response.CreateGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 23:14
 **/
public class CreateGroupResponseHandler extends SimpleChannelInboundHandler<CreateGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, CreateGroupResponsePacket createGroupResponsePacket) throws Exception {
        System.out.println("群创建成功, id为["+ createGroupResponsePacket.getGroupId() +"],");
        System.out.println("群里有: " + createGroupResponsePacket.getUserNameList());

    }
}

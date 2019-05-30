package com.oszhugc.client.handler;

import com.oszhugc.protocol.response.GroupMessageResponsePacket;
import com.oszhugc.session.Session;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 23:18
 **/
public class GroupMessageResponseHandler extends SimpleChannelInboundHandler<GroupMessageResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, GroupMessageResponsePacket groupMessageResponsePacket) throws Exception {
        String fromGroupId = groupMessageResponsePacket.getFromGroupId();

        Session fromUser = groupMessageResponsePacket.getFromUser();

        System.out.println("收到["+fromGroupId+"]中["+fromUser+"]发来的消息: " + groupMessageResponsePacket.getMessage());
    }
}

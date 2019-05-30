package com.oszhugc.client.handler;

import com.oszhugc.protocol.response.ListGroupMembersResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 23:37
 **/
public class ListGroupMemembersResponseHandler extends SimpleChannelInboundHandler<ListGroupMembersResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ListGroupMembersResponsePacket listGroupMembersResponsePacket) throws Exception {
        System.out.println("群["+listGroupMembersResponsePacket.getGroupId()+"]中的人包括: " + listGroupMembersResponsePacket.getSessionList());

    }
}

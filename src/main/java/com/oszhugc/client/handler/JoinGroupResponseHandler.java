package com.oszhugc.client.handler;

import com.oszhugc.protocol.response.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 23:25
 **/
public class JoinGroupResponseHandler extends SimpleChannelInboundHandler<JoinGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, JoinGroupResponsePacket joinGroupResponsePacket) throws Exception {
        if (joinGroupResponsePacket.isSuccess()){
            System.out.println("加入群["+joinGroupResponsePacket.getGroupId()+"]成功");

        }else {
            System.out.println("加入群["+joinGroupResponsePacket.getGroupId()+"]失败,原因为: " + joinGroupResponsePacket.getReason());
        }
    }
}

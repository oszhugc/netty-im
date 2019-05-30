package com.oszhugc.client.handler;

import com.oszhugc.protocol.response.QuitGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 23:50
 **/
public class QuitGroupResponseHandler extends SimpleChannelInboundHandler<QuitGroupResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, QuitGroupResponsePacket quitGroupResponsePacket) throws Exception {
        if (quitGroupResponsePacket.isSuccess()){
            System.out.println("退出群聊["+quitGroupResponsePacket.getGroupId()+"]成功!");
        }else {
            System.out.println("退出群聊["+quitGroupResponsePacket.getGroupId()+"]失败!");
        }
    }
}

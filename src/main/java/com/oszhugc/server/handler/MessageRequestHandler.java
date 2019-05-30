package com.oszhugc.server.handler;

import com.oszhugc.protocol.request.MessageRequestPacket;
import com.oszhugc.protocol.response.MessageResponsePacket;
import com.oszhugc.session.Session;
import com.oszhugc.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author oszhugc
 * @Date 2019\5\30 0030 23:01
 **/
@ChannelHandler.Sharable
public class MessageRequestHandler extends SimpleChannelInboundHandler<MessageRequestPacket> {

    public static final MessageRequestHandler INSTANCE = new MessageRequestHandler();

    private MessageRequestHandler(){}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageRequestPacket requestPacket) throws Exception {

        //1. 拿到消息发送放的会话信息
        Session session = SessionUtil.getSession(ctx.channel());

        //2. 通过消息发送方的会话嘻嘻构造要发送的消息
        MessageResponsePacket responsePacket = new MessageResponsePacket();
        responsePacket.setFromUserId(session.getUserId());
        responsePacket.setFromUserName(session.getUserName());
        responsePacket.setMessage(requestPacket.getMessage());

        //3. 拿到消息接收方的channel
        Channel channel = SessionUtil.getChannel(requestPacket.getToUserId());

        //4.将消息发送给消息接收方
        if (channel != null && SessionUtil.hasLogin(channel)){
            channel.writeAndFlush(responsePacket).addListener(future -> {
                if (future.isDone()){
                    System.out.println("发送成功...");
                }
            });

        }else {
            System.out.println("["+session.getUserId()+"]不在线,发送失败!");
        }

    }
}

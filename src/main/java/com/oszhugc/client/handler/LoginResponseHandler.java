package com.oszhugc.client.handler;

import com.oszhugc.protocol.response.LoginResponsePacket;
import com.oszhugc.session.Session;
import com.oszhugc.util.SessionUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 23:39
 **/
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, LoginResponsePacket loginResponsePacket) throws Exception {
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUserName();

        if (loginResponsePacket.isSuccess()){
            System.out.println("["+ userName +"]登录成功, userId为: " + loginResponsePacket.getUserId());
            SessionUtil.bindSession(new Session(userId,userName), channelHandlerContext.channel());
        }else {
            System.out.println("["+userName+"]登录失败, 原因: " + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭!");
    }
}

package com.oszhugc.server.handler;

import com.oszhugc.protocol.request.LoginRequestPacket;
import com.oszhugc.protocol.response.LoginResponsePacket;
import com.oszhugc.session.Session;
import com.oszhugc.util.IDUtil;
import com.oszhugc.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.omg.PortableServer.IdUniquenessPolicy;

import java.util.Date;

/**
 * @author oszhugc
 * @Date 2019\5\30 0030 22:51
 **/
@ChannelHandler.Sharable
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {

    public static final LoginRequestHandler INSTANCE = new LoginRequestHandler();

    private LoginRequestHandler(){}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket requestPacket) throws Exception {

        LoginResponsePacket responsePacket = new LoginResponsePacket();
        requestPacket.setVersion(requestPacket.getVersion());
        responsePacket.setUserName(requestPacket.getUserName());

        if (valid(requestPacket)){
            responsePacket.setSuccess(true);
            String userId = IDUtil.randomId();
            responsePacket.setUserId(userId);
            System.out.println("["+requestPacket.getUserName()+"]登录成功");
            SessionUtil.bindSession(new Session(userId,requestPacket.getUserName()),ctx.channel());

        }else {
            responsePacket.setReason("账号密码校验失败!");
            responsePacket.setSuccess(false);
            System.out.println(new Date() + "登录失败!");
        }

        ctx.writeAndFlush(responsePacket);
    }

    private boolean valid(LoginRequestPacket requestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        SessionUtil.unBindSession(ctx.channel());
    }
}

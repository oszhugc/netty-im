package com.oszhugc.server.handler;

import com.oszhugc.protocol.request.QuitGroupRequestPacket;
import com.oszhugc.protocol.response.QuitGroupResponsePacket;
import com.oszhugc.util.SessionUtil;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

/**
 * @author oszhugc
 * @Date 2019\5\30 0030 23:08
 **/
@ChannelHandler.Sharable
public class QuiteGroupRequestHandler extends SimpleChannelInboundHandler<QuitGroupRequestPacket> {

    public static final QuiteGroupRequestHandler INSTANCE = new QuiteGroupRequestHandler();

    private QuiteGroupRequestHandler(){}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, QuitGroupRequestPacket requestPacket) throws Exception {
        //1.获取群对应channelgroup,然后将当前用户移除
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);
        channelGroup.remove(ctx.channel());

        //2.构造退群响应发送给客户端
        QuitGroupResponsePacket responsePacket = new QuitGroupResponsePacket();
        responsePacket.setGroupId(groupId);
        responsePacket.setSuccess(true);
        ctx.writeAndFlush(responsePacket);
    }
}

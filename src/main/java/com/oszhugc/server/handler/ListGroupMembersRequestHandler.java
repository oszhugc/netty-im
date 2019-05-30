package com.oszhugc.server.handler;

import com.oszhugc.protocol.request.ListGroupMembersRequestPacket;
import com.oszhugc.protocol.response.ListGroupMembersResponsePacket;
import com.oszhugc.session.Session;
import com.oszhugc.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;

import java.util.ArrayList;

/**
 * @author oszhugc
 * @Date 2019\5\30 0030 22:44
 **/
@ChannelHandler.Sharable
public class ListGroupMembersRequestHandler extends SimpleChannelInboundHandler<ListGroupMembersRequestPacket> {

    public static final ListGroupMembersRequestHandler INSTANCE = new ListGroupMembersRequestHandler();

    private ListGroupMembersRequestHandler(){}

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ListGroupMembersRequestPacket requestPacket) throws Exception {
        //1. 获取群的channelgroup
        String groupId = requestPacket.getGroupId();
        ChannelGroup channelGroup = SessionUtil.getChannelGroup(groupId);

        //2. 遍历群成员的channel,对应的session, 构造全成员信息
        ArrayList<Session> sessionArrayList = new ArrayList<>();
        for (Channel channel:channelGroup
             ) {
            Session session = SessionUtil.getSession(channel);
            sessionArrayList.add(session);
        }

        //3. 构造获取成员列表的响应写回客户端
        ListGroupMembersResponsePacket responsePacket = new ListGroupMembersResponsePacket();
        responsePacket.setGroupId(groupId);
        responsePacket.setSessionList(sessionArrayList);

        ctx.writeAndFlush(responsePacket);
    }
}

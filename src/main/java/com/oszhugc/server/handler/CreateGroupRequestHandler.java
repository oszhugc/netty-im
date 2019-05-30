package com.oszhugc.server.handler;

import com.oszhugc.protocol.request.CreateGroupRequestPacket;
import com.oszhugc.protocol.response.CreateGroupResponsePacket;
import com.oszhugc.util.IDUtil;
import com.oszhugc.util.SessionUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.DefaultChannelGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oszhugc
 * @Date 2019\5\30 0030 22:20
 **/
public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {

    public static final CreateGroupRequestHandler INSTANCE = new CreateGroupRequestHandler();

    private CreateGroupRequestHandler(){

    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) throws Exception {
        List<String> userIdList = createGroupRequestPacket.getUserIdList();

        ArrayList<String> userNameList = new ArrayList<>();
        //1.创建一个channel分组
        DefaultChannelGroup channelGroup = new DefaultChannelGroup(ctx.executor());
        //2.筛选出待加入群聊的用户的channel和userName
        for (String userId: userIdList
             ) {
            Channel channel = SessionUtil.getChannel(userId);
            if (channel != null){
                channelGroup.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }
        //3.创建群聊创建结果的响应
        String groupId = IDUtil.randomId();
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(groupId);
        createGroupResponsePacket.setUserNameList(userNameList);

        //4.给每个客户端发送拉群成功
        channelGroup.writeAndFlush(createGroupResponsePacket);

        System.out.println("群创建成功, id为" + groupId);
        System.out.println("群里面有: "+ userNameList);

        //5. 保存群组相关信息
        SessionUtil.bindChannelGroup(groupId,channelGroup);
    }
}

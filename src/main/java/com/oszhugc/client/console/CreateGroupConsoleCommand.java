package com.oszhugc.client.console;

import com.oszhugc.protocol.request.CreateGroupRequestPacket;
import io.netty.channel.Channel;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 22:36
 **/
public class CreateGroupConsoleCommand implements ConsoleCommand {

    private static final String  USER_ID_SPLITER  = ",";

    @Override
    public void exec(Scanner scanner, Channel channel) {
        CreateGroupRequestPacket createGroupRequestPacket = new CreateGroupRequestPacket();

        System.out.println("[拉人群聊]输入userId列表, userId之间英文逗号隔开:");
        String userIds = scanner.next();
        createGroupRequestPacket.setUserIdList(Arrays.asList(userIds.split(USER_ID_SPLITER)));
        channel.writeAndFlush(createGroupRequestPacket);
    }
}

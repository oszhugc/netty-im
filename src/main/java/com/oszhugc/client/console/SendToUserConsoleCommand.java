package com.oszhugc.client.console;

import com.oszhugc.protocol.request.MessageRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 23:05
 **/
public class SendToUserConsoleCommand implements ConsoleCommand {


    @Override
    public void exec(Scanner scanner, Channel channel) {
        System.out.println("发送消息给某个用户: ");

        String toUserId = scanner.next();
        String message = scanner.next();
        channel.writeAndFlush(new MessageRequestPacket(toUserId,message));
    }
}

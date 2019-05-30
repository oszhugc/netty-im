package com.oszhugc.client.console;

import com.oszhugc.protocol.request.LoginRequestPacket;
import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 22:56
 **/
public class LoginConsoleCommand implements ConsoleCommand {

    @Override
    public void exec(Scanner scanner, Channel channel) {
        LoginRequestPacket requestPacket = new LoginRequestPacket();

        System.out.println("输入用户名登录: ");
        requestPacket.setUserName(scanner.nextLine());
        requestPacket.setPassword("pwd");

        //发送登录数据包
        channel.writeAndFlush(requestPacket);
        waitForLoginResponse();
    }

    private void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){

        }
    }
}

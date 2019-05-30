package com.oszhugc.client.console;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author oszhugc
 * @Date 2019\5\29 0029 22:12
 **/
public interface ConsoleCommand {

    void exec(Scanner scanner, Channel channel);
}

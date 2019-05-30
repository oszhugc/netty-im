package com.oszhugc.server;

import com.oszhugc.codec.PacketCodecHandler;
import com.oszhugc.codec.Spliter;
import com.oszhugc.handler.IMIdleStateHandler;
import com.oszhugc.server.handler.AuthHandler;
import com.oszhugc.server.handler.HeartBeatRequestHandler;
import com.oszhugc.server.handler.IMHandler;
import com.oszhugc.server.handler.LoginRequestHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Date;


/**
 * @author oszhugc
 * @Date 2019\5\30 0030 22:16
 **/
public class NettyServer {

    private static final int PORT = 8000;

    public static void main(String[] args) {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        final ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(boosGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childOption(ChannelOption.TCP_NODELAY,true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();

                        //空闲检查
                        pipeline.addLast(new IMIdleStateHandler());
                        pipeline.addLast(new Spliter());
                        pipeline.addLast(PacketCodecHandler.INSTANCE);
                        pipeline.addLast(LoginRequestHandler.INSTANCE);
                        pipeline.addLast(HeartBeatRequestHandler.INSTANCE);
                        pipeline.addLast(AuthHandler.INSTANCE);
                        pipeline.addLast(IMHandler.INSTANCE);
                    }
                });

        bind(serverBootstrap,PORT);
    }

    private static void bind(final ServerBootstrap serverBootstrap,final int port){
        serverBootstrap.bind(port).addListener(future -> {
            if (future.isSuccess()){
                System.out.println(new Date() + ": 端口["+port+"]绑定成功!");
            }else {
                System.out.println("端口["+port+"]绑定失败!");
            }
        });
    }
}


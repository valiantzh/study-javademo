package com.study.netty.tcp.demo2.client;

import com.study.netty.tcp.demo2.client.echo.EchoHandler_2_0;
import com.study.netty.tcp.demo2.client.echo.EchoHandler_test;
import com.study.netty.tcp.demo2.server.encoder.EncoderHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author valiantzh
 * @version 1.0
 */
public class TcpClient_2_0 {
    private String ip;
    private int port;

    public TcpClient_2_0(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void init() throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group);
            bootstrap.channel(NioSocketChannel.class);
            bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
            bootstrap.handler(new ChannelInitializer() {
                @Override
                protected void initChannel(Channel ch) throws Exception {
                    ch.pipeline().addLast("logging", new LoggingHandler("DEBUG"));
                    ch.pipeline().addLast(new EncoderHandler());
                    ch.pipeline().addLast(new EchoHandler_2_0());

                }
            });
            bootstrap.remoteAddress(ip, port);
            ChannelFuture future = bootstrap.connect().sync();

            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully().sync();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new TcpClient_2_0("127.0.0.1", 10002).init();
    }
}

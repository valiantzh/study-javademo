package com.study.netty.tcp.demo3;

import com.study.netty.tcp.demo1.TcpServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 *
 *
 * telnet 127.0.0.1 12340
 *
 * @author valiantzh
 * @version 1.0
 */
public class DiscardServer {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 6000;
    /** 用于分配处理业务线程的线程组个数 */
    protected static final int BIZGROUPSIZE = 1; // 默认
    /** 业务出现线程大小 */
    protected static final int BIZTHREADSIZE = 4;
    /*
     * NioEventLoopGroup实际上就是个线程池,
     * NioEventLoopGroup在后台启动了n个NioEventLoop来处理Channel事件,
     * 每一个NioEventLoop负责处理m个Channel,
     * NioEventLoopGroup从NioEventLoop数组里挨个取出NioEventLoop来处理Channel
     */
    private static final EventLoopGroup bossGroup = new NioEventLoopGroup(BIZGROUPSIZE);
    private static final EventLoopGroup workerGroup = new NioEventLoopGroup(BIZTHREADSIZE);

    public static void run() throws Exception {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup);
        b.channel(NioServerSocketChannel.class);
        b.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(new LineBasedFrameDecoder(1024));
                pipeline.addLast(new StringDecoder());
                pipeline.addLast(new DiscardServerHandler());
            }
        });
        b.option(ChannelOption.SO_BACKLOG, 1024);//缓冲区
        b.childOption(ChannelOption.SO_KEEPALIVE, true);//ChannelOption对象设置TCP套接字的参数，非必须步骤

        //b.bind(IP, PORT).sync();
        ChannelFuture future = b.bind(PORT).sync();

        System.out.println("TCP服务器已启动,监听端口:"+PORT);
        future.channel().closeFuture().sync();//以异步的方式关闭端口
    }

    protected static void shutdown() {
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("启动TCP服务器...");
        DiscardServer.run();
        // TcpServer.shutdown();
    }
}

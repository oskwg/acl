package org.oskwork.acl;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import org.oskwork.acl.handler.InDataStream;

/**
 * acl server bootstrap class
 * @author fullee
 */
public class ZerverBootstrap {

    public static void main(String[] args) throws InterruptedException {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

       try {
           ServerBootstrap b = new ServerBootstrap();
           b.group(bossGroup, workerGroup)
                   .channel(NioServerSocketChannel.class)
                   .childHandler(new ChannelInitializer<SocketChannel>() {

                       @Override
                       protected void initChannel(SocketChannel socketChannel) throws Exception {
                           ChannelPipeline pipeline = socketChannel.pipeline();

                           pipeline.addLast(new ChunkedWriteHandler());
//                           pipeline.addLast(new StringEncoder());
                           pipeline.addLast(new InDataStream());
                       }
                   })
                   .option(ChannelOption.SO_BACKLOG, 128)
                   .handler(new LoggingHandler())
                   .childOption(ChannelOption.SO_KEEPALIVE, true);

           ChannelFuture f = b.bind(1223).sync();
           f.channel().closeFuture().sync();
       } finally {
           workerGroup.shutdownGracefully();
           bossGroup.shutdownGracefully();
       }
    }

}

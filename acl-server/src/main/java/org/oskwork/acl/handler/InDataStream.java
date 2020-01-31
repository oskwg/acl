package org.oskwork.acl.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.nio.charset.Charset;

/**
 * client --> auth --> 10s keep心跳
 */
public class InDataStream extends SimpleChannelInboundHandler<Object> {

    static final ChannelGroup httpClient = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    static final ChannelGroup aclClient = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        System.out.println(msg);

        ByteBuf msg1 = (ByteBuf) msg;

        System.out.println(msg1.toString(Charset.defaultCharset()));;

        if (httpClient.contains(ctx.channel())) {
            aclClient.writeAndFlush(msg);
        } else {
            httpClient.writeAndFlush(msg);
        }

        ReferenceCountUtil.release(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("链接成功" + ctx.channel().remoteAddress());

//        if (ctx.channel().remoteAddress().toString().contains("1.9")) {
//
//        }

        if (ctx.channel().remoteAddress().toString().contains("1.12")) {
            aclClient.add(ctx.channel());
        }else{
            httpClient.add(ctx.channel());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        if (ctx.channel().remoteAddress().toString().contains("1.9")) {
            httpClient.remove(ctx.channel());
        }

        if (ctx.channel().remoteAddress().toString().contains("1.12")) {
            aclClient.remove(ctx.channel());
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}

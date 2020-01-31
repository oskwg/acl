package org.oskwork.acl.batman.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class OnBatmanHandler extends SimpleChannelInboundHandler<String> {

    private String formRemoveData;
    private ChannelHandlerContext gatewayCtx;

    public OnBatmanHandler(String formRemoveData, ChannelHandlerContext gatewayCtx) {
        this.formRemoveData = formRemoveData;
        this.gatewayCtx = gatewayCtx;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(formRemoveData);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        gatewayCtx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}

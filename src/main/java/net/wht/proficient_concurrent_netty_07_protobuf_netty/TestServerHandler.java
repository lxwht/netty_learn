package net.wht.proficient_concurrent_netty_07_protobuf_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.wht.proficient_concurrent_netty_07_protobuf_netty.MyDataInfo.Person;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {
		System.out.println(msg.getName() + "," + msg.getAge() + "," + msg.getAddress());
	}

}

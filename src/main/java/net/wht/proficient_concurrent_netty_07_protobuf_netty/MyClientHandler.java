package net.wht.proficient_concurrent_netty_07_protobuf_netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.wht.proficient_concurrent_netty_07_protobuf_netty.MyDataInfo.Person;

public class MyClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {
		
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		Channel channel = ctx.channel();
		MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("吴海涛").setAge(28).setAddress("汕头").build();
		channel.writeAndFlush(person);
	}
	
	

}

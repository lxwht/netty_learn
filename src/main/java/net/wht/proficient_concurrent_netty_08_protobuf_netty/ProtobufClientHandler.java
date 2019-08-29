package net.wht.proficient_concurrent_netty_08_protobuf_netty;

import java.util.Random;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.wht.proficient_concurrent_netty_08_protobuf_netty.ProgramLanguage.MyLanguage;

public class ProtobufClientHandler extends SimpleChannelInboundHandler<ProgramLanguage.MyLanguage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, MyLanguage msg) throws Exception {
		
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		int random = new Random().nextInt(3);
		ProgramLanguage.MyLanguage myLanguage = null;
		if(random == 0) {
			myLanguage = ProgramLanguage.MyLanguage.newBuilder()
					.setLanguageType(ProgramLanguage.MyLanguage.languageType.Java)
					.setJava( ProgramLanguage.Java.newBuilder().setName("java").setVal("backEnd").build())
					.build();
		} else if(random == 1) {
			myLanguage = ProgramLanguage.MyLanguage.newBuilder()
					.setLanguageType(ProgramLanguage.MyLanguage.languageType.Sql)
					.setSql(ProgramLanguage.Sql.newBuilder().setName("sql").setVal("database").build())
					.build();
		} else {
			myLanguage = ProgramLanguage.MyLanguage.newBuilder()
					.setLanguageType(ProgramLanguage.MyLanguage.languageType.Js)
					.setJs( ProgramLanguage.Js.newBuilder().setName("js").setVal("frontEnd").build())
					.build();
		}
		
		Channel channel = ctx.channel();
		channel.writeAndFlush(myLanguage);
	}

}

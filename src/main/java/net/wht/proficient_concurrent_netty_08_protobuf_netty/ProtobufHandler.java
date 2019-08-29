package net.wht.proficient_concurrent_netty_08_protobuf_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.wht.proficient_concurrent_netty_08_protobuf_netty.ProgramLanguage.MyLanguage;

public class ProtobufHandler extends SimpleChannelInboundHandler<ProgramLanguage.MyLanguage> {

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, MyLanguage msg) throws Exception {
		
		if(msg.getLanguageType() == MyLanguage.languageType.Java) {
			ProgramLanguage.Java java = msg.getJava();
			System.out.println(java.getName() + "," + java.getVal());
		} else if(msg.getLanguageType() == MyLanguage.languageType.Sql) {
			ProgramLanguage.Sql sql = msg.getSql();
			System.out.println(sql.getName() + "," + sql.getVal());
		} else {
			ProgramLanguage.Js js = msg.getJs();
			System.out.println(js.getName() + "," + js.getVal());
		}
	}

}

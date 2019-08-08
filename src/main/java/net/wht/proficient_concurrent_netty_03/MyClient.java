package net.wht.proficient_concurrent_netty_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {

	public static void main(String[] args) throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		
		try {
			Bootstrap bootstrap = new Bootstrap();
			bootstrap.group(group).channel(NioSocketChannel.class).handler(new MyClientInitializer());
			Channel channel = bootstrap.connect("", 8899).sync().channel();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			for(;;) {
				channel.writeAndFlush(br.readLine() + "\r\n");
			}
		} finally {
			group.shutdownGracefully();
		}
	}
}

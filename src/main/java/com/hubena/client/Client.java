package com.hubena.client;

import org.apache.log4j.Logger;

import com.hubena.entity.RequestStudent;
import com.hubena.util.JsonUtils;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class Client {
	private static final Logger logger = Logger.getLogger(Client.class);
    public static void main(String[] args) throws InterruptedException {
    	logger.debug("Client log4j========================");
    	//准备json测试数据
    	RequestStudent student = new RequestStudent();
    	student.setName("小明");
    	student.setAge(30);
    	
    	String json = JsonUtils.objectToJsonString(student);
    	System.out.println("json:" + json);
    	
        EventLoopGroup workerGroup = new NioEventLoopGroup();  
        Bootstrap bootstrap = new Bootstrap();  
        bootstrap.group(workerGroup)  
                .channel(NioSocketChannel.class)  
                .handler(new ChannelInitializer<SocketChannel>() {  
                    @Override  
                    protected void initChannel(SocketChannel socketChannel) throws Exception {  
                        socketChannel.pipeline().addLast(new ClientHandler());  
                    } 
                });  
        ChannelFuture future = bootstrap.connect("127.0.0.1", 8379).sync();  
        
        future.channel().writeAndFlush(Unpooled.copiedBuffer(json.getBytes()));  
//        future.channel().writeAndFlush("{a:{b:c.}");  
        future.channel().closeFuture().sync();  
        workerGroup.shutdownGracefully();  
    }  
    
    
}

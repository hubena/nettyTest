package client;

import java.util.ArrayList;
import java.util.List;
import entity.Student;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import util.JsonUtils;

public class Client {
    public static void main(String[] args) throws InterruptedException {
    	//准备json测试数据
    	Student student = new Student();
    	List<String> list = new ArrayList<String>();
    	list.add("朝鲜")	;
    	list.add("巴基斯坦");
    	student.setName("中国");
    	student.setAge(5000);
    	student.setFriends(list);
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

package com.hubena.server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hubena.controller.StudentController;
import com.hubena.entity.PageData;
import com.hubena.util.JsonUtils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class ServerHandler  extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(ServerHandler.class);
  
    @Override  
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {  
    		System.out.println("---------收到请求----------");
    		logger.debug("ServerHandler启动了");
    		
            ByteBuf buf = (ByteBuf)msg;  
            byte[] data = new byte[buf.readableBytes()];  
            buf.readBytes(data);  
            String request = new String(data, "utf-8");  
    		
    		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    		StudentController studentController = (StudentController) context.getBean("studentController");
    		PageData pageData = studentController.queryList(ctx, request);
    		
            //转换为Json并输出
            String json = JsonUtils.objectToJsonString(pageData);
            ctx.writeAndFlush(Unpooled.copiedBuffer(json.getBytes()));
    		
           /* //do something msg  
            ByteBuf buf = (ByteBuf)msg;  
            byte[] data = new byte[buf.readableBytes()];  
            buf.readBytes(data);  
            String request = new String(data, "utf-8");  
            System.out.println("Server: " + request);  
            //将取到的值转换为Object
            List<Student> genericity = JsonUtils.parseToObject(request, List.class);
            //打印取到的值String并赋值
            System.out.println(genericity);
            genericity.remove(0);
            
            //转换为Json并输出
            String json = JsonUtils.objectToJsonString(genericity);
            
            ctx.writeAndFlush(Unpooled.copiedBuffer(json.getBytes()));  
            //.addListener(ChannelFutureListener.CLOSE);  
              
            System.out.println("-----------输出请求----------");*/
    }  
  
    @Override  
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {  
        cause.printStackTrace();  
        ctx.close();  
    }  
  
} 
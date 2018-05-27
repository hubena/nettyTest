/**
 * 
 */
package client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import entity.Genericity;
import entity.PageData;
import entity.Student;
import util.JsonUtils;

/**
 * 简单客户端Socket请求
 * @author 曾谢波
 * @since 2018年5月25日下午10:39:50
 */
public class SimpleSocketClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
    	Student student = new Student();
    	PageData pageData = new
    	
    	String sendMessage = JsonUtils.objectToJsonString();;
		String receiveMessage = "";
		int port = 8379;
		String host = "127.0.0.1";
		Socket socket = new Socket(host, port);
		System.out.println("----------发出请求-------------");
		
		//输出流输出数据
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(sendMessage.getBytes());
		outputStream.flush();
//		outputStream.close();//直接关闭输出流会关闭socket
		socket.shutdownOutput();//关闭输出流但并不关闭socket
		
		//输入流输入数据
		InputStream inputStream = socket.getInputStream();
		byte[] middle = new byte[10000];
		System.out.println("-------收到请求------------");
		while ((inputStream.read(middle)) != -1) {
			receiveMessage += new String(middle);
			System.out.println("millle:" + new String(middle));
		}
		
		
		List<Student> student2 = JSON.parseObject(receiveMessage, new TypeReference<List<Student>>() {});
		outputStream.close();
		inputStream.close();
		socket.close();
		
		//测试泛型数据
		
	}
	
	public static PageData () {
		
	}
}

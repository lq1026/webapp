package com.socket.test2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
   public static void main(String[] args) {
	Socket clientSocket=null;
	PrintWriter out = null;
	try {
		clientSocket = new Socket("127.0.0.1",8066);
		out = new PrintWriter(clientSocket.getOutputStream());
		String msg = "小狗";
		out.print(msg);
		out.flush();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(out!=null) {
			out.close();
		}
		if(clientSocket!=null) {
			try {
				clientSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
    
}
}

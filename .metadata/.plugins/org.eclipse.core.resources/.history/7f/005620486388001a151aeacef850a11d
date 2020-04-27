package com.socket.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * @author moon
 * socket服务端
 */
public class Server {
     public static void main(String[] args) {
    	 System.out.println("服务端正在运行");
    	 ServerSocket serverSocket = null;
    	 BufferedReader reader = null;
    	 Socket clientSocket = null;
    	 
		  try {
			 serverSocket = new ServerSocket(8066);
			while(true) {
			    clientSocket = serverSocket.accept();
			    reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				String msgFromClient;
				while((msgFromClient = reader.readLine())!=null) {
					System.out.println(msgFromClient);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(clientSocket!=null) {
				try {
					clientSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(serverSocket!=null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

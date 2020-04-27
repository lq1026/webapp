package com.webservice.server;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
/**
 * jdk方式开发webservice服务端,用Wsimport命令生成客户端；生成客户端直接调用客户端，但是一些关键元素的代码写死到生成代码中，不方便维护，仅仅用于测试
 * Wsimport仅支持SOAP1.1客户端的生成
 * @author moon
 *
 */
@WebService
public class Test {
	
	@WebMethod
     public int squared(int x) {
    	int result = x*x;
    	System.out.println("求平方"+x+"-----"+result);
    	return result;
     }
	
	public static void main(String[] args) {
		//发布网络服务端点
		Endpoint.publish("http://localhost:8066/testservice", new Test());
		
	}
}
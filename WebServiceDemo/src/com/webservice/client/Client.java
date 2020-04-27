package com.webservice.client;

public class Client {
    
    public static void main(String[] args) {
        Test test = new TestService().getTestPort();
        System.out.println(test.squared(2));
	}
}

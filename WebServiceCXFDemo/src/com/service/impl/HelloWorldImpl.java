package com.service.impl;

import com.service.IHelloWorld;

public class HelloWorldImpl implements IHelloWorld {

	@Override
	public String sayHello(String text) {
		return "hello:"+text;
	}

}

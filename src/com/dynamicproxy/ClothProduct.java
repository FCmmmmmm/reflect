package com.dynamicproxy;

import org.junit.Test;

interface ClothFactory{
	void productCloth();
}

class NikeClothFactory implements ClothFactory{

	@Override
	public void productCloth() {
		// TODO Auto-generated method stub
		System.out.println("Nike工厂生产衣服");
	}
	
}

class ProxyFactory implements ClothFactory{
	private ClothFactory cf;
	
	public ProxyFactory(ClothFactory cf) {
		this.cf=cf;
	}
	
	@Override
	public void productCloth() {
		System.out.println("静态代理已经开始执行");
		cf.productCloth();
	}
	
}

public class ClothProduct {
		@Test
		public void dome() {
			NikeClothFactory nikeClothFactory=new NikeClothFactory();
			ProxyFactory proxyFactory=new ProxyFactory(nikeClothFactory);
			proxyFactory.productCloth();
		}
}

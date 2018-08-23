package com.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

interface SubJect{
	void action();
}

class SubJectRe implements SubJect{
	@Override
	public void action() {
		System.out.println("我是被代理的子类！！！");
	}
}

class Hander implements InvocationHandler{
	Object obj;//
	//实例化被代理对象 返回一个代理类的代理对象
	public Object bind(Object object) {
		this.obj=object;
		 return Proxy.newProxyInstance(obj.getClass().getClassLoader(), 
				 obj.getClass().getInterfaces(), this);	
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnVal=method.invoke(obj, args);
		return returnVal;
	}
}

public class RealSubJect  {
	 @Test
	 public void dose() {
		 SubJectRe real=new SubJectRe();
		 Hander hander=new Hander();
		 //调用bind返回代理类对象
		 Object object=hander.bind(real);
		 SubJect subJect=(SubJect)object;
		 subJect.action();
	 }
}

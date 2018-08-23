package com.testaop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.sun.org.apache.bcel.internal.generic.NEW;

interface Human {
	void info();

	void fly();

}

class SuperMan implements Human {

	@Override
	public void info() {
		System.out.println("SUPER MAN GO!!!!");
	}

	@Override
	public void fly() {
		System.out.println("SUPER MAN FLY");
	}

}

class InvocationHander implements InvocationHandler {

	private Object obj;

	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		ManUtils mUtils = new ManUtils();
		mUtils.method1();
		Object returnInvocation = method.invoke(obj, args);
		mUtils.method2();
		return returnInvocation;
	}

}

class ManUtils {
	public void method1() {
		System.out.println("method01");
	}

	public void method2() {
		System.out.println("method02");
	}

}

// 动态代理类？
class MyProxy {
	public static Object getProxy(Object object) {
		InvocationHander invocationHander = new InvocationHander();
		invocationHander.setObj(object);
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(),
				invocationHander);
	}
}

public class TestAop {
	public static void main(String[] args) {
		SuperMan superMan = new SuperMan();
		Object object = MyProxy.getProxy(superMan);
		Human human=(Human)object;
		human.info();
	}
}

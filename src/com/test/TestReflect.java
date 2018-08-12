package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.People;

public class TestReflect {
	@Test
	public void dos() {
		Class<People> pClass = People.class;
		People p = null;
		// 创建对应的运行时类
		try {
			p = pClass.newInstance();
			//获取所有属性
			Field field=pClass.getDeclaredField("name");
			//强制可访问
			field.setAccessible(true);
			field.set(p, "川哥");
			
			//获取public修饰的方法 
			Method method=pClass.getMethod("show");
			//激活一次
			method.invoke(p);
			
			Method method2=pClass.getDeclaredMethod("display", String.class);
			method2.invoke(p, "我爱你");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(p.toString());
	}
}

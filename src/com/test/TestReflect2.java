package com.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import com.People;

public class TestReflect2 {
	@Test
	public void dos() {
		try {
			Class<People> pClass = (Class<People>) Class.forName("com.People");
			People people = new People();
			Class<People> class1 = (Class<People>) people.getClass();
			System.out.println(people);
			People people2 = class1.newInstance();
			System.out.println(people2);
			People people3 = pClass.newInstance();
			System.out.println(people3);

			ClassLoader loader = this.getClass().getClassLoader();
			Class<People> class2 = (Class<People>) loader.loadClass("com.People");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

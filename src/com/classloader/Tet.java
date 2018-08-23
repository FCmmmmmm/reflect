package com.classloader;

import java.lang.reflect.Constructor;
import java.util.List;

import com.People;

public class Tet {
	
	public static void main(String[] args) throws Exception {
		 Class class1= Class.forName("com.People");
		 
		 Constructor [] constructors=class1.getDeclaredConstructors();
		 for (Constructor constructor : constructors) {
			System.out.println(constructor);
		}
		 
		 
		People people=new People();
		Class class2=people.getClass();
		System.out.println(class2.getSuperclass());
		
		
		
	}
	
	
	
}

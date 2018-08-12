package com;

public class People {
	public String name;
	private String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "People [name=" + name + ", desc=" + desc + "]";
	}
	public void show() {
		System.out.println("People [name=" + name + ", desc=" + desc + "]");
	}
	public void display(String s) {
		System.out.println(s);
	}
	}

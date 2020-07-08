package com.hope.firstsb.domain.vo;

public class User2{
	private String name;
	private int id;
	private int age;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"User2{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}

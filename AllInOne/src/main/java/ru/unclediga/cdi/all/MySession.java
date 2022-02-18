package ru.unclediga.cdi.all;

public class MySession {
	public String name;

	MySession(String connName){
		name = connName + ":Sess:" + this.hashCode();
        System.out.println("Init new Session  [" + name + "]");

	}

	public void close(){
		System.out.println("Close session [" + name + "]");
	}

	public String execQuery(){
		return "Q from [" + name + "]";
	}
}
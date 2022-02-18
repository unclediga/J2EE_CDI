package ru.unclediga.cdi.all;

public class MyServer {
	public String name;

	MyServer(String name){
		this.name = "Serv(name="+ name + "):" + this.hashCode();
		System.out.println("Init server [" + name + "]");
	}

	public MyConnection getConnection(){
		System.out.println("Create new Connection for server [" + name + "]");
		return new MyConnection(name);
	}

	public void close(){
		System.out.println("Close server [" + name + "]");
	}
}
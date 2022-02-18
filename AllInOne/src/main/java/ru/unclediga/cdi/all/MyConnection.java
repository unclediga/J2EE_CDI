package ru.unclediga.cdi.all;

public class MyConnection {
	public String name;

	// MyConnection(){
	// 	name = "empty conn";
	// }

	MyConnection(String serverName){
		name = serverName + ":Conn:" + this.hashCode();
	}

	public MySession getSession(){
		System.out.println("Create new Session for conn [" + name + "]");
		return new MySession(name);
	}

	public void close(){
		System.out.println("Close connection [" + name + "]");
	}

}
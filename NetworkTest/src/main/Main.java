package main;

import com.esotericsoftware.minlog.Log;

import myclient.MyClient;
import myserver.MyServer;

public class Main {
	public static void main(String []args) throws InterruptedException{
		Log.set(Log.LEVEL_INFO);
		MyServer server=new MyServer(55555,55556);
		MyClient client=new MyClient(55555, 55556, 5000);
		server.startServer();
		client.connect("127.0.0.1");
		Thread.sleep(5000);
		client.disconnect();
		server.stopServer();
	}
}

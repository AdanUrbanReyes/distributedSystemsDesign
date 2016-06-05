package myserver;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import networkClasses.LoginRequest;
import networkClasses.LoginResponse;

public class MyServer {
	private int TCP_PORT,UDP_PORT;
	private Server server;
	private Kryo kryo;
	public MyServer(int tcp,int udp){
		//Log.set(Log.LEVEL_DEBUG);
		TCP_PORT=tcp;
		UDP_PORT=udp;
		server=new Server();
		kryo=server.getKryo();
		registerKryoClasses();
	}
	public void startServer(){
		Log.info("Server started");
		server.start();
		try {
			server.bind(TCP_PORT, UDP_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		server.addListener(new MyServerListener());
	}
	public void stopServer(){
		Log.info("Server stoped");
		server.stop();
	}
	public void registerKryoClasses(){
		kryo.register(LoginRequest.class);
		kryo.register(LoginResponse.class);		
		kryo.register(LinkedList.class);
		kryo.register(Graphics.class);
	}
}

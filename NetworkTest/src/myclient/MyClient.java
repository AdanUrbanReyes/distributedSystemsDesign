package myclient;

import java.awt.Graphics;
import java.io.IOException;
import java.util.LinkedList;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.minlog.Log;

import networkClasses.LoginRequest;
import networkClasses.LoginResponse;

public class MyClient {
	private int TCP_PORT,UDP_PORT,TIMEOUT;
	private Client client;
	private Kryo kryo;
	public MyClient(int tcp,int udp,int timeout){
		this.TCP_PORT=tcp;
		this.UDP_PORT=udp;
		this.TIMEOUT=timeout;
		client=new Client();
		kryo=client.getKryo();
		registerKryoClasses();
	}
	public void connect(String host){
		Log.info("Client connected");
		client.start();
		try {
			client.connect(TIMEOUT,host,TCP_PORT, UDP_PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
		client.addListener(new MyClientListener());
		LinkedList<LoginRequest> requests=new LinkedList<LoginRequest>();
		int i;
		for(i=0;i<11;i++){
			LoginRequest request=new LoginRequest();
			request.setUsername("User"+i);
			request.setPassword("Password"+i);
			requests.add(request);
		}
		client.sendTCP(requests);
	}
	public void disconnect(){
		Log.info("Client disconnected");
		client.stop();
	}
	public void registerKryoClasses(){
		kryo.register(LoginRequest.class);
		kryo.register(LoginResponse.class);		
		kryo.register(LinkedList.class);
		kryo.register(Graphics.class);
	}
}

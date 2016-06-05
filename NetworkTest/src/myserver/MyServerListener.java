package myserver;


import java.util.LinkedList;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

import networkClasses.LoginRequest;
import networkClasses.LoginResponse;

public class MyServerListener extends Listener{
	public void received(Connection connection,Object object){
		if(object instanceof LinkedList){
			Log.info("Server received LinkedList");
			@SuppressWarnings("unchecked")
			LinkedList<LoginRequest> requests=(LinkedList<LoginRequest>)object;
			LinkedList<LoginResponse> responses=new LinkedList<LoginResponse>();
			Log.info("Server sizeof LinkedList"+requests.size());
			int i;
			for(i=0;i<requests.size();i++){
				LoginResponse response=new LoginResponse();
				Log.info("Check user: "+requests.get(i).getUsername());
				if(requests.get(i).getUsername().equals("User") && requests.get(i).getPassword().equals("Password")){
					response.setColorRGB(i);
					response.setResponseText("Welcome "+requests.get(i).getUsername());
					response.setLogin(true);
					
				}else{
					response.setColorRGB(i);
					response.setResponseText("Error user or password invalidate");
					response.setLogin(false);
				}
				responses.add(response);
			}

			connection.sendTCP(responses);
		}
	}
}

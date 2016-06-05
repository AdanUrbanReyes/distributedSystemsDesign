package myclient;

import java.util.LinkedList;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;

import networkClasses.LoginResponse;

public class MyClientListener extends Listener{
	public void received(Connection connection,Object object){
		if(object instanceof LinkedList){
			@SuppressWarnings("unchecked")
			LinkedList<LoginResponse> responses=(LinkedList<LoginResponse>)object;
			int i;
			for(i=0;i<responses.size();i++){
				Log.info(responses.get(i).getResponseText()+" isLogin="+responses.get(i).isLogin()+" color="+responses.get(i).getColorRGB());	
			}
		}
	}

}

package server;

import java.net.DatagramSocket;
import java.net.InetAddress;  

public class GetIp{
	public String getIpAddress(){
		String str = "NULL";
		try{
			final DatagramSocket ping_socket = new DatagramSocket();
			ping_socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
			str = ping_socket.getLocalAddress().getHostAddress();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return str;
	}
}

package server;


import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Server{
    public Server(){
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
            System.out.println("Server Runs on PORT 8080");
	        System.out.println("Server IP: "+ getIpAddress());
            ServerSocket server= new ServerSocket(8080);
            Socket socket = server.accept();
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            int len = dis.readInt();
            byte[] data = new byte[len];
            dis.readFully(data);
            String filename = "socket-share" + dtf.format(LocalDateTime.now()) + ".dat";
            FileOutputStream fos = new FileOutputStream(filename);
            fos.write(data);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
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

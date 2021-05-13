package server;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.zip.DataFormatException;

public class Server{
    public Server(){
        try{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");            System.out.println("Server Runs on PORT 8080");
	        System.out.println("Server IP: "+ new GetIp().getIpAddress());
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
            System.out.println(e);
        }
    }
}

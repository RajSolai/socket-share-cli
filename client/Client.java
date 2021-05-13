package client;

import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.file.Files;

public class Client{
    public Client(){
        try{
            String path = null;
	        String ip = null;
            Scanner inputscanner = new Scanner(System.in);
            System.out.println("Enter the file path to Transfer:");
            path = inputscanner.nextLine();
	        System.out.println("Enter the IP address of the Revicer");
	        ip = inputscanner.nextLine();
            Socket soc = new Socket(ip,8080);
            System.out.println("READY TO SEND FILE");
            File filetoSend = new File(path);
            byte[] bytes = Files.readAllBytes(filetoSend.toPath());
            DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
            dos.writeInt(bytes.length);
            dos.write(bytes);
            System.out.println("File sent to successfully !.");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

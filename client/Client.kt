package client;


import java.io.DataOutputStream;
import java.io.File;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public class Client{
    public Client(){
        try{
            String path;
	        String ip;
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
            System.out.println(e.getMessage());
        }
    }
}

package pract2;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteDayTime {
    
    public static void main(String[] args) throws UnknownHostException, IOException{
    
        Socket s = new Socket("zoltar.redes.upv.es", 13);
        System.out.println(s.isConnected());
        Scanner scan = new Scanner(s.getInputStream());
        
        while(scan.hasNextLine()) {
        
            System.out.println(scan.nextLine());
            
        }
        
        s.close();
        scan.close();
        
        
    }
    
    
}

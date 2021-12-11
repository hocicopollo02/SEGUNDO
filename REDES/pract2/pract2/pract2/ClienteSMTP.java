package pract2;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ClienteSMTP {
    
    public static void main(String[] args) throws UnknownHostException, IOException{
        
        System.setProperty("line-property", "\r\n");
        
        Socket s = new Socket("smtp.upv.es", 25);
        Scanner scan = new Scanner(s.getInputStream());
        System.out.println(scan.nextLine());
        
        PrintWriter printer = new PrintWriter(s.getOutputStream(), true);
        printer.println("HELO rdc05.redes.upv.es");
        System.out.println(scan.nextLine());
        
        s.close();
        printer.close();
        scan.close();
        
    }
    
}

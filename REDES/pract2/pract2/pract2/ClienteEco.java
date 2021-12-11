package pract2;


import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ClienteEco {
    
    public static void main(String[] args) throws UnknownHostException, IOException{
    
        Socket s = new Socket("zoltar.redes.upv.es", 7);
        PrintWriter printer = new PrintWriter(s.getOutputStream(), true);
        Scanner scan = new Scanner(s.getInputStream());
        
        printer.println("Hola mundo");
        System.out.println(scan.nextLine());        
        
    }
    
}

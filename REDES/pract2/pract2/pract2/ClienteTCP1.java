package pract2;
import java.io.*;
import java.net.*;

public class ClienteTCP1 {
    public static void main(String[] args) throws UnknownHostException, IOException {

        try {
            Socket s = new Socket("www.upv.es", 80);

            if (s.isConnected()) { 

                System.out.println("Conectado!");
                System.out.println(s.getPort());
                System.out.println(s.getLocalPort());
                System.out.println(s.getLocalAddress());
                System.out.println(s.getLocalSocketAddress());
                s.close();

            } else { System.out.println("No es posible realizar la conexion"); } 

        }catch(NoRouteToHostException e) {
            
            System.out.println("Numero de puerto erroneo");

        }catch(UnknownHostException e) {

            System.out.println("Nombre de servidor desconocido");

        }
    }
}
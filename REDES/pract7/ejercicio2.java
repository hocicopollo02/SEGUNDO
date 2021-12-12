import java.net.*;
import java.io.*;

public class ejercicio2{

	public static void main(String[] a) {
		
		try{
			DatagramSocket datagram = new DatagramSocket();
			int port = datagram.getLocalPort();
			System.out.println("El puerto elegido por el sistema es: " + port);

		} catch(SocketException e) { System.out.println("Error al crear el DatagramSocket. "); }

	}
}

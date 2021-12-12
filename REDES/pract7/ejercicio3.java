import java.net.*;
import java.io.*;

public class ejercicio3 {

	public static void main(String[] a) {
		
		int port = 7777;
		String mensaje = "Haters gonna hate - Martinez";

		try{
			DatagramSocket datagram = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, InetAddress.getByName("rdc00.redes.upv.es"), port);
			datagram.send(packet); // Envía el packet al puerto 
			datagram.setSoTimeout(4000);
			datagram.close();

			
		} catch(IOException e) { System.out.println(e); }

	}
}

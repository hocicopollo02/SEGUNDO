import java.net.*;
import java.io.*;

public class ejercicio4 {

	public static void main(String[] a) {
		
		int port = 7777;
		String mensaje = "CR7";

		try{
			DatagramSocket datagram = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, InetAddress.getByName("localhost"), port);
			datagram.send(packet); // Envía el packet al puerto 
			datagram.setSoTimeout(4000);
			datagram.receive(packet);
			String recibido = new String(packet.getData(), 0, packet.getLength());
			datagram.close();

			
		} catch(IOException e) { System.out.println(e); }

	}
}

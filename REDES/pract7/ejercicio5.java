import java.util.Date;
import java.io.*;
import java.net.*;

public class ejercicio5  {

	static Date date = new Date();
	static String now = date.toString() + "\r\n";

	public static void main(String[] a) {
			try{

				DatagramSocket ds= new DatagramSocket(7777);
				DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
				ds.receive(p);
				p.setData(now.getBytes());
				p.setLength(now.getBytes().length);
				ds.send(p);
				System.out.println(now);

				
			} catch(IOException e) { System.out.println(e); }
		
	}

}

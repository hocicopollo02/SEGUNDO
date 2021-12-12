import java.net.*;
import java.io.*;

public class dnslookup{

	public static void main(String[] a) {
		
		try{
			InetAddress server = InetAddress.getByName(a[0]);
			String ip = server.toString();
			System.out.println(ip);

		} catch(UnknownHostException e) { System.out.println("Error al obtenerse la IP."); }

	}
}

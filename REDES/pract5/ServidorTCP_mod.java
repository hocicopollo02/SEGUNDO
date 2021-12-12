import java.net.*;
import java.io.*;
import java.util.*;

class ServidorTCP_mod {

	public static void main(String[] args) {
		
		try {
		
			ServerSocket ss = new ServerSocket(7777);
			while(true) {
				
				//Crea un Socket al establecer conexion y un Scanner que lee la primera linea del Scanner.	
				Socket s = ss.accept();
				System.out.println("Se ha conectado un cliente al servidor.\n");
				System.out.println("-----Socket-----");
				System.out.println("INET ADDRESS: " + s.getInetAddress());
				System.out.println("LOCAL PORT: " + s.getLocalPort());
				System.out.println("LOCAL ADDRESS" + s.getLocalAddress());
				System.out.println("PORT: " + s.getPort());
				System.out.println("-----ServerSocket------");
				System.out.println("INET ADDRESS" + ss.getInetAddress());
				System.out.println("LOCAL PORT: " + ss.getLocalPort());
				Scanner scanner = new Scanner(s.getInputStream());
				String linea = scanner.nextLine();

				//Crea el PrintWriter y le envia el contenido de s.
				PrintWriter printer = new PrintWriter(s.getOutputStream());
				printer.printf(linea);
				printer.flush();

				s.close();
			}
		}
		catch(IOException e) { System.out.println(e); }
	}	
}

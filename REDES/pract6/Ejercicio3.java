import java.util.*;
import java.net.*;
import java.io.*;

class Ejercicio3 extends Thread {

	static Socket socket;
	
	public static void main(String[] a) {
	
		
	}

	public void run() {
	
		try{
		
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			String lectura = scanner.nextLine();

			while(scanner.hasNext()) {
			
				while(!lectura.equalsIgnoreCase("quit")) {
				
					
				}

			}

		} catch (IOException e) {}
	}
}

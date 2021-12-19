import java.util.*;
import java.net.*;
import java.io.*;

class Ejercicio3 extends Thread {

	static Socket socket;

	public static void main(String[] a) throws UnknownHostException {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el nombre del host: ");
		String host = input.next();
		System.out.println("Introduce un numero de puerto: ");
		int port = input.nextInt();
		try {

			socket = new Socket(host, port);
			Ejercicio3 h = new Ejercicio3(socket);
			h.start();

		} catch(IOException e) { System.out.println(e); }

		input.close();
			

	}

	public Ejercicio3(Socket s){ this.socket = s; }

	public void run() {
	
		try{
		
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			String lectura = scanner.nextLine();

			while(scanner.hasNext() && !lectura.equalsIgnoreCase("quit")) {
			
				printer.printf(lectura);
				printer.flush();


			}

		} catch (IOException e) { System.out.println(e); }
	}
}

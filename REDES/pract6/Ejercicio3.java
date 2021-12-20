import java.util.*;
import java.net.*;
import java.io.*;

class Ejercicio3 extends Thread {

	Socket socket;

	public static void main(String[] a) throws UnknownHostException {
	
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el nombre del host: ");
		String host = input.next();
		System.out.println("Introduce un numero de puerto: ");
		int port = input.nextInt();
		try {

			Socket s = new Socket(host, port);
			Ejercicio3 h = new Ejercicio3(s);
			Ejercicio3 h1 = new Ejercicio3(s);
			h.start();
			h1.run2(s);

		} catch(IOException e) { System.out.println(e); }

		input.close();
			

	}

	public Ejercicio3(Socket s){ this.socket = s; }

	public void run() {
	
		try{
		
			Scanner scanner = new Scanner(socket.getInputStream());
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			String lectura = scanner.nextLine();

			while(scanner.hasNext()) {
			
				printer.printf(lectura);
				printer.flush();


			}

		} catch (IOException e) { System.out.println(e); }
	}

	public static void run2(Socket s) {


		try{

			String m = "";
			PrintWriter salida = new PrintWriter(s.getOutputStream());
			Scanner entrada = new Scanner(System.in);
			while(!entrada.nextLine().equals("quit")) {
				salida.println("\tUsuario: " + m);
			}
			salida.close();
			entrada.close();
		
		} catch (IOException e) { System.out.println(); }
	}
}

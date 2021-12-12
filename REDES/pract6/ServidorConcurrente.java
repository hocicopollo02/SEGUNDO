import java.util.*;
import java.net.*;
import java.io.*;

class ServidorConcurrente extends Thread {
	
	static Socket socket;

	public static void main(String[] a) throws UnknownHostException, IOException {
	
		int port = 7777;

		ServerSocket server = new ServerSocket(port);

		while(true) {
		
			socket = server.accept();
			ServidorConcurrente h = new ServidorConcurrente(socket);
			h.start();
		}

	}

	public ServidorConcurrente(Socket s) {
		
		socket = s;

	}

	public void run() {

		try{
	
			Scanner scan = new Scanner(socket.getInputStream());
			PrintWriter printer = new PrintWriter(socket.getOutputStream());
			String string = scan.nextLine();

			while(!string.equalsIgnoreCase("FIN")) {
		
				printer.println(string);
				printer.flush();
				string = scan.nextLine();
			} 
		
		} catch (IOException e) {}
	}
}

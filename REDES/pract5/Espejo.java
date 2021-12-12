import java.net.*;
import java.util.*;
import java.io.*;

public class Espejo {

	public static void main(String[] args) {
	
		try{
	
			ServerSocket server = new ServerSocket(8000);

			while(true) {
			
				Socket socket = server.accept();
				Scanner scanner = new Scanner(socket.getInputStream());
				PrintWriter printer = new PrintWriter(socket.getOutputStream());

				printer.printf("HTTP/1.0 200 OK \r\n");
				printer.printf("Content-Type: text/plain \r\n");
				printer.printf("\r\n");

				while(scanner.hasNextLine()) {
				
					printer.printf(scanner.nextLine());
					printer.flush();
				}
				socket.close();
			}	
			
		} catch(IOException e) { System.out.println(e); }
	}
}

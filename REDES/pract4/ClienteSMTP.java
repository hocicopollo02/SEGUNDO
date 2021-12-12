import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClienteSMTP {

        static void error(String cadena) {
		System.out.println(cadena);
		System.exit(0);
	}

	public static void main(String args[]) {
		try{
			System.setProperty ("line.separator", "\r\n");
			Socket s=new Socket("zoltar.redes.upv.es", 25);
			System.out.println("Conectado al servidor SMTP de zoltar");
			PrintWriter salida = new PrintWriter(s.getOutputStream());
			Scanner entrada=new Scanner(s.getInputStream());
			String respuesta = entrada.nextLine();
			System.out.println(respuesta);
			if (!respuesta.startsWith("220")) {error(respuesta);}

			salida.println("HELO [158.42.180.2");
			salida.flush();
			respuesta = entrada.nextLine();
			System.out.println(respuesta);
			if (!respuesta.startsWith("250")) {error(respuesta);}

			salida.println("MAIL FROM:<redes01@redes.upv.es> ");
			salida.flush();
			respuesta = entrada.nextLine();
			System.out.println(respuesta);
			if (!respuesta.startsWith("250")) {error(respuesta);}

			salida.println("RCPT TO:<redes02@redes.upv.es>");
			salida.flush();
			respuesta = entrada.nextLine();
			System.out.println(respuesta);
			if (!respuesta.startsWith("354")) {error(respuesta);}

			// **completar** 
			// Aqui van varios println con todo el correo 
			// electronico incluidas las cabeceras


			System.out.println("To: redes02@redes.upv.es");
			System.out.println("From: redes02<redes02@redes.upv.es>");
			System.out.println("Subject: asunto perro");
			System.out.println("");
			System.out.println("este es el mensaje perro");
			System.out.println("");
			
			salida.flush();
			respuesta = entrada.nextLine();
			System.out.println(respuesta);
			if (!respuesta.startsWith("250")) {error(respuesta);}

			salida.println("QUIT");
			salida.flush();
			respuesta = entrada.nextLine();
			System.out.println(respuesta);
			if (!respuesta.startsWith("221")) {error(respuesta);}

			s.close();
			System.out.println("Desconectado");

		} catch (UnknownHostException e) {
			System.out.println("Host desconocido");
			System.out.println(e);
		} catch (IOException e) {
			System.out.println("No se puede conectar");
			System.out.println(e);
		}
	}
}

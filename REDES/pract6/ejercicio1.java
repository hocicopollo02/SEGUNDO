import java.util.*;
import java.net.*;
import java.io.*;


class ejercicio1 extends Thread {

	String cliente;
	public ejercicio1(String s) {
	
		this.cliente = s;
	}

	public static void main(String[] a) {
		for (int i = 0; i < 3; i++ ) {
		
			ejercicio1 h = new ejercicio1("" +  i);
			h.start();
		
		}	
	}

	public void run() {
	
		for( int i = 0; i < 10; i++) {
		
			System.out.println("Ejecutando el hilo " + cliente + "...");
			try{ sleep(1000);} catch (InterruptedException e) {}
		}
	}

}

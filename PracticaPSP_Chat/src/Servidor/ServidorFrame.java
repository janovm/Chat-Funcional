package Servidor;


import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorFrame  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
			
		JPanel milamina= new JPanel();
		
		milamina.setLayout(new BorderLayout());
		
		areatexto=new JTextArea();
		
		milamina.add(areatexto,BorderLayout.CENTER);
		
		add(milamina);
		
		setVisible(true);
		
		Thread hilo= new Thread(this);
		
		hilo.start();
		
		}
	
	private	JTextArea areatexto;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket servidor = new ServerSocket(9999);
			
			while(true) {
							
				Socket socket = servidor.accept();
				
				DataInputStream flujoEntrada= new DataInputStream(socket.getInputStream());
				
				String mensaje= flujoEntrada.readUTF();
				
				areatexto.append("\n Jano: "+mensaje);
				
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

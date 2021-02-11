package Controlador;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
			
			String nick, ip, mensaje;
			
			Envio paqueteRecibido;
			
			while(true) {
							
				Socket socket = servidor.accept();
				
				ObjectInputStream paqueteDatos= new ObjectInputStream(socket.getInputStream());
				
				paqueteRecibido= (Envio) paqueteDatos.readObject();
				
				nick= paqueteRecibido.getNick();
				
				ip= paqueteRecibido.getIp();
				
				mensaje= paqueteRecibido.getMensaje();
				
				areatexto.append("\n "+ nick + ": " + mensaje);
				
				Socket envioCliente = new Socket(ip, 9090);
				
				ObjectOutputStream paqueteReenvio= new ObjectOutputStream(envioCliente.getOutputStream());
				
				paqueteReenvio.writeObject(paqueteRecibido);
				
				paqueteReenvio.close();
				
				envioCliente.close();
				
				socket.close();
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

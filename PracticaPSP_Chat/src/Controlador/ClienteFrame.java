package Controlador;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class ClienteFrame extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static private JTextField mensaje;
	static private JTextField nick;
	static private JTextField ip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
					
					ClienteFrame frame = new ClienteFrame();
					
					frame.setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClienteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 144);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mensaje = new JTextField();
		mensaje.setBounds(25, 66, 315, 20);
		contentPane.add(mensaje);
		mensaje.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					Socket socket = new Socket("10.10.200.46", 9999);
					
					Envio envio = new Envio();
					
					envio.setIp(ip.getText());
					
					envio.setMensaje(mensaje.getText());
					
					envio.setNick(nick.getText());
					
					ObjectOutputStream paqueteDatos= new ObjectOutputStream(socket.getOutputStream());
					
					paqueteDatos.writeObject(envio);
					
					
					socket.close();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setBounds(361, 64, 89, 23);
		contentPane.add(btnNewButton);
		
		nick = new JTextField();
		nick.setBounds(64, 19, 86, 20);
		contentPane.add(nick);
		nick.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("NICK");
		lblNewLabel.setBounds(25, 22, 46, 14);
		contentPane.add(lblNewLabel);
		
		ip = new JTextField();
		ip.setBounds(297, 19, 127, 20);
		contentPane.add(ip);
		ip.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("IP");
		lblNewLabel_1.setBounds(263, 22, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		Thread miHilo= new Thread(this);
		miHilo.start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ServerSocket recepcionCliente= new ServerSocket(9090);
			
			Socket cliente;
			
			Envio paqueteRecibido;
			
			while(true) {
				cliente=recepcionCliente.accept();
				
				ObjectInputStream flujoEntrada= new ObjectInputStream(cliente.getInputStream());
				
				paqueteRecibido= (Envio) flujoEntrada.readObject();
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Envio implements Serializable{
	
	private String nick;
	
	private String ip;
	
	private String mensaje;
	
	public String getNick() {
		return nick;
	}
	public String getIp() {
		return ip;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}

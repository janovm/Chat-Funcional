package Cliente;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClienteFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static private JTextField textField;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		textField = new JTextField();
		textField.setBounds(169, 109, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					Socket socket = new Socket("192.168.56.1", 9999);
					
					DataOutputStream flujoSalida = new DataOutputStream(socket.getOutputStream());
					 
					flujoSalida.writeUTF(textField.getText());
					
					flujoSalida.close();
					
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setBounds(166, 203, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}

package AESproject;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField;
	public JTextField textResult;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	AESAlgorithm aesAlgo;
	private byte[] keyValue= new byte[16];
	
	public Main() {
		aesAlgo=new AESAlgorithm(keyValue);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setBounds(25, 59, 289, 143);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textResult = new JTextField();
		textResult.setColumns(10);
		textResult.setBounds(392, 59, 289, 143);
		contentPane.add(textResult);
		
		JButton btnNewButton = new JButton("Encrypt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String plainText=textField.getText();
					String encryptedText=aesAlgo.encrypt(plainText);
					textResult.setText(encryptedText);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(217, 215, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Decrypt");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String encryptedText=textResult.getText();
					String plainText=aesAlgo.decrypt(encryptedText);
					textResult.setText(plainText);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(584, 215, 97, 25);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Enter simple text");
		lblNewLabel.setBounds(25, 25, 161, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblEncrypteddecryptedText = new JLabel("Encrypted/Decrypted Text");
		lblEncrypteddecryptedText.setBounds(392, 25, 161, 16);
		contentPane.add(lblEncrypteddecryptedText);
	}
}

package br.sc.senac.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class Principal {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(27, 38, 44));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(15, 76, 117));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo");
		lblNewLabel.setForeground(new Color(253, 203, 158));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(27, 38, 44));
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Acessar");
		btnNewButton.setBounds(59, 165, 111, 38);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setBounds(283, 165, 111, 38);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(59, 11, 335, 143);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Senha");
		lblNewLabel_2.setFont(new Font("Lucida Sans Unicode", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 78, 46, 14);
		panel_3.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 36, 315, 29);
		panel_3.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 103, 315, 29);
		panel_3.add(passwordField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 183, 194));
		panel_2.setBounds(10, 216, 414, 3);
		panel_1.add(panel_2);
	}
}

package ir.maktabSharif.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ir.maktabSharif.Controller.ContactRestful;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class AddContact extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldFamily;
	private JTextField textFieldMobile;
	private JTextField textField_3;
	private JTextField textFieldPhone;
	private JTextField textFieldEmail;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContact frame = new AddContact();
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
	public AddContact() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 0, 255, 261);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(22, 36, 223, 214);
		panel.add(panel_1);
		
		JLabel label = new JLabel("name : ");
		label.setBounds(10, 11, 46, 14);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("family :");
		label_1.setBounds(10, 43, 46, 14);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("mobile : ");
		label_2.setBounds(10, 75, 46, 14);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("phone : ");
		label_3.setBounds(10, 107, 46, 14);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("email : ");
		label_4.setBounds(10, 139, 46, 14);
		panel_1.add(label_4);
		
		textFieldName = new JTextField();
		textFieldName.setColumns(10);
		textFieldName.setBounds(66, 8, 150, 20);
		panel_1.add(textFieldName);
		
		textFieldFamily = new JTextField();
		textFieldFamily.setColumns(10);
		textFieldFamily.setBounds(66, 40, 150, 20);
		panel_1.add(textFieldFamily);
		
		textFieldMobile = new JTextField();
		textFieldMobile.setColumns(10);
		textFieldMobile.setBounds(66, 72, 150, 20);
		panel_1.add(textFieldMobile);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(66, 72, 86, 20);
		panel_1.add(textField_3);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(66, 104, 150, 20);
		panel_1.add(textFieldPhone);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(66, 136, 150, 20);
		panel_1.add(textFieldEmail);
		
		JButton button = new JButton("Save");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					URL url = new URL("http://localhost:8080/FinalProject_PhoneBookServer1/rest/contact");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setDoOutput(true);
					conn.setRequestMethod("POST");
					conn.setRequestProperty("Content-Type", "application/json");

					String input = "{\"family\":\" " + textFieldFamily.getText() + " \",\"name\":\" " + textFieldName.getText()
							+ " \" ," + " \"mobile\":\" " + textFieldMobile.getText() + " \",\"phone\":\" "
							+ textFieldPhone.getText() + " \"," + "\"email\":\" " + textFieldEmail.getText() + " \" }";

					OutputStream os = conn.getOutputStream();
					os.write(input.getBytes());

					if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
						JOptionPane.showMessageDialog(null, "Failed : HTTP code : " + conn.getResponseCode());
					}
					if (conn.getResponseCode() == 200) {
						JOptionPane.showMessageDialog(null, "your save is suessfully.");
					}

					os.flush();
					conn.disconnect();

				} catch (MalformedURLException e) {

					e.printStackTrace();

				} catch (IOException e) {

					e.printStackTrace();

				}
			}
			
		});
		button.setBounds(63, 170, 89, 23);
		panel_1.add(button);
		
		JLabel label_5 = new JLabel("Add Your Contact To List");
		label_5.setBounds(23, 11, 179, 14);
		panel.add(label_5);
	}

}

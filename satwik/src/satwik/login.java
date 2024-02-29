package satwik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frame;
	private JTextField t1;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 128, 64));
		frame.setBounds(100, 100, 507, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("login page with database");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel.setBounds(136, 21, 210, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton bt1 = new JButton("login");
		bt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=t1.getText();
				String password=p1.getText();
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/d6","root","mrec");
					PreparedStatement stn=con.prepareStatement("select name,password from users where name=? and password=?");
					stn.setString(1, name);
					stn.setString(2, password);
					ResultSet rs=stn.executeQuery();
					if(rs.next())
					{
						JOptionPane.showMessageDialog(bt1,"valid user");
					}
					else
					{
						JOptionPane.showMessageDialog(bt1,"invlid user");
					}
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bt1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		bt1.setBounds(203, 242, 89, 23);
		frame.getContentPane().add(bt1);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1.setBounds(56, 103, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_2.setBounds(56, 174, 74, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		t1 = new JTextField();
		t1.setBounds(191, 100, 86, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		p1 = new JPasswordField();
		p1.setBounds(191, 171, 86, 20);
		frame.getContentPane().add(p1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\online lab\\Desktop\\pexels-arindam-raha-2213575.jpg"));
		lblNewLabel_3.setBounds(0, 0, 491, 336);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(0, 0, 491, 336);
		frame.getContentPane().add(lblNewLabel_4);
	}
}

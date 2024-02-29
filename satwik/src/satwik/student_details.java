package satwik;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class student_details {

	private JFrame frame;
	private JTextField tb1;
	private JTextField tb2;
	private JTextField tb3;
	private JTextField tb4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student_details window = new student_details();
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
	public student_details() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 501, 380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Student Details");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(173, 11, 137, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_2.setBounds(92, 69, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_3.setBounds(92, 118, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setBounds(92, 168, 46, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Marks");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_5.setBounds(92, 221, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		tb1 = new JTextField();
		tb1.setBounds(202, 66, 86, 20);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		tb2 = new JTextField();
		tb2.setBounds(202, 115, 86, 20);
		frame.getContentPane().add(tb2);
		tb2.setColumns(10);
		
		tb3 = new JTextField();
		tb3.setBounds(202, 165, 86, 20);
		frame.getContentPane().add(tb3);
		tb3.setColumns(10);
		
		tb4 = new JTextField();
		tb4.setBounds(202, 218, 86, 20);
		frame.getContentPane().add(tb4);
		tb4.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=tb1.getText();
		        String Id=tb2.getText();
		        String Address=tb3.getText();
		        String Marks=tb4.getText();
		        int m=Integer.parseInt(Marks);
		        try {
		        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/d6","root","mrec");
		        	String q="insert into student2 values('"+Name+"','"+Id+"','"+m+"','"+Address+"')";
		        	Statement sta= con.createStatement();
		        	sta.executeUpdate(q);
		        	con.close();
		        	JOptionPane.showMessageDialog(btnNewButton,"successful");
		        	}
		        catch(SQLException e1)
		        {
		        	e1.printStackTrace();
		        }
		        
		
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton.setBounds(153, 265, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\online lab\\Desktop\\ec40a63727698bb2afaa84f2dca6de3e.jpg"));
		lblNewLabel.setBounds(0, 0, 485, 341);
		frame.getContentPane().add(lblNewLabel);
	}
}

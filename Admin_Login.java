package administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Login {

	public JFrame frame;
	private JTextField First_NamtextField;
	//database instance variable
	private String username="root";
	private String password="Nxumalo#1";
	private String url="jdbc:mysql://127.0.0.1:3306/login";
	//Interfaces
	private Connection connect;
	private PreparedStatement preparedS;
	private ResultSet set;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Login window = new Admin_Login();
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
	public Admin_Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.CYAN);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//enabling another frame
				Admin_Userinteface window = new Admin_Userinteface();
				window.frame.setVisible(true);
				//disabling the current frame
				frame.setVisible(false);
			}
		});
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		BackButton.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(BackButton);
		//********************************************adding fuctionality to the button
		JButton Loginbutton = new JButton("Login");
		Loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Administration_Login();
				} 
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Something went ");
				}
			}
		});
		//********************************************************************
		Loginbutton.setBackground(Color.ORANGE);
		Loginbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		Loginbutton.setBounds(80, 156, 265, 42);
		frame.getContentPane().add(Loginbutton);
		
		First_NamtextField = new JTextField();
		First_NamtextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		First_NamtextField.setBounds(215, 65, 130, 30);
		frame.getContentPane().add(First_NamtextField);
		First_NamtextField.setColumns(10);
		
		JLabel Fisrt_NameLabel = new JLabel("First Name");
		Fisrt_NameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		Fisrt_NameLabel.setBounds(80, 64, 89, 30);
		frame.getContentPane().add(Fisrt_NameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		PasswordLabel.setBounds(80, 106, 89, 30);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel HeadindLabel = new JLabel("Login Screen");
		HeadindLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		HeadindLabel.setBounds(122, 11, 171, 42);
		frame.getContentPane().add(HeadindLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(215, 113, 130, 32);
		frame.getContentPane().add(passwordField);
	}
	//********************************connection method
	public void connection() throws SQLException
	{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect=(Connection) DriverManager.getConnection(url, username, password);
		    } 
		catch (ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "Currently have no connection ");
		}
		
	}//********************************end of connection 
		//*************************validating login inputs
	public void Administration_Login() throws SQLException 
	{
		
		
		if(First_NamtextField.getText().length()==0&&passwordField.getText().length()==0)
		{
			JOptionPane.showMessageDialog(null, "fileds cannot be left empty");
		}
		//end of if

		else if(First_NamtextField.getText().length()>=21|passwordField.getText().length()>=21)
		{
			JOptionPane.showMessageDialog(null, "fiels is too long");
		}
		//end of if
		else if(First_NamtextField.getText().matches("[A-Za-z]+")==false) 
		{
			JOptionPane.showMessageDialog(null,"Only letters in the first name filed");
		}
		//end of else if
		else {
		connection();
		String sql="select * from Administrator where First_Name='"+First_NamtextField.getText()+"' and password='"+passwordField.getText()+"'";
		preparedS=(PreparedStatement) connect.prepareStatement(sql);
		set=preparedS.executeQuery();
		if(set.next())
		{   //enabling another frame
			Admin_Functions window = new Admin_Functions();
			window.frame.setVisible(true);
			//disabling the current frame
			frame.setVisible(false);
		}//end of if
		else 
		{
			JOptionPane.showMessageDialog(null, "Incorrect Password or First Name");
		}//end of inner else
		   }//end of outer else
						
	}//end of method
}
//end of class

package administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class Admin_Registration {

	public JFrame frame;
	private JTextField NameTextField;
	private JPasswordField passwordField;
	private JPasswordField ConfirmpasswordField;
	private JButton Registerbutton;
	private JButton BackButton;
	private JComboBox TitlecomboBox;
	private String[] Title = {"Mr","Mrs","Miss","Dr","Prof"};
   
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Registration window = new Admin_Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admin_Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 450, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAdministrationRegistratio = new JLabel("Administration registration page");
		lblAdministrationRegistratio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblAdministrationRegistratio.setForeground(Color.BLACK);
		lblAdministrationRegistratio.setBounds(32, 11, 369, 74);
		frame.getContentPane().add(lblAdministrationRegistratio);
		
		JLabel nameLabel = new JLabel("First Name");
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		nameLabel.setBounds(76, 142, 106, 24);
		frame.getContentPane().add(nameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		PasswordLabel.setBounds(76, 177, 78, 24);
		frame.getContentPane().add(PasswordLabel);
		
		JLabel ConfirmPassword = new JLabel("Confirm Password");
		ConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		ConfirmPassword.setBounds(74, 216, 154, 24);
		frame.getContentPane().add(ConfirmPassword);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(253, 146, 117, 20);
		frame.getContentPane().add(NameTextField);
		NameTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Plz enter password");
		passwordField.setBounds(253, 181, 117, 20);
		frame.getContentPane().add(passwordField);
		
		ConfirmpasswordField = new JPasswordField();
		ConfirmpasswordField.setToolTipText("confirm previously entered password");
		ConfirmpasswordField.setBounds(253, 220, 117, 20);
		frame.getContentPane().add(ConfirmpasswordField);
		
		JPanel panel = new JPanel();
		panel.setBounds(114, 270, 207, 33);
		frame.getContentPane().add(panel);
		
		BackButton = new JButton("Back");
		panel.add(BackButton);
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		Registerbutton = new JButton("Register");
		panel.add(Registerbutton);
		Registerbutton.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel TitleLabel = new JLabel("Title");
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		TitleLabel.setBounds(76, 117, 46, 14);
		frame.getContentPane().add(TitleLabel);
		
		TitlecomboBox = new JComboBox(Title);
		TitlecomboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		TitlecomboBox.setBounds(254, 115, 78, 20);
		frame.getContentPane().add(TitlecomboBox);
		
		//********************************add functionality to the buttons***************
		ButtonHandler Abutton =new ButtonHandler(); //buttonHandler object type
		Registerbutton.addActionListener(Abutton);
		BackButton.addActionListener(Abutton);
		
	}
	//*******************************************************ActionListener Mathod**********************************************
			private class ButtonHandler implements ActionListener 
			{

				@Override
				public void actionPerformed(ActionEvent a) 
				{
					if(a.getSource()==Registerbutton)
					{
						try {
							// calling the mathod
							Registration();
						   }
						catch (SQLException e)
						{
							JOptionPane.showMessageDialog(null,"Unexpected error try again");
						}
					}//end of if
					else if(a.getSource()==BackButton) 
					{
						//enabling another frame
						Admin_Userinteface window = new Admin_Userinteface();
						window.frame.setVisible(true);
						//disabling the current frame
						frame.setVisible(false);
					}//end of else if
				}//end of actionperformed
			}//end of actionListener
			
			//registration mathod
			public void Registration() throws SQLException 
			{
				Staff_Database data =new Staff_Database();//database class
				String Name=NameTextField.getText();
				String Password=passwordField.getText();
				String Confirm=ConfirmpasswordField.getText();
				String titleBox =(String) TitlecomboBox.getSelectedItem();
				if(NameTextField.getText().length() ==0&&passwordField.getText().length() ==0&&ConfirmpasswordField.getText().length() ==0) 
				 {
					JOptionPane.showMessageDialog(null,"All fileds needs to have values");
				 }
				//**************end of if
				else if(NameTextField.getText().matches("[A-Za-z]+")==false) 
				{
					JOptionPane.showMessageDialog(null,"Only letters in the first name filed");
				}
				//end of else if
				else if(passwordField.getText().length() >=21|ConfirmpasswordField.getText().length() >=21|NameTextField.getText().length() >=21) 
				 {
					JOptionPane.showMessageDialog(null,"fild/s is too long");
					
				 }
				//**************end of if
				
				else if(passwordField.getText().length() <=3&&ConfirmpasswordField.getText().length() <=3) 
				 {
					JOptionPane.showMessageDialog(null,"Password needs to be more than 4 characters");
					passwordField.setText("");
					ConfirmpasswordField.setText("");
				 }
				//**************end of if
				
				else {
					   if(passwordField.getText().equals(Confirm)) 
					    {
						   JOptionPane.showMessageDialog(null,"Proccesing Data");
						data.Administration_Register(titleBox, Name, Password, Confirm);
						JOptionPane.showMessageDialog(null,"Registration complete");
						//calling class 
						Admin_Functions window = new Admin_Functions();
						window.frame.setVisible(true);
						window.frame.setResizable(false);
						//disabling the frame
						frame.setVisible(false);
	
				       	}
					//***************end of else if
				   	else 
					{
						JOptionPane.showMessageDialog(null,"password and confirm password needs match");
						passwordField.setText("");
						ConfirmpasswordField.setText("");
					}
					//end of else
				}//end of else	
			}
			//end of mathod 
}//end of class

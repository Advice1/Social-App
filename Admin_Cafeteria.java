package administration;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Admin_Cafeteria {

	public JFrame frame;
	private JTextField StuffIdtextField;
	private JTextField NameTextField;
	private JTextField SurnameTextField;
	private JButton AddButton;
	private JButton backButton;
	private JComboBox<?> TitledcomboBox;
	private JComboBox<?> ChooseComboBox;
	private JComboBox<?> Job_CategoryComboBox;
	int No=0;
	
	private String[] title = {"Mr","Mrs","Dr","Prof"};
	private String[] company = {"Cafeteria"};//more functions to be added in the array
	private String[] job_Category = {"Kitchen Manager","Section Cook","Vegetable station","Salad Station","Pastry Cook","Fish Station","Grill Cook","Cook","Junior Cook","Food Runner","Waiter"};
	
	private String titleBox;
	private String chooseFiled;
	private String jobs;
	private JTextField PasswordTextField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Cafeteria window = new Admin_Cafeteria();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Admin_Cafeteria() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel HeadingLabel = new JLabel("Company Admin");
		HeadingLabel.setBackground(Color.ORANGE);
		HeadingLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		HeadingLabel.setBounds(70, 11, 248, 49);
		frame.getContentPane().add(HeadingLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		NameLabel.setBounds(70, 110, 46, 31);
		frame.getContentPane().add(NameLabel);
		
		JLabel SurnameLabel = new JLabel("Surname");
		SurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		SurnameLabel.setBounds(70, 152, 67, 29);
		frame.getContentPane().add(SurnameLabel);
		
		JLabel JobLabel = new JLabel("Job Title");
		JobLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		JobLabel.setBounds(70, 192, 84, 22);
		frame.getContentPane().add(JobLabel);
		
		JLabel TitleLabel = new JLabel("Title");
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		TitleLabel.setBounds(70, 85, 46, 14);
		frame.getContentPane().add(TitleLabel);
		
		JLabel StaffHeadingLabel = new JLabel("Staff No & Password Auto Generate Below");
		StaffHeadingLabel.setBackground(Color.ORANGE);
		StaffHeadingLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 21));
		StaffHeadingLabel.setBounds(10, 288, 370, 22);
		frame.getContentPane().add(StaffHeadingLabel);
		
		TitledcomboBox = new JComboBox<Object>(title);
		TitledcomboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		TitledcomboBox.setBounds(194, 71, 91, 20);
		frame.getContentPane().add(TitledcomboBox);
				
		NameTextField = new JTextField();
		NameTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		NameTextField.setText("");
		NameTextField.setBounds(194, 110, 91, 20);
		frame.getContentPane().add(NameTextField);
		NameTextField.setColumns(10);
		
		SurnameTextField = new JTextField();
		SurnameTextField.setText("");
		SurnameTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		SurnameTextField.setColumns(10);
		SurnameTextField.setBounds(194, 152, 91, 20);                     
		frame.getContentPane().add(SurnameTextField);
		//
		
		//
		AddButton = new JButton("ADD");
		AddButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		AddButton.setBounds(133, 264, 89, 23);
		frame.getContentPane().add(AddButton);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		PasswordLabel.setBounds(115, 348, 67, 16);
		frame.getContentPane().add(PasswordLabel);
		
		PasswordTextField_1 = new JTextField();
		PasswordTextField_1.setEditable(false);
		PasswordTextField_1.setText("");
		PasswordTextField_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		PasswordTextField_1.setColumns(10);
		PasswordTextField_1.setBounds(202, 345, 116, 22);
		frame.getContentPane().add(PasswordTextField_1);
		
		JLabel StaffNoLabel = new JLabel("Stuff No");
		StaffNoLabel.setBounds(115, 321, 52, 16);
		frame.getContentPane().add(StaffNoLabel);
		StaffNoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		StuffIdtextField = new JTextField();
		StuffIdtextField.setBounds(202, 318, 116, 22);
		frame.getContentPane().add(StuffIdtextField);
		StuffIdtextField.setEditable(false);
		StuffIdtextField.setFont(new Font("Tahoma", Font.BOLD, 13));        
		StuffIdtextField.setText("");
		StuffIdtextField.setColumns(10);
		
		JPanel AutogeneratePanel = new JPanel();
		AutogeneratePanel.setBackground(SystemColor.controlShadow);
		AutogeneratePanel.setBounds(112, 312, 216, 64);
		frame.getContentPane().add(AutogeneratePanel);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCategory.setBounds(70, 218, 84, 22);
		frame.getContentPane().add(lblCategory);
		
		ChooseComboBox = new JComboBox<Object>(company);
		ChooseComboBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		ChooseComboBox.setBounds(194, 223, 91, 20);
		frame.getContentPane().add(ChooseComboBox);
		
		Job_CategoryComboBox = new JComboBox<Object>(job_Category);
		Job_CategoryComboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		Job_CategoryComboBox.setBounds(194, 194, 149, 20);
		frame.getContentPane().add(Job_CategoryComboBox);
		
		JPanel Display_Panel = new JPanel();
		Display_Panel.setBounds(47, 60, 315, 199);
		frame.getContentPane().add(Display_Panel);
		
		 backButton = new JButton("Back");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.setBounds(0, 364, 89, 23);
		frame.getContentPane().add(backButton);
		frame.setBounds(100, 100, 406, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//********************************add functionality to the buttons***************
		ButtonHandler buttonH =new ButtonHandler(); //buttonHandler object typ
		AddButton.addActionListener(buttonH);
		backButton.addActionListener(buttonH);
	}
	//*******************************************************ActionListener Mathod**********************************************
			private class ButtonHandler implements ActionListener 
			{

				@Override
				public void actionPerformed(ActionEvent a) 
				{
					
					if(a.getSource()==AddButton) 
					{
						//*********************************************
						Staff_Database Adding =new Staff_Database();
						//*********************************************
						String name= NameTextField.getText();                     
						String surname= SurnameTextField.getText();
						
						titleBox =(String) TitledcomboBox.getSelectedItem();
						chooseFiled =(String) ChooseComboBox.getSelectedItem();
						jobs=(String) Job_CategoryComboBox.getSelectedItem();
						
						
						if(NameTextField.getText().length() ==0 |SurnameTextField.getText().length() ==0 )
						 {
						 	// code executed if one of the textfields is empty
						 JOptionPane.showMessageDialog(null,"TEXTFIELDS CANT BE EMPTY ");
						 }
						else if(NameTextField.getText().length() <=3 |SurnameTextField.getText().length() <=3) 
						{
							JOptionPane.showMessageDialog(null,"Name and Surname can't be shorter than 3 words ");
						}
						else if(NameTextField.getText().matches("[A-Za-z]+")==false) 
						{
							JOptionPane.showMessageDialog(null,"Only letters in the first name field");
						}
						else if(surname.matches("[A-Za-z]+")==false) 
						{
							JOptionPane.showMessageDialog(null,"Only letters in the last name field");
						}
						//end of else if
						else {
							
						
						 if(chooseFiled.equals("Clinic"))
						{
							 //************password and stuff id generated
							String stuffId = generateId(name,surname);
							String password=passWord(name,surname);
							try {
								Adding.AddingStaff(titleBox , name, surname, jobs,chooseFiled, stuffId, password);
								//++++++++++++setting staff no and password+++++++++++++++++++++
								PasswordTextField_1 .setText(password);   
								StuffIdtextField.setText(stuffId);
								//=++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								JOptionPane.showMessageDialog(null, "Stuff Successfully Added");
							   }
						   catch (SQLException e)
							{
							   JOptionPane.showMessageDialog(null, "Something went wrong try again");
							 }
							
						}//end of if
						
						else if(chooseFiled.equals("Cafeteria")) 
						{
							//stuff id and password generated 
							String cafeId=generateCaFeSfuffId(name,surname);
							String password=passWord(name,surname);
							try {
								Adding.AddingStaff(titleBox , name, surname, jobs,chooseFiled, cafeId, password);
								//++++++++++++setting staff no and password+++++++++++++++++++++
								PasswordTextField_1 .setText(password);   
								StuffIdtextField.setText(cafeId);
								//=++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
								JOptionPane.showMessageDialog(null, "Stuff Successfully Added");
								//clearing the fields
								 NameTextField.setText("");
								SurnameTextField.setText("");
								PasswordTextField_1.setText("");   
								StuffIdtextField.setText("");
								
							}
							 catch(SQLIntegrityConstraintViolationException e)
							 {
								 JOptionPane.showMessageDialog(null, "Stuff Could not be hired Try Again");
							 }//end of first catch
							catch (SQLException e) {
								JOptionPane.showMessageDialog(null, "Something went wrong try again");
							}
							
						}//end of else if 
					}//end of else 	  
						
					}//************************************************************************************end of if
					else
					{
					
						//Enabling the another frame 
						Admin_Functions window = new Admin_Functions();
						window.frame.setVisible(true);
						//disabling the current frame
						frame.setVisible(false);
					}//end of else
					
					
				}//end of actionPerfomed
				}//end of ActionListener
			
			
			public String generateId(String nam,String surn) 
			{
				String username= (String) nam.subSequence(0, 3);
				int lenth=surn.length();
				Random in=new Random();
				int a=10000+in.nextInt(80000);
			
				return username.length()+""+a+""+lenth;
				
			}
			//***************************************
			public String generateCaFeSfuffId(String nam,String surn) 
			{
					
				String username= (String) nam.subSequence(0, 3);
				int lenth=surn.length();
				Random in=new Random();
				int a=20000+in.nextInt(80000);
			
				return lenth +""+a+""+username.length();
				
			}
			//***************************************
			
			public String passWord(String nam,String surnam)
			{
				Random in=new Random();
				int a=1000+in.nextInt(8000);
				String username=surnam.substring(0, 3)+nam.length();
				return username+username.charAt(2)+"@"+a+3;
			}	
}

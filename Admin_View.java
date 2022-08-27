package administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import multiImageRetrival.FriendDatabase;
import multiImageRetrival.Student;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Admin_View {

	public JFrame frame;
	private JTextField NametextField;
	private JTextField SurnameTextField;
	private JTextField DepartmentTextField;
	private JTextField StsNoTextField;
	private JPanel PersonalInforPanel;
	private JLabel HeadingLabel;
	private JLabel FacebookLabel;
	private JLabel TweeterLabel;
	private JLabel InstagramNoLabel;
	private JTextField facebookTextField;
	private JTextField TweeterTextField;
	private JTextField instagramTextField;
	private JPanel panel;
	private JLabel SocialMdiaLabel;
	private JButton NextButton;
	private JButton btnDisplay;
	private JButton previousButton;
	private JButton BackButton;
	int c=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_View window = new Admin_View();
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
	public Admin_View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 577, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		NametextField = new JTextField();
		NametextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		NametextField.setBounds(79, 50, 109, 20);
		NametextField.setColumns(10);
		
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		JLabel lblName = new JLabel("Name....");
		lblName.setBounds(79, 23, 43, 19);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel SurnameLabel = new JLabel("Surname....  ");
		SurnameLabel.setBounds(188, 23, 78, 19);
		SurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		SurnameTextField = new JTextField();
		SurnameTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		SurnameTextField.setBounds(198, 50, 93, 20);
		SurnameTextField.setColumns(10);
		
		JLabel DepartLabel = new JLabel("Department.....  ");
		DepartLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		DepartLabel.setBounds(291, 23, 96, 19);
		
		DepartmentTextField = new JTextField();
		DepartmentTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		DepartmentTextField.setText("");
		DepartmentTextField.setBounds(301, 50, 109, 20);
		//frame.getContentPane().add(DepartmentTextField);
		DepartmentTextField.setColumns(10);
		
		JLabel StudentLabel = new JLabel("Student No....  ");
		StudentLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		StudentLabel.setBounds(415, 18, 96, 19);
		//frame.getContentPane().add(StudentLabel);
		
		StsNoTextField = new JTextField();
		StsNoTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		StsNoTextField.setText("");
		StsNoTextField.setBounds(425, 50, 111, 20);
		StsNoTextField.setColumns(10);
		
		PersonalInforPanel = new JPanel();
		PersonalInforPanel.add(StudentLabel);
		
		PersonalInforPanel.add( DepartLabel);
		PersonalInforPanel.add(SurnameLabel);
		PersonalInforPanel.add(lblName);
		PersonalInforPanel.add(StsNoTextField);
		PersonalInforPanel.add(DepartmentTextField);
		PersonalInforPanel.add(SurnameTextField);
		PersonalInforPanel.add(NametextField);
		PersonalInforPanel.setBounds(22, 48, 504, 80);
		frame.getContentPane().add(PersonalInforPanel);
		
		HeadingLabel = new JLabel("Personal Details");
		HeadingLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		HeadingLabel.setBounds(43, 11, 248, 26);
		frame.getContentPane().add(HeadingLabel);
		
		FacebookLabel = new JLabel("Facebook");
		FacebookLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		FacebookLabel.setBounds(43, 181, 77, 14);
		frame.getContentPane().add(FacebookLabel);
		
		TweeterLabel = new JLabel("Tweeter");
		TweeterLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		TweeterLabel.setBounds(43, 209, 77, 14);
		frame.getContentPane().add(TweeterLabel);
		
		InstagramNoLabel = new JLabel("Instagram");
		InstagramNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		InstagramNoLabel.setBounds(43, 236, 96, 14);
		frame.getContentPane().add(InstagramNoLabel);
		
		facebookTextField = new JTextField();
		facebookTextField.setFont(new Font("Tahoma", Font.BOLD, 12));
		facebookTextField.setBounds(149, 180, 121, 20);
		frame.getContentPane().add(facebookTextField);
		facebookTextField.setColumns(10);
		
		TweeterTextField = new JTextField();
		TweeterTextField.setFont(new Font("Arial Black", Font.BOLD, 12));
		TweeterTextField.setText("");
		TweeterTextField.setBounds(149, 208, 121, 20);
		frame.getContentPane().add(TweeterTextField);
		TweeterTextField.setColumns(10);
		
		instagramTextField = new JTextField();
		instagramTextField.setBounds(149, 235, 121, 20);
		frame.getContentPane().add(instagramTextField);
		instagramTextField.setColumns(10);
		
		panel = new JPanel();
		panel.setBounds(42, 170, 254, 99);
		frame.getContentPane().add(panel);
		
		SocialMdiaLabel = new JLabel("Social Media Accounts");
		SocialMdiaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		SocialMdiaLabel.setBounds(32, 133, 198, 26);
		frame.getContentPane().add(SocialMdiaLabel);
		
		JPanel DisplayPanel1 = new JPanel();
		DisplayPanel1.setBounds(171, 347, 306, 39);
		frame.getContentPane().add(DisplayPanel1);
		
		btnDisplay = new JButton("Start");
		DisplayPanel1.add(btnDisplay);
		btnDisplay.setFont(new Font("Tahoma", Font.BOLD, 15));
		
	    previousButton = new JButton("Previous");
		previousButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		DisplayPanel1.add(previousButton);
		
		NextButton = new JButton("Next");
		DisplayPanel1.add(NextButton);
		NextButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel RecordHeadingLabel = new JLabel("Dispaly Student Profile");
		RecordHeadingLabel.setFont(new Font("Georgia Pro Black", Font.BOLD | Font.ITALIC, 15));
		RecordHeadingLabel.setBounds(171, 308, 277, 39);
		frame.getContentPane().add(RecordHeadingLabel);
		
		BackButton = new JButton("<<<");
		BackButton.setToolTipText("back");
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		BackButton.setBounds(0, 396, 79, 23);
		frame.getContentPane().add(BackButton);
		
		NextButton.setVisible(false);
		previousButton.setVisible(false);
		//********************************add functionality to the buttons***************
		ButtonHandler button =new ButtonHandler(); //buttonHandler object typ
		btnDisplay.addActionListener(button);
		NextButton.addActionListener(button);
		previousButton.addActionListener(button);
		BackButton.addActionListener(button);
	}
	//*******************************************************ActionListener Mathod**********************************************
	private class ButtonHandler implements ActionListener 
	{

		@Override
		public void actionPerformed(ActionEvent a) 
		{
			//+++++++++++++++++++++++++++++++++++++++Code for getting data from the StorageImage class++++++++++++++++ 
			FriendDatabase data =new FriendDatabase();//Frienddatabase class
			Student category = new Student();//object of student class
			
			if(a.getSource()==btnDisplay) 
			{
				try {
					List<Student> list=data.GetData();
					if(list.isEmpty())
					{
						JOptionPane.showMessageDialog(null,"No Registered user");
					}//end of if
					else {
					category = list.get(c);
					NametextField.setText(category.getName());
					SurnameTextField.setText(category.getSurname());
					DepartmentTextField.setText(category.getDepartment());
					StsNoTextField.setText(category.getStdNumber());
					facebookTextField.setText(category.getFacebook());
					TweeterTextField.setText(category.getInstagram());
					instagramTextField.setText(category.getTweeter());
					
					btnDisplay.setVisible(false);
					NextButton.setVisible(true);
					
					}
					//end of inside else
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Unexpected error try again");
					e.printStackTrace();
				}
				catch(IndexOutOfBoundsException bound)
				{    
					JOptionPane.showMessageDialog(null,"Use the next/previous button/s");
					System.out.println("OUT OF BOUND EXCEPTION");	
				}
				
			}
			
			else if(a.getSource()==NextButton) 
			{
				//
				c++;
				try {
					
					List<Student> list=data.GetData();
					category = list.get(c);
					NametextField.setText(category.getName());
					SurnameTextField.setText(category.getSurname());
					DepartmentTextField.setText(category.getDepartment());
					StsNoTextField.setText(category.getStdNumber());
					facebookTextField.setText(category.getFacebook());
					TweeterTextField.setText(category.getInstagram());
					instagramTextField.setText(category.getTweeter());
					
					previousButton.setVisible(true);
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"press again");
				}
				catch(IndexOutOfBoundsException bound)
				{    
					NextButton.setVisible(false);
					JOptionPane.showMessageDialog(null,"last Record use the previous button");
						c--; //remain in the same record
				}
				//
			}//end of if
			else if(a.getSource()==previousButton) 
			{
				--c;
				try {
				List<Student> list=data.GetData();
				
				category = list.get(c);
				NametextField.setText(category.getName());
				SurnameTextField.setText(category.getSurname());
				DepartmentTextField.setText(category.getDepartment());
				StsNoTextField.setText(category.getStdNumber());
				facebookTextField.setText(category.getFacebook());
				TweeterTextField.setText(category.getInstagram());
				instagramTextField.setText(category.getTweeter());
				NextButton.setVisible(true);
				  
			} catch (SQLException e) 
				{
				JOptionPane.showMessageDialog(null,"something went wrong try again");
				
			    }
				//end of first catch
				catch(IndexOutOfBoundsException bound)
				{    previousButton.setVisible(false);
					JOptionPane.showMessageDialog(null,"first record use next button");
					c++;	//remain in the same record
				}
				//end of  second catch
			}
			//end of else if
			else 
			{
				//Enabling the another frame 
				Admin_Functions window = new Admin_Functions();
				window.frame.setVisible(true);
				//disabling the current frame 
				frame.setVisible(false);
				
			}//end of else
		}//end of action performed
		}//end of actionlistener method 
}

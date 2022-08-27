package administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.Color;


import multiImageRetrival.FriendDatabase;
import multiImageRetrival.Student;


import javax.swing.JSeparator;

public class Admin_DisplayAll {

	public JFrame frame;
	private JTextField StudentNotextField;
	private JTextField NameTextField;
	private JTextField SurnameTextField;
	private JTextField StudentNoTextField;
	private JTextField DepartMentTextField;
	private JTextField FacebookTextField;
	private JTextField TweeterTextField;
	private JTextField InstagramTextField;
    private JScrollPane UserScrollpane;
    private JButton DisplayButton;
    private JTextArea DisplaytextArea;
    private JButton SearchButton;
    private String name;
    private JButton BackButton;
    private JButton DeletButton;
    private JButton ClearButton;
    private JButton ClearSearchButton;
  //+++++++++++++++++++++++++++++++++++++++Code for getting data from the StorageImage class++++++++++++++++ 
	FriendDatabase data =new FriendDatabase();//database class
	Student category = new Student();//object of Student class

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_DisplayAll window = new Admin_DisplayAll();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin_DisplayAll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 636, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DisplaytextArea = new JTextArea();
		DisplaytextArea.setFont(new Font("Tahoma", Font.BOLD, 13));
		DisplaytextArea.setEditable(false);
		
		UserScrollpane = new JScrollPane(DisplaytextArea,UserScrollpane.VERTICAL_SCROLLBAR_ALWAYS,UserScrollpane.HORIZONTAL_SCROLLBAR_ALWAYS);
		UserScrollpane.setBounds(10, 53, 603, 185);
		frame.getContentPane().add(UserScrollpane);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		NameLabel.setBounds(10, 28, 46, 14);
		frame.getContentPane().add(NameLabel);
		
		JLabel SearchLabel = new JLabel("Search Section");
		SearchLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		SearchLabel.setBounds(29, 298, 147, 20);
		frame.getContentPane().add(SearchLabel);
		
		JLabel StudentNoLabel = new JLabel("Student Number");
		StudentNoLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		StudentNoLabel.setToolTipText("Search by Student Number");
		StudentNoLabel.setBounds(29, 329, 118, 25);
		frame.getContentPane().add(StudentNoLabel);
		
	    SearchButton = new JButton("Search");
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		SearchButton.setBounds(374, 331, 89, 23);
		frame.getContentPane().add(SearchButton);
		
		JLabel NameDispalyLabel = new JLabel("Name");
		NameDispalyLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		NameDispalyLabel.setBounds(29, 385, 58, 25);
		frame.getContentPane().add(NameDispalyLabel);
		
		JLabel SurnameDisplaylabel = new JLabel("Surname");
		SurnameDisplaylabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		SurnameDisplaylabel.setBounds(118, 412, 58, 25);
		frame.getContentPane().add(SurnameDisplaylabel);
		
		JLabel StudentNoDiplayLabel = new JLabel("Student No");
		StudentNoDiplayLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		StudentNoDiplayLabel.setBounds(210, 432, 89, 25);
		frame.getContentPane().add(StudentNoDiplayLabel);
		
		JLabel DepartmentDispalylabel = new JLabel("Department");
		DepartmentDispalylabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		DepartmentDispalylabel.setBounds(309, 456, 96, 25);
		frame.getContentPane().add(DepartmentDispalylabel);
		
		NameTextField = new JTextField();                         
		NameTextField.setEditable(false);
		NameTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		NameTextField.setBounds(90, 388, 96, 20);
		frame.getContentPane().add(NameTextField);
		NameTextField.setColumns(10);
		
		SurnameTextField = new JTextField();
		SurnameTextField.setEditable(false);
		SurnameTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		SurnameTextField.setColumns(10);
		SurnameTextField.setBounds(197, 412, 96, 20);
		frame.getContentPane().add(SurnameTextField);
		
		StudentNoTextField = new JTextField();
		StudentNoTextField.setEditable(false);
		StudentNoTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		StudentNoTextField.setColumns(10);
		StudentNoTextField.setBounds(297, 435, 96, 20);
		frame.getContentPane().add(StudentNoTextField);
		
		DepartMentTextField = new JTextField();
		DepartMentTextField.setEditable(false);
		DepartMentTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		DepartMentTextField.setColumns(10);
		DepartMentTextField.setBounds(400, 459, 96, 20);
		frame.getContentPane().add(DepartMentTextField);
		
		JPanel PersonalInformationPanel = new JPanel();
		PersonalInformationPanel.setBackground(new Color(192, 192, 192));
		PersonalInformationPanel.setBounds(10, 385, 501, 110);
		frame.getContentPane().add(PersonalInformationPanel);
		
		JLabel facebookLabel = new JLabel("Facebook");
		facebookLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		facebookLabel.setBounds(29, 526, 89, 25);
		frame.getContentPane().add(facebookLabel);
		
		JLabel TweeterLabel = new JLabel("Tweeter");
		TweeterLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		TweeterLabel.setBounds(29, 555, 89, 25);
		frame.getContentPane().add(TweeterLabel);
		
		JLabel InstagramLabel = new JLabel("Instagram");
		InstagramLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		InstagramLabel.setBounds(29, 587, 89, 25);
		frame.getContentPane().add(InstagramLabel);
		
		FacebookTextField = new JTextField();
		FacebookTextField.setEditable(false);
		FacebookTextField.setFont(new Font("Tahoma", Font.BOLD, 13));     
		FacebookTextField.setColumns(10);
		FacebookTextField.setBounds(122, 529, 96, 20);
		frame.getContentPane().add(FacebookTextField);
		
		TweeterTextField = new JTextField();
		TweeterTextField.setEditable(false);
		TweeterTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		TweeterTextField.setColumns(10);
		TweeterTextField.setBounds(122, 562, 96, 20);
		frame.getContentPane().add(TweeterTextField);
		
		InstagramTextField = new JTextField();
		InstagramTextField.setEditable(false);
		InstagramTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		InstagramTextField.setColumns(10);
		InstagramTextField.setBounds(122, 590, 96, 20);
		frame.getContentPane().add(InstagramTextField);
		
		JPanel SocialMediaPanel = new JPanel();
		SocialMediaPanel.setBounds(10, 516, 237, 107);
		frame.getContentPane().add(SocialMediaPanel);
		
		JLabel SocialMedialHeadingLabel = new JLabel("Social Media Account");
		SocialMedialHeadingLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		SocialMedialHeadingLabel.setBounds(10, 497, 222, 20);
		frame.getContentPane().add(SocialMedialHeadingLabel);
		
		JLabel InformationLabelLabel = new JLabel("Personal Information");
		InformationLabelLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		InformationLabelLabel.setBounds(10, 360, 222, 25);
		frame.getContentPane().add(InformationLabelLabel);
		
		JPanel Searchpanel = new JPanel();
		Searchpanel.setBackground(new Color(173, 216, 230));
		Searchpanel.setBounds(20, 329, 491, 32);
		frame.getContentPane().add(Searchpanel);
		
		StudentNotextField = new JTextField();
		StudentNotextField.setToolTipText("type student Number and Search");
		Searchpanel.add(StudentNotextField);
		StudentNotextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		StudentNotextField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 0, 0));
		separator.setBounds(10, 283, 608, 10);
		frame.getContentPane().add(separator);
		
		DisplayButton = new JButton("Display All");
		DisplayButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		DisplayButton.setBounds(20, 249, 110, 23);
		frame.getContentPane().add(DisplayButton);
		
		JLabel SurnameLabel = new JLabel("Surname");
		SurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		SurnameLabel.setBounds(90, 29, 70, 14);
		frame.getContentPane().add(SurnameLabel);
		
		JLabel StdntNolabel = new JLabel("Student No");
		StdntNolabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		StdntNolabel.setBounds(186, 29, 89, 14);
		frame.getContentPane().add(StdntNolabel);
		
		JLabel DepartmentLabel = new JLabel("Department");
		DepartmentLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		DepartmentLabel.setBounds(279, 28, 79, 14);
		frame.getContentPane().add(DepartmentLabel);
		
		JLabel Facebooklabel = new JLabel("Facebook");
		Facebooklabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		Facebooklabel.setBounds(368, 28, 70, 14);
		frame.getContentPane().add(Facebooklabel);
		
		JLabel tweeterLabel = new JLabel("Tweeter");
		tweeterLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		tweeterLabel.setBounds(448, 28, 55, 14);
		frame.getContentPane().add(tweeterLabel);
		
		JLabel instagramLabel = new JLabel("Instagram");
		instagramLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		instagramLabel.setBounds(529, 28, 70, 14);
		frame.getContentPane().add(instagramLabel);
		
		BackButton = new JButton("<<<");
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		BackButton.setBounds(524, 616, 89, 23);
		frame.getContentPane().add(BackButton);
		
		JLabel ManageHeadinglabel = new JLabel("Manage Record");
		ManageHeadinglabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		ManageHeadinglabel.setBounds(356, 503, 137, 20);
		frame.getContentPane().add(ManageHeadinglabel);
		
	    ClearButton = new JButton("Clear");
		ClearButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		ClearButton.setBounds(158, 249, 89, 23);
		frame.getContentPane().add(ClearButton);
		
		ClearSearchButton = new JButton("Clear Search");
		ClearSearchButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		ClearSearchButton.setBounds(389, 298, 122, 23);
		frame.getContentPane().add(ClearSearchButton);
		
		ClearButton.setVisible(false);
		ClearSearchButton.setVisible(false);
		StudentNotextField.setEditable(true);
		
		JPanel BackPanel = new JPanel();
		BackPanel.setBounds(366, 534, 109, 46);
		frame.getContentPane().add(BackPanel);
		
		DeletButton = new JButton("Remove");
		DeletButton.setBackground(Color.RED);
		BackPanel.add(DeletButton);
		DeletButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		DeletButton.setVisible(false);
		
		
		
		
		//********************************add functionality to the buttons***************
				ButtonHandler buttonH =new ButtonHandler(); //buttonHandler object typ
				DisplayButton.addActionListener(buttonH);
				SearchButton.addActionListener(buttonH);
				BackButton.addActionListener(buttonH);
				ClearButton.addActionListener(buttonH);
				ClearSearchButton.addActionListener(buttonH);
				DeletButton.addActionListener(buttonH);
				
	}
	
	//*******************************************************ActionListener Mathod**********************************************
		private class ButtonHandler implements ActionListener 
		{

			@Override
			public void actionPerformed(ActionEvent a) 
			{
				if(a.getSource()==DisplayButton) 
				{
					
					try {
						
						DisplaytextArea.setText("");
						Reading();
						} //end of try
					catch (SQLException e) 
					   {
						JOptionPane.showMessageDialog(null,"Something Went Wrong try again");
					  }	
				}//end of if
				
				else if(a.getSource()==SearchButton)
				{
					try {
						SearchData();
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Something went wrong try again");
					}
				}//end of else if
				
				else if(a.getSource()==DeletButton)
				{
					try {
						delete();
						StudentNotextField.setText("");
						NameTextField.setText("");
						SurnameTextField.setText("");
						DepartMentTextField.setText("");
						StudentNoTextField.setText("");
						FacebookTextField.setText("");
						TweeterTextField.setText("");
						InstagramTextField.setText("");
						
					   }
					catch(SQLIntegrityConstraintViolationException e)
					 {
						JOptionPane.showMessageDialog(null,"Student Offering a service Cannot be Removed");
					 }//end of second catch
					catch (SQLException e) 
					  {
						JOptionPane.showMessageDialog(null,"Unexpected error try again");
					  }
				}//end of else
				else if(a.getSource()==ClearButton)
				{
					DisplaytextArea.setText("");
				}//end of else
				
				else if(a.getSource()==ClearSearchButton)
				{
					StudentNotextField.setText("");
					NameTextField.setText("");
					SurnameTextField.setText("");
					DepartMentTextField.setText("");
					StudentNoTextField.setText("");
					FacebookTextField.setText("");
					TweeterTextField.setText("");
					InstagramTextField.setText("");
					StudentNotextField.setEditable(true); //enabling a user to input information
					DeletButton.setVisible(false);
				}//end of else
				else 
				{
					Admin_Functions window = new Admin_Functions();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					//disabling the button
					frame.setVisible(false);
				}
				//end of else
				}//end of action performed
			}//end of actionListener
		
	//******************************************************************read method**************************************************
		public void Reading() throws SQLException 
		{
			List<Student> list=data.GetData();
			if(list.isEmpty()) 
			{
				JOptionPane.showMessageDialog(null,"Sorry Nothing to Display check leter");
			}
			
          else {
        	  
			for(int i=0;i<list.size();i++)
			{
				
		    	//getting data from the list
				category = list.get(i);
				String name =  category.getName();
				String surname=category.getSurname();
				String StudentNo=category.getStdNumber();
				String department=category.getDepartment();
				String facebook=category.getFacebook();
				String instagram=category.getInstagram();
				String tweeter=category.getTweeter();
				
				//****************************************************display in a textarea
				DisplaytextArea.append(name+"\t"+surname+"\t"+StudentNo+"\t"+department+"\t"+facebook+"\t\b"+tweeter+"\t"+instagram+"\n");	
				ClearButton.setVisible(true);
				
				
			}//************end of loop
			
	         }//end of else
		}
		//******************************************************************end of read method**************************************************
		//******************************************************************search method**************************************************
		public void SearchData() throws SQLException 
		{
			name=StudentNotextField.getText();
			List<Student> list=data.SearchData(name);
			
			if(StudentNotextField.getText().length() ==0) 
			 {JOptionPane.showMessageDialog(null,"empty search fiiled");
			 }
			
			else if(list.isEmpty()) 
			{
				JOptionPane.showMessageDialog(null,"user does not exist");
			}
		
          else {
        	  
			for(int i=0;i<list.size();i++)
			{
				
		    	//getting data from the list
				category = list.get(i);
				String namea =  category.getName();
				String surname=category.getSurname();
				String StudentNo=category.getStdNumber();
				String department=category.getDepartment();
				String facebook=category.getFacebook();
				String instagram=category.getInstagram();
				String tweeter=category.getTweeter();
		
					NameTextField.setText(namea);
					SurnameTextField.setText(surname);
					DepartMentTextField.setText(department);
					StudentNoTextField.setText(StudentNo);
					FacebookTextField.setText(facebook);
					TweeterTextField.setText(tweeter);
					InstagramTextField.setText(instagram);
					//setting button to true
					StudentNotextField.setEditable(false);
					ClearSearchButton.setVisible(true);
					DeletButton.setVisible(true);
				 						
			}//************end of loop
            }//end of else
		}//end of method
		//******************************************************************end search method**********************************************
		//******************************************************************delete method**************************************************
				public void delete() throws SQLException 
				{   name=StudentNotextField.getText();//needs to be checked
				 
				 if(StudentNotextField.getText().length() ==0) 
				 {
					 JOptionPane.showMessageDialog(null,"empty fiiled");
				 }//end of if
				 else {
					 data.DeletingUser(name);
					JOptionPane.showMessageDialog(null,"User "+name+" has been Removed");
					DeletButton.setVisible(false);
					StudentNotextField.setEditable(true);
				     }//end of else
				}//end of delete method
}//end of a class

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
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;

import Admin_Service.Admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Stuff_Manage {

	public JFrame frame;
	private JTextField StuffTextField;
	String name;
	private JTextField NameTextField;
	private JTextField S_NameTextField;
	private JTextField TitleTextField;
	private JTextField JTiltleTextField;
	private JTextField DispaltStuffNoTextField;
	private JScrollPane UserScrollpane;
	private JTextArea DisplayTextArea;
	private JButton BackButton;
	private JButton DisplayButton;
	private JButton ClearButton;
	private JButton SearchButton;
	private JButton DeleteButton;
	 //+++++++++++++++++++++++++++++++++++++++Code for getting data from the Admin class++++++++++++++++ 
		Staff_Database data =new Staff_Database();// staff database class
		Admin Details = new Admin();//object of Admin class
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stuff_Manage window = new Stuff_Manage();
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
	public Stuff_Manage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100, 100, 677, 641);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DisplayTextArea = new JTextArea();
		DisplayTextArea.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 16));
		
		UserScrollpane = new JScrollPane(DisplayTextArea,UserScrollpane.VERTICAL_SCROLLBAR_ALWAYS,UserScrollpane.HORIZONTAL_SCROLLBAR_ALWAYS);
		UserScrollpane.setBounds(10, 80, 641, 167);
		frame.getContentPane().add(UserScrollpane);
		
		JLabel HeadingLabel = new JLabel("Manage Record");
		HeadingLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 28));
		HeadingLabel.setBounds(25, 0, 403, 28);
		frame.getContentPane().add(HeadingLabel);
		
		DisplayButton = new JButton("Display");
		DisplayButton.setBackground(new Color(255, 165, 0));
		DisplayButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		DisplayButton.setBounds(195, 258, 89, 23);
		frame.getContentPane().add(DisplayButton);
		
		ClearButton = new JButton("Clear");
		ClearButton.setFont(new Font("Times New Roman", Font.BOLD, 13));
		ClearButton.setBackground(new Color(255, 255, 0));
		ClearButton.setBounds(298, 258, 77, 23);
		frame.getContentPane().add(ClearButton);
		
		JLabel SearchLabel = new JLabel("Search Record");
		SearchLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		SearchLabel.setBounds(628, 212, 64, -39);
		frame.getContentPane().add(SearchLabel);
		
		JLabel SEARCHLabel = new JLabel("Search Record");
		SEARCHLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 20));
		SEARCHLabel.setBounds(60, 306, 255, 40);
		frame.getContentPane().add(SEARCHLabel);
		
		StuffTextField = new JTextField();
		StuffTextField.setFont(new Font("Tahoma", Font.BOLD, 14));
		StuffTextField.setBounds(169, 357, 118, 28);
		frame.getContentPane().add(StuffTextField);
		StuffTextField.setColumns(10);
		
		JLabel StuffNoLabel = new JLabel("Stuff No");
		StuffNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		StuffNoLabel.setBounds(70, 357, 100, 20);
		frame.getContentPane().add(StuffNoLabel);
		
		SearchButton = new JButton("Search");
		SearchButton.setBackground(new Color(255, 255, 0));
		SearchButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		SearchButton.setBounds(322, 356, 89, 23);
		frame.getContentPane().add(SearchButton);
		
		NameTextField = new JTextField();
		NameTextField.setEditable(false);
		NameTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		NameTextField.setBounds(109, 436, 109, 34);
		frame.getContentPane().add(NameTextField);
		NameTextField.setColumns(10);
		
		S_NameTextField = new JTextField();
		S_NameTextField.setEditable(false);
		S_NameTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		S_NameTextField.setColumns(10);
		S_NameTextField.setBounds(240, 436, 110, 34);
		frame.getContentPane().add(S_NameTextField);
		
		TitleTextField = new JTextField();
		TitleTextField.setEditable(false);
		TitleTextField.setFont(new Font("Tahoma", Font.BOLD, 13));   
		TitleTextField.setColumns(10);
		TitleTextField.setBounds(25, 436, 64, 34);
		frame.getContentPane().add(TitleTextField);
		
		JTiltleTextField = new JTextField();
		JTiltleTextField.setEditable(false);
		JTiltleTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		JTiltleTextField.setColumns(10);
		JTiltleTextField.setBounds(370, 436, 109, 34);
		frame.getContentPane().add(JTiltleTextField);
		
		DispaltStuffNoTextField = new JTextField();
		DispaltStuffNoTextField.setEditable(false);
		DispaltStuffNoTextField.setFont(new Font("Tahoma", Font.BOLD, 13));
		DispaltStuffNoTextField.setColumns(10);
		DispaltStuffNoTextField.setBounds(499, 436, 109, 34);
		frame.getContentPane().add(DispaltStuffNoTextField);
		
		JLabel TitleLabel = new JLabel("Title");
		TitleLabel.setBackground(new Color(255, 255, 0));
		TitleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		TitleLabel.setBounds(25, 402, 64, 23);
		frame.getContentPane().add(TitleLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		NameLabel.setBackground(Color.YELLOW);
		NameLabel.setBounds(136, 402, 64, 23);
		frame.getContentPane().add(NameLabel);
		
		JLabel SurnameLabel = new JLabel("Surname");
		SurnameLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		SurnameLabel.setBackground(Color.YELLOW);
		SurnameLabel.setBounds(263, 402, 87, 23);
		frame.getContentPane().add(SurnameLabel);
		
		JLabel JobTitleLabel = new JLabel("Job Title");
		JobTitleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		JobTitleLabel.setBackground(Color.YELLOW);
		JobTitleLabel.setBounds(389, 402, 64, 23);
		frame.getContentPane().add(JobTitleLabel);
		
		JLabel DispalyStuffNoLabel = new JLabel("Stuff No");
		DispalyStuffNoLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		DispalyStuffNoLabel.setBackground(Color.YELLOW);
		DispalyStuffNoLabel.setBounds(521, 402, 64, 23);
		frame.getContentPane().add(DispalyStuffNoLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(10, 336, 616, 149);
		frame.getContentPane().add(panel);
		
		JLabel ManageHeadingLabel = new JLabel("Manage Searched Record");
		ManageHeadingLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 19));
		ManageHeadingLabel.setBounds(60, 496, 315, 34);
		frame.getContentPane().add(ManageHeadingLabel);
		
		DeleteButton = new JButton("Fire Stuff");
		DeleteButton.setToolTipText("remove stuff from employees");
		DeleteButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		DeleteButton.setBackground(Color.YELLOW);
		DeleteButton.setBounds(80, 536, 120, 28);
		frame.getContentPane().add(DeleteButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 206, 209));
		panel_1.setBounds(25, 528, 218, 45);
		frame.getContentPane().add(panel_1);
		
		JLabel DisplayAllLabel = new JLabel("Display ALL");
		DisplayAllLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		DisplayAllLabel.setBounds(263, 28, 135, 24);
		frame.getContentPane().add(DisplayAllLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(649, 258, -637, -20);
		frame.getContentPane().add(scrollPane);
		
		
		DeleteButton.setVisible(false);
		StuffTextField.setEditable(true);
		
		BackButton = new JButton("<<<");
		BackButton.setToolTipText("back");
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		BackButton.setBounds(0, 579, 89, 23);
		frame.getContentPane().add(BackButton);
		
		JLabel TitleMLabel = new JLabel("Title");
		TitleMLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		TitleMLabel.setBounds(10, 39, 50, 40);
		frame.getContentPane().add(TitleMLabel);
		
		JLabel NameMlabel = new JLabel("Name");
		NameMlabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		NameMlabel.setBounds(120, 39, 50, 40);
		frame.getContentPane().add(NameMlabel);
		
		JLabel SurnameMlabel = new JLabel("Surname");
		SurnameMlabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		SurnameMlabel.setBounds(216, 39, 81, 40);
		frame.getContentPane().add(SurnameMlabel);
		
		JLabel StaffIdMlabel = new JLabel("Stuff Id");
		StaffIdMlabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		StaffIdMlabel.setBounds(359, 39, 81, 40);
		frame.getContentPane().add(StaffIdMlabel);
		
		JLabel JbTitle_Mlabel = new JLabel("Job Title");
		JbTitle_Mlabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		JbTitle_Mlabel.setBounds(487, 39, 81, 40);
		frame.getContentPane().add(JbTitle_Mlabel);
		//********************************add functionality to the buttons***************
		ButtonHandler buttonH =new ButtonHandler(); //buttonHandler object typ
		DisplayButton.addActionListener(buttonH);
		SearchButton.addActionListener(buttonH);
		DeleteButton.addActionListener(buttonH);
		ClearButton.addActionListener(buttonH);
		BackButton.addActionListener(buttonH);
		
		
		
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
							DisplayTextArea.setText("");
							Reading();
							} //end of try
						catch (SQLException e) 
						   {
							JOptionPane.showMessageDialog(null, "Unexpected error try again");
							e.printStackTrace();
						  }	
					}//end of if
					else if(a.getSource()==SearchButton)
					{
						try {
							SearchData();
						    } //end of try
						catch (SQLException e) 
						    {
							JOptionPane.showMessageDialog(null,"Something went wrong try again");
						    }//end of catch
					}//end of else if
					else if(a.getSource()==DeleteButton)
					{
						try 
						{
							NameTextField.setText("");
							S_NameTextField.setText("");
							JTiltleTextField.setText("");
							DispaltStuffNoTextField.setText("");
							TitleTextField.setText("");
							delete();
							StuffTextField.setText("");
						} 
						catch(SQLIntegrityConstraintViolationException e)
						 {
							JOptionPane.showMessageDialog(null,"Staff Offering a service Cannot be Removed");
						 }//end of second catch
						catch (SQLException e) 
						{
							JOptionPane.showMessageDialog(null,"Unexpected error try again");
						}
						
					}//end of else
					else if(a.getSource()==ClearButton)
					{
						DisplayTextArea.setText("");
						StuffTextField.setText("");
						//disabling editing of the stufftext filed and hiding the delete button
						StuffTextField.setEditable(true);
						DeleteButton.setVisible(false);
					}//end of else
					else 
					{
						//Enabling the another frame 
						Admin_Functions window = new Admin_Functions();
						window.frame.setVisible(true);
						window.frame.setResizable(false);
						//disabling the current frame 
						frame.setVisible(false);
					}//end of else
					
			}//end of action performed
			}//end of actionListener
	//******************************************************************read method**************************************************
			public void Reading() throws SQLException 
			{
				List<Admin> list=data.StoreDetails();
				if(list.isEmpty()) 
				{
					JOptionPane.showMessageDialog(null,"NO staff Hired");
				}//end of if
	          else 
	          {
				for(int i=0;i<list.size();i++)
				{
			    	//getting data from the list
					Details = list.get(i);
					String name =  Details.getName();
					String surname=Details.getSurname();
					String title=Details.getTitle();
					String JobTitle=Details.getJobTitle();
					String Stuff_ID=Details.getStuffId();
					//****************************************************display in a textarea
					DisplayTextArea.append(title+"\t"+name+"\t"+surname+"\t"+Stuff_ID+"\t"+JobTitle+"\n");
					StuffTextField.setEditable(true); 						
				 }//************end of loop
		           }//end of else
			}
			//******************************************************************end of read method**************************************************
			//******************************************************************search method**************************************************
			public void SearchData() throws SQLException 
			{
				    name=StuffTextField.getText();//needs to be checked  scanning value in text area
				    List<Admin> list=data.search_Stuff(name);
				    
				    if(StuffTextField.getText().length() ==0) 
					 { JOptionPane.showMessageDialog(null,"empty search fiiled");
					
					 }
				    else if(list.isEmpty()) 
					{
						JOptionPane.showMessageDialog(null,"user does not exist");
					}
					
					else {
						
						for(int i=0;i<list.size();i++)
						{
							Details = list.get(i);//getting data from the list
					String Title=Details.getTitle();
					String Sname =  Details.getName();
					String Surname=Details.getSurname();
					String JobTiltle=Details.getJobTitle();
					String StuffID=Details.getStuffId();
					    
						NameTextField.setText(Sname);
						S_NameTextField.setText(Surname);
						JTiltleTextField.setText(JobTiltle);
						DispaltStuffNoTextField.setText(StuffID);
						TitleTextField.setText(Title);
						JOptionPane.showMessageDialog(null,"user "+name + " FOUND!!");
						//SETTING THE DELETE BUTTON TO TRUE and disabling the editing the textfield
						DeleteButton.setVisible(true);
						StuffTextField.setEditable(false);
						}//end of loop				
					}//end of else
			}//end of method
			//******************************************************************end search method**************************************************
			//******************************************************************delete method**************************************************
			public void delete() throws SQLException 
			{  
				name=StuffTextField.getText();//needs to be checked
			 if(StuffTextField.getText().length() ==0) 
			 {JOptionPane.showMessageDialog(null,"empty Search filed");}
			 
			 else {
				data.DeletingStaff(StuffTextField.getText());
				//hiding the delete button
				DeleteButton.setVisible(false);
				//enabling typing in the filed
				StuffTextField.setEditable(true);
				JOptionPane.showMessageDialog(null,"user "+name+ " FIRED!!");	
			 }
			}
}
//********************************************************************end of class

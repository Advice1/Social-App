package administration;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTextField;
import Admin_Service.Admin;
import javax.swing.JButton;

public class Staff_Display {

	public JFrame frame;
	private JTextField TitleTextField;
	private JTextField NameTextField;
	private JTextField jbTitleTextField;
	private JTextField surnameTextField;
	private JTextField stuffIdTextField;
	private JButton BckButton;
	private JButton prevButton;
	private JButton DisplayButton;
	private JButton NxtButton;
	private JButton ExitButton;
	private int Number=0;

	/**
	 * Launch the application.
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_Display window = new Staff_Display();
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
	public Staff_Display() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 250, 154));
		frame.setBounds(100, 100, 491, 459);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel HeadingLabel = new JLabel("                Stuff  Display  Page");
		HeadingLabel.setBackground(new Color(255, 0, 0));
		HeadingLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 27));
		HeadingLabel.setBounds(34, 29, 431, 44);
		frame.getContentPane().add(HeadingLabel);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setFont(new Font("Verdana Pro Black", Font.PLAIN, 16));
		NameLabel.setBounds(98, 126, 84, 31);
		frame.getContentPane().add(NameLabel);
		
		JLabel SurnameLabel = new JLabel("Surname");
		SurnameLabel.setFont(new Font("Verdana Pro Black", Font.PLAIN, 16));
		SurnameLabel.setBounds(98, 168, 84, 31);
		frame.getContentPane().add(SurnameLabel);
		
		JLabel JobTitleLabel = new JLabel("Job Title");
		JobTitleLabel.setFont(new Font("Verdana Pro Black", Font.PLAIN, 16));
		JobTitleLabel.setBounds(98, 255, 84, 31);
		frame.getContentPane().add(JobTitleLabel);
		
		JLabel StuffIdLabel = new JLabel("Stuff Id");
		StuffIdLabel.setFont(new Font("Verdana Pro Black", Font.PLAIN, 16));
		StuffIdLabel.setBounds(98, 213, 84, 31);
		frame.getContentPane().add(StuffIdLabel);
		
		JLabel TitleLabel = new JLabel("Title");
		TitleLabel.setFont(new Font("Verdana Pro Black", Font.PLAIN, 16));
		TitleLabel.setBounds(98, 84, 84, 31);
		frame.getContentPane().add(TitleLabel);
		
		TitleTextField = new JTextField();
		TitleTextField.setEditable(false);
		TitleTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		TitleTextField.setBounds(257, 92, 50, 20);
		frame.getContentPane().add(TitleTextField);
		TitleTextField.setColumns(10);
		
		NameTextField = new JTextField();
		NameTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		NameTextField.setEditable(false);
		NameTextField.setColumns(10);
		NameTextField.setBounds(257, 126, 140, 28);
		frame.getContentPane().add(NameTextField);
		
		jbTitleTextField = new JTextField();
		jbTitleTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		jbTitleTextField.setEditable(false);
		jbTitleTextField.setColumns(10);
		jbTitleTextField.setBounds(257, 258, 140, 28);
		frame.getContentPane().add(jbTitleTextField);
		
		surnameTextField = new JTextField();
		surnameTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		surnameTextField.setEditable(false);
		surnameTextField.setColumns(10);
		surnameTextField.setBounds(257, 171, 140, 28);
		frame.getContentPane().add(surnameTextField);
		
		stuffIdTextField = new JTextField();
		stuffIdTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		stuffIdTextField.setEditable(false);
		stuffIdTextField.setColumns(10);
		stuffIdTextField.setBounds(257, 216, 140, 28);
		frame.getContentPane().add(stuffIdTextField);
		
		prevButton = new JButton("Previous");
		prevButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		prevButton.setBounds(98, 316, 99, 23);
		frame.getContentPane().add(prevButton);
		
		DisplayButton = new JButton("Display");
		DisplayButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		DisplayButton.setBounds(211, 346, 89, 44);
		frame.getContentPane().add(DisplayButton);
		
		NxtButton = new JButton("Next");
		NxtButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		NxtButton.setBounds(317, 316, 99, 23);
		frame.getContentPane().add(NxtButton);
		
		BckButton = new JButton("<<<");
		BckButton.setToolTipText("Back");
		BckButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		BckButton.setBounds(0, 393, 99, 23);
		frame.getContentPane().add(BckButton);
		
		ExitButton = new JButton("X");
		ExitButton.setToolTipText("Exit");
		ExitButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		ExitButton.setBounds(0, 0, 55, 31);
		frame.getContentPane().add(ExitButton);
		//hiding both buttons
		prevButton.setVisible(false);
		NxtButton.setVisible(false);
		//********************************add functionality to the buttons***************
				ButtonHandler Abutton =new ButtonHandler(); //buttonHandler object type
				DisplayButton.addActionListener(Abutton);
				NxtButton.addActionListener(Abutton);
				prevButton.addActionListener(Abutton);
				BckButton.addActionListener(Abutton);
				ExitButton.addActionListener(Abutton);
	}
	//*******************************************************ActionListener Mathod**********************************************
		private class ButtonHandler implements ActionListener 
		{
			@Override
			public void actionPerformed(ActionEvent a) 
			{
				//+++++++++++++++++++++++++++++++++++++++Code for getting data from the Admin class++++++++++++++++ 
				Staff_Database data =new Staff_Database();//database class
				Admin Display = new Admin();//object of Admin class
				//
				if(a.getSource()==DisplayButton) 
				{
					try {
						
						List<Admin> list=data.StoreDetails();
						Display = list.get(Number);
						TitleTextField.setText(Display.getTitle());
						NameTextField.setText(Display.getName());
						jbTitleTextField.setText(Display.getJobTitle());
						surnameTextField.setText(Display.getSurname());
						stuffIdTextField.setText(Display.getStuffId());
						DisplayButton.setVisible(false);
						NxtButton.setVisible(true);
					} //end of try
					catch (SQLException e) 
					{
						JOptionPane.showMessageDialog(null, "something went wrong try again");
					}//end of catch
				}
				//************************************************************************************end of if
				else if(a.getSource()==NxtButton) 
				{
					//increment the number to move to the next person
					Number++;
					try {
						List<Admin> list=data.StoreDetails();
						Display = list.get(Number);
						TitleTextField.setText(Display.getTitle());
						NameTextField.setText(Display.getName());
						jbTitleTextField.setText(Display.getJobTitle());
						surnameTextField.setText(Display.getSurname());
						stuffIdTextField.setText(Display.getStuffId());
						 prevButton.setVisible(true);
						
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "Unexpected error try again");
					}//end of 1st catch
					catch(IndexOutOfBoundsException bound)
					{    NxtButton.setVisible(false); 
						JOptionPane.showMessageDialog(null, "End of list");	
						Number--;    //staying in the current position
					}//end of second catch
					
				}
				//***************************************************************************end of else if
				else if(a.getSource()==prevButton) 
				{
					//decrementing the number to move to the previous person
					Number--;
					try {
						
						List<Admin> list=data.StoreDetails();
						Display = list.get(Number);
						TitleTextField.setText(Display.getTitle());
						NameTextField.setText(Display.getName());
						jbTitleTextField.setText(Display.getJobTitle());
						surnameTextField.setText(Display.getSurname());
						stuffIdTextField.setText(Display.getStuffId());
						NxtButton.setVisible(true);
					}
					catch (SQLException e) 
					{
						JOptionPane.showMessageDialog(null, "Unexpected error try again");
					}//end of 1st catch
					catch(IndexOutOfBoundsException bound)
					{     prevButton.setVisible(false);
						JOptionPane.showMessageDialog(null, "begining of the list");	
						Number++;   //staying in the current position
					}//end of second catch
				}
				//*************************************************************************end of else if
				else if(a.getSource()==BckButton) 
				{
					Admin_Functions window = new Admin_Functions();
					window.frame.setVisible(true);
					//disabling the current frame
					frame.setVisible(false);
				}
				//***************************************************************************end of else if
				else if(a.getSource()==ExitButton) 
				{
					System.exit(0);
				}
				//***************************************************************************end of else if
				
				
			}//end of actionPerformed
		}//end of action listener
	
}
//end of class

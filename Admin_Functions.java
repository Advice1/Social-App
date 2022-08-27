package administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

import Admin_Service.Admin;
import multiImageRetrival.FriendDatabase;
import multiImageRetrival.Student;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;

public class Admin_Functions {

	public JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Functions window = new Admin_Functions();
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
	public Admin_Functions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.getContentPane().setLayout(null);
		
		JLabel HeadingLabel = new JLabel("ADMINISTRATION");
		HeadingLabel.setFont(new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 16));
		HeadingLabel.setBounds(119, 11, 228, 36);
		frame.getContentPane().add(HeadingLabel);
		
		//*********************************************************displaying stuff
		JButton stuffDisplayButton = new JButton("Dispaly");
		stuffDisplayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				Staff_Display window = new Staff_Display();
				window.frame.setVisible(true);
				window.frame.setResizable(false);
				//disabling the current frame
				frame.setVisible(false);
			}
		});
		//**********************************************************************
		stuffDisplayButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		stuffDisplayButton.setBounds(107, 112, 101, 23);
		frame.getContentPane().add(stuffDisplayButton);
		//*****************************************************hiring stuff
		JButton StuffAddbutton = new JButton("Add");
		StuffAddbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Cafeteria window = new Admin_Cafeteria();
				window.frame.setVisible(true);
				window.frame.setResizable(false);
				//disabling the current frame
				frame.setVisible(false);
			}
		});
		//*****************************************************************
		StuffAddbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		StuffAddbutton.setBounds(218, 112, 101, 23);
		frame.getContentPane().add(StuffAddbutton);
		//*****************************************************************managing stuff
		JButton StuffManageBttn = new JButton("Manage Users");
		StuffManageBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stuff_Manage window = new Stuff_Manage();
				window.frame.setVisible(true);
				window.frame.setResizable(false);
				//disabling the current frame
				frame.setVisible(false);
			}
		});
		//********************************************************************************
		StuffManageBttn.setFont(new Font("Tahoma", Font.BOLD, 14));
		StuffManageBttn.setBounds(148, 146, 136, 30);
		frame.getContentPane().add(StuffManageBttn);
		
		JPanel Stuffpanel = new JPanel();
		Stuffpanel.setBounds(67, 99, 315, 85);
		frame.getContentPane().add(Stuffpanel);
		
		JLabel StuffHeadingLabel = new JLabel("Stuff");
		StuffHeadingLabel.setFont(new Font("Verdana Pro Black", Font.BOLD | Font.ITALIC, 14));
		StuffHeadingLabel.setBounds(67, 72, 56, 23);
		frame.getContentPane().add(StuffHeadingLabel);
		
		JPanel Studentpanel = new JPanel();
		Studentpanel.setBounds(135, 217, 170, 64);
		frame.getContentPane().add(Studentpanel);
		//*******************************************************************************Managing students
		JButton StudentManageButton = new JButton("Manage Users");
		StudentManageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_DisplayAll window = new Admin_DisplayAll();
				window.frame.setVisible(true);
				window.frame.setResizable(false);
				//disabling the current frame
				frame.setVisible(false);
			}
		});
		Studentpanel.add(StudentManageButton);
		StudentManageButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		//********************************************************************************************************
		//******************************************************************************display student
		JButton StudendDisplaybttn = new JButton("Display");
		StudendDisplaybttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_View window = new Admin_View();
				window.frame.setVisible(true);
				window.frame.setResizable(false);
				//disabling the current frame
				frame.setVisible(false);
			}
		});
		Studentpanel.add(StudendDisplaybttn);
		StudendDisplaybttn.setFont(new Font("Tahoma", Font.BOLD, 14));
		//****************************************************************************************************
		JButton infor = new JButton("infor");
		infor.setBackground(SystemColor.menu);
		infor.setFont(new Font("Tahoma", Font.BOLD, 14));
		infor.setBounds(300, 58, 101, 23);
		frame.getContentPane().add(infor);
		
		JLabel studentHeadinglabel = new JLabel("Student");
		studentHeadinglabel.setFont(new Font("Verdana Pro Black", Font.BOLD | Font.ITALIC, 14));
		studentHeadinglabel.setBounds(67, 195, 94, 23);
		frame.getContentPane().add(studentHeadinglabel);
		
		JButton BackButton = new JButton("Back");
		BackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//enabling another frame
				Admin_Userinteface window = new Admin_Userinteface();
				window.frame.setVisible(true);
				window.frame.setResizable(false);
                //disabling current frame
				frame.setVisible(false);	
			}
		});
		BackButton.setBackground(Color.ORANGE);
		BackButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		BackButton.setBounds(50, 402, 351, 23);
		frame.getContentPane().add(BackButton);
		
		JPanel NoRegisteredpanel = new JPanel();
		NoRegisteredpanel.setBounds(77, 327, 267, 42);
		frame.getContentPane().add(NoRegisteredpanel);
	
		JButton NumberRegStufButton = new JButton("Stuff");
		//add fuctionality to the button
		//*******************************************************************registered stuff
		NumberRegStufButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent count) 
			{
				Staff_Database data =new Staff_Database();// staff database class
				Admin Details = new Admin();//object of Admin class
				
				try {
					List<Admin>list=data.counting();
					Details = list.get(0);
					String number=Details.getTitle();      // max number was stored here
					JOptionPane.showMessageDialog(null,""+number+ " employee/s");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Unexpected error try again");
					e.printStackTrace();
				}
			}
		});
		//***************************************************************************end
		NoRegisteredpanel.add(NumberRegStufButton);
		NumberRegStufButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		//**************************************adding functionality to student to get the max number of student
		JButton StudentButton = new JButton("Student");
		StudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				FriendDatabase data =new FriendDatabase();// staff database class
				Student Details = new Student();//object of Admin class
				
				try {
					List<Student>list=data.countingS();
					Details = list.get(0);
					String number=Details.getTweeter();            // max number was stored here
					JOptionPane.showMessageDialog(null,""+number+" Student/s");
				}//end of try
				catch (SQLException a) {
					JOptionPane.showMessageDialog(null,"Unexpected error try again");
					a.printStackTrace();
				}//end of catch	
			}
		});
		//***************************************************************************************end
		NoRegisteredpanel.add(StudentButton);
		StudentButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel RegisteredHeadinglabel = new JLabel("Number of Registered users");
		RegisteredHeadinglabel.setFont(new Font("Verdana Pro Black", Font.BOLD | Font.ITALIC, 14));
		RegisteredHeadinglabel.setBounds(67, 292, 269, 23);
		frame.getContentPane().add(RegisteredHeadinglabel);
		frame.setBounds(100, 100, 465, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

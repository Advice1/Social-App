package administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_Userinteface {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Userinteface window = new Admin_Userinteface();
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
	public Admin_Userinteface() {
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
		
		JLabel Heading = new JLabel("ADMINISTRATION");
		Heading.setBackground(Color.GREEN);
		Heading.setFont(new Font("Verdana Pro Black", Font.BOLD | Font.ITALIC, 15));
		Heading.setForeground(Color.BLACK);
		Heading.setBounds(109, 24, 216, 38);
		frame.getContentPane().add(Heading);
		
		JSlider slider = new JSlider();
		slider.setBounds(109, 61, 200, 26);
		frame.getContentPane().add(slider);
		//************************************************************8
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//enabling another frame
				Admin_Login window = new Admin_Login();
				window.frame.setVisible(true);
				//disabling current frame
				frame.setVisible(false);
			}
		});
		//*****************************************************************
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.setBounds(152, 126, 89, 23);
		frame.getContentPane().add(loginButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(199, 177, -60, -76);
		frame.getContentPane().add(desktopPane);
		
		JButton Registrationbutton = new JButton("Registration");
		Registrationbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				//enabling another frame
				Admin_Registration window = new Admin_Registration();
				window.frame.setVisible(true);
				//disabling current frame
				frame.setVisible(false);
			}
		});
		Registrationbutton.setFont(new Font("Tahoma", Font.BOLD, 13));
		Registrationbutton.setBounds(138, 168, 124, 23);
		frame.getContentPane().add(Registrationbutton);
		
		JButton BackBttn = new JButton("Back");
		BackBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//openinig another frame
				Admin_Start window = new Admin_Start();
				window.frame.setVisible(true);
				//disabling current frame
				frame.setVisible(false);
			}
		});
		BackBttn.setFont(new Font("Tahoma", Font.BOLD, 13));
		BackBttn.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(BackBttn);
	}
}

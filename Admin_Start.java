package administration;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Admin_Start {

	public JFrame frame;

	/**
	 * main gui
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Start window = new Admin_Start();
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
	public Admin_Start() {
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
		
		JButton StartButton = new JButton("START");
		StartButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Staff_Database Confirm = new Staff_Database();
				String product_Key=JOptionPane.showInputDialog("Activation Key");
				
				if(product_Key==null) 
				   {
					JOptionPane.showMessageDialog(null,"Field cannot be null");
				   }//end of if
				else if(product_Key.matches("[0-9]{7}")!=true) 
				   {
					JOptionPane.showMessageDialog(null,"Product key don't match specification check the manual");
				   }//end of if
				else if(product_Key.length()!=7) 
				   {
					JOptionPane.showMessageDialog(null,"product key Length deos not match refer to the manual");
				   }//end of if
				else {
				try {
					JOptionPane.showMessageDialog(null,"validating product key");
					Confirm.Administration_Login(product_Key);
					//Admin_Start window = new Admin_Start();
					frame.setVisible(false);
				    } //end of try
				catch (SQLException e1)
				        {
					JOptionPane.showMessageDialog(null,"Unexpected error try again");
					e1.printStackTrace();
				        }//end of catch
				     }//end of else
			}
		});
		StartButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		StartButton.setBounds(169, 119, 89, 47);
		frame.getContentPane().add(StartButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				System.exit(0);
			}
		});
		btnExit.setBackground(Color.ORANGE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(21, 219, 391, 31);
		frame.getContentPane().add(btnExit);
		
		JLabel HeadingLabel = new JLabel("WELCOME GET STARTED");
		HeadingLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		HeadingLabel.setBounds(32, 21, 367, 39);
		frame.getContentPane().add(HeadingLabel);
	}

}

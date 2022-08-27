  package administration;


import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;


public class FoodMenu {

	static private JFrame frame;
	static private JButton backButton, orderButton;
	private static JButton orderButton_1;
	static private JTextField textField;
	static private GridBagConstraints gbc;
	private JTable table;
	DefaultTableModel dtm;
	Double[] price;
	Double[] priceDrinks;
	Double[] priceDesserts;
	double totalPrice = 0;
	double p1, p2, p3, p4, p5, p6, p7, p8, p9;
	double d1, d2, d3, d4, d5;
	double de1, de2;

	private JSpinner[] numSpinner;
	static private JLabel[] foodLabel;
	static private JLabel[] foodImage;
	private String[] file;

	int quantity;
	int rows;
	
	private JSpinner spinner_2;
	private JSpinner[] numSpinnerDrinks;
	static private JLabel[] drinkLabel;
	static private JLabel[] drinkImage;
	private String[] fileDrinks;

	private JSpinner[] numSpinnerDesserts;
	static private JLabel[] dessertLabel;
	static private JLabel[] dessertImage;
	private String[] fileDesserts;

	private static final int ELEMENTS = 9;
	private static final int DRINK_ELEMENTS = 5;
	private static final int DESSERT_ELEMENTS = 2;

	double total = 0;
	double food1, food2, food3, food4, food5, food6, food7, food8, food9;
	double drink1, drink2, drink3, drink4, drink5;
	double pr, pr1;

	double totalForFoods;
	double totalForDrinks;
	double totalForDesserts;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodMenu window = new FoodMenu();
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
	public FoodMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Main Menu ");
		frame.setBounds(100, 100, 750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		JLabel lblFoodOrdered = new JLabel("Food Ordered");
		lblFoodOrdered.setBounds(529, 11, 81, 14);

		frame.getContentPane().add(lblFoodOrdered);

		table = new JTable();
		backButton = new JButton();
		orderButton = new JButton();
		dtm = new DefaultTableModel(0, 0);
		final String header[] = new String[] { "Item", "Qty", "Price", "Spinner" };
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
												
		JOptionPane.showMessageDialog(null, "just checking the menu");
		JLabel lblTotal = new JLabel("Total  : ");
		lblTotal.setBounds(519, 340, 46, 14);
		frame.getContentPane().add(lblTotal);
		textField = new JTextField();
		textField.setBounds(585, 340, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		orderButton_1 = new JButton("Order");
		orderButton_1.setBounds(500, 385, 89, 23);
		frame.getContentPane().add(orderButton_1);
		backButton = new JButton("Back");
		backButton.setBounds(610, 385, 89, 23);
		frame.getContentPane().add(backButton);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		tabbedPane.setBounds(18, 11, 450, 450);
		frame.getContentPane().add(tabbedPane);
		
		JButton ProfileButton = new JButton("PROFILE");
		ProfileButton.setBackground(Color.MAGENTA);
		ProfileButton.setBounds(500, 424, 199, 23);
		frame.getContentPane().add(ProfileButton);
		
		JSpinner spinner = new JSpinner();
		spinner.setEnabled(false);
		
		spinner.setBounds(500, 84, 65, 20);
		frame.getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setForeground(Color.RED);
		spinner_1.setEnabled(false);
		spinner_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				spinner_2.setEnabled(false);
				spinner_1.setEnabled(true);
			}
		});
		spinner_1.setBounds(500, 126, 65, 20);
		frame.getContentPane().add(spinner_1);
		
	    spinner_2 = new JSpinner();
		spinner_2.setEnabled(false);
		spinner_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				spinner_2.setEnabled(true);
				//spinner_2.setVisible(true);
				spinner_1.setValue(0);
				spinner_1.setEnabled(false);
				
				System.out.println("hello hello hello");
			}
		});
		
		spinner_2.setBounds(500, 171, 65, 20);
		frame.getContentPane().add(spinner_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(500, 232, 89, 23);
		frame.getContentPane().add(btnNewButton);
		frame.setVisible(true);
		
		// add Button
		ButtonHandler handler = new ButtonHandler();
		orderButton_1 .addActionListener(handler);
		
		mouse clickz = new mouse();
		//clickz
		
	}
	
	private class mouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
			
		}}
	

	  private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource()==orderButton_1)
			{
				rows = table.getRowCount();
				
				for (int row = 0; row < rows; row++) {
				if (dtm.getValueAt(row, 0).equals("Salad")) {
					
					System.out.println(p1*quantity+"\tQTY"+quantity+"\trow"+2);
				}
                 
				else if (dtm.getValueAt(row, 0).equals("Japanese Noodles")) {
					System.out.println(p2*quantity+"\tQTY"+quantity+"\trow"+2);
				}
				
				
				
				/*else {
				System.out.println(p2*quantity+"\tQTY"+quantity+"\trow"+2);
				System.out.println(p3*quantity+"\tQTY"+quantity+"\trow"+2);
				System.out.println(p4*quantity+"\tQTY"+quantity+"\trow"+2);*/
				}
				
			}
		
		 
			
		}// end of actionPerformed method 
		  
		  
		  
		  
		  
		  
	  }//end of inner class ButtonHandler
}

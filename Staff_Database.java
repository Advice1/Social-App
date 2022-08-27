package administration;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import Admin_Service.Admin;
import ProffesionalService.StorageProfessionalService;
import orderStoreroom.O_Storeroom;

public class Staff_Database {
	//instance variable 
			private String username="root";
			private String password="Nxumalo#1";
			private String url="jdbc:mysql://127.0.0.1:3306/login";
			private Connection connect;
			private PreparedStatement preparedS;
			private ResultSet set;

	public Staff_Database() {
	}
	
	//##############establishing a connection to a database###########
			public void Establish_connection() throws SQLException 
			{
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connect=(Connection) DriverManager.getConnection(url, username, password);
					//JOptionPane.showMessageDialog(null, "connected to database");
				    } catch (ClassNotFoundException e) {
					e.printStackTrace();
				    }
				
			}
			//#############end of connection mathod##################### 
			//###############################################################################################registering stuff and display registered stuff#######################
			//***********************************admin registration and login section
			public void Administration_Register(String Title,String Name,String Password,String ConfirmPass) throws SQLException 
			{
				Establish_connection();
				String sql="insert into Administrator(Title,First_Name,Password,Confirm_Pass) values(?,?,?,?)";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.setString(1, Title);
				preparedS.setString(2,  Name);
				preparedS.setString(3,  Password);
				preparedS.setString(4,  ConfirmPass);
				preparedS.executeUpdate();
								
			}
			/////////
			public void Administration_Login(String product_Key) throws SQLException 
			{
				Establish_connection();
				String sql="select * from software_product_key where product_key='"+product_Key+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				set=preparedS.executeQuery();
				if(set.next())
				{
					JOptionPane.showMessageDialog(null, "welcome");
					Admin_Userinteface window = new Admin_Userinteface();
					window.frame.setVisible(true);
					//
				}
				else {
					JOptionPane.showMessageDialog(null, "Product key not valid");
				    }//end of else
								
			}
			//****************************************end of admin registration and login section
			//##############adding stuff to the database##############
			public void AddingStaff(String title,String name,String sur,String JobTitle,String category,String password,String EmployeeId) throws SQLException 
			{
				Establish_connection();
				String sql="insert into Staff_Admin(Title,Name,Surname,Job_Title,Category,Staff_id,password) values(?,?,?,?,?,?,?)";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.setString(1, title);
				preparedS.setString(2,  name);
				preparedS.setString(3,  sur);
				preparedS.setString(4,  JobTitle);
				preparedS.setString(5,category);
				preparedS.setString(6, password);
				preparedS.setString(7, EmployeeId);
			
				preparedS.executeUpdate();	
			}
			//*************************************end of insert data method***********************************
			//counting the number of regiserrd stuff
			public List<Admin> counting() throws SQLException 
			{
				Establish_connection();
				Admin Storage =null;  // object of the storage class __Admin class
				List<Admin> ListOfAdmin=new ArrayList<Admin>(); //forming an array list of Admin class
				String sql="select COUNT(Staff_id) FROM Staff_Admin";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				set=preparedS.executeQuery();
				while(set.next())  
				    {
					Storage=new Admin();  //creating an object of Admin
					// storing data in Storage object
					Storage.setTitle(set.getString(1));
					ListOfAdmin.add(Storage);
					}
				return ListOfAdmin;	
			}
			//end of counting method
			//**************************************Storing details to the Admin class********
			public List<Admin> StoreDetails() throws SQLException 
			{
				Establish_connection();
				Admin Storage =null;  // object of the storage class __Admin class
				List<Admin> ListOfAdmin=new ArrayList<Admin>(); //forming an array list of Admin class
				String sql="select Title,Name,Surname,Job_Title,Category,Staff_id from Staff_Admin ";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				set=preparedS.executeQuery();
				while(set.next())
				{
					Storage=new Admin();  //creating an object of Admin
					// storing data in Storage object
					Storage.setTitle(set.getString(1));
					Storage.setName(set.getString(2));
					Storage.setSurname(set.getString(3));
					Storage.setJobTitle(set.getString(4));
					Storage.setService(set.getString(5));
					Storage.setStuffId(set.getString(6));
					
					ListOfAdmin.add(Storage);//populating the list
				}
				return ListOfAdmin;
			}
			//*******************************end method *************************
			//++++++++++++++++++++++searching for stuff method
			public List<Admin> search_Stuff(String Stuff_Id) throws SQLException 
			{
				Admin DetailSearch =null;  // object of the Admin
				List<Admin> List_Information=new ArrayList<Admin>(); //forming an array list of Admin class
				Establish_connection();
				String sql="select Title,Name,Surname,Job_Title,Staff_id from staff_admin where Staff_id='"+Stuff_Id+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				set=preparedS.executeQuery();
				while(set.next())
				{
					DetailSearch=new Admin();   //creating an object of Admin
					
					DetailSearch.setTitle(set.getString(1));
					DetailSearch.setName(set.getString(2));
					DetailSearch.setSurname(set.getString(3));
					DetailSearch.setJobTitle(set.getString(4));
					DetailSearch.setStuffId(set.getString(5));
					List_Information.add(DetailSearch);
				}
				return List_Information;
			}
			//++++++++++++++++++++++end of search method
			//****************************Deleting users by manager*********************
			public void DeletingStaff(String Stuff_Id) throws SQLException
			{
				Establish_connection();
				String sql="delete from staff_admin where Staff_id='"+Stuff_Id+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.executeUpdate();	
			}
  //****************************end Deleting users by manager*********************
			//####################################################################################################################end of stuff adding and displayingand managing section
			//********************************************insert data*************************************
			public void Food_Service(String prod_Name,String StaffId,Float price,String location,String Building,String BuidingNo,String Decription,InputStream input) throws SQLException 
			{
				Establish_connection();
				String sql="insert into business_Admin(name,Staff_id,price,Location,building,Building_No,description,product_picture) values(?,?,?,?,?,?,?,?)";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.setString(1,  prod_Name);
				preparedS.setString(2, StaffId);
				preparedS.setFloat(3,  price);
				preparedS.setString(4,location);
				preparedS.setString(5, BuidingNo);
				preparedS.setString(6, Building);
				preparedS.setString(7,  Decription);
				preparedS.setBinaryStream(8, input);
				
				preparedS.executeUpdate();
				
			}
			//*************************************end of insert data method***********************************
			//**************************************Storing Display Service Offer dAdmin to the Bussiness class********
			public List<StorageProfessionalService> DisplayServiceOfferdAdmin() throws SQLException 
			{
				Establish_connection();
				StorageProfessionalService Storage =null;  // object of the storage class __Business class
				List<StorageProfessionalService> ListOfStaffServices=new ArrayList<StorageProfessionalService>(); //forming an array list of storageProjectService class
				
				String sql="select name,Staff_id,price,Location,building,Building_No,description,Item_No from Business_Admin";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				set=preparedS.executeQuery();
				
				while(set.next())
				{
					Storage=new StorageProfessionalService();  //creating an object of StorageImage
					// storing data in StorageImage object
					Storage.setName(set.getString(1));
					Storage.setUsername(set.getString(2));     //username equals staff number
					Storage.setPrize(set.getFloat(3));
					
					Storage.setTown(set.getString(4));
					Storage.setBuilding(set.getString(5));
					Storage.setBuildingNo(set.getString(6));
					Storage.setDescription(set.getString(7));
					Storage.setItemNumber(set.getInt(8));
					
					ListOfStaffServices.add(Storage);//populating the list
				}
				return ListOfStaffServices;
			}
			//*******************************end method *************************
			
			//###*******************************method for retrieving product images to display in the main page *************************
			public byte[] RetriveImage(String Prod_Name){
				byte[] image =null;
				try {
					Establish_connection();
					String sqla="select product_Picture from Business_Admin where Name=?";
					preparedS=(PreparedStatement) connect.prepareStatement(sqla);
					preparedS.setString(1, Prod_Name);
					set=preparedS.executeQuery();
					if(set.next())
					{
						image=set.getBytes(1);
					}
					
				} catch (SQLException e) 
				{
					e.printStackTrace();
					System.out.println("error happened here");
				}
				return image;
			}
			//******************************* end of retriving method to main  ****************************
			//###******************************* end method for retrieving product images to display in the main page *************************
			//*******************************method for displaying services offered by staff*************************
			public List<StorageProfessionalService> displayService(String Stfnumber) throws SQLException 
			{
				StorageProfessionalService Storage =null;  // object of the image class
				List<StorageProfessionalService> detailList=new ArrayList<StorageProfessionalService>(); //forming an array list of StorageImage class
				Establish_connection();
				String Sql=" select name,Staff_id,price,Location,building,Building_No,description,Item_No from Business_Admin  where staff_Id='"+Stfnumber+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(Sql);
				set=preparedS.executeQuery();
				while(set.next())
				{
					Storage=new StorageProfessionalService();  //creating an object of StorageProfessionalService
					// storing data in StorageImage object
					Storage.setName(set.getString(1));
					Storage.setUsername(set.getString(2));     //username equals staff number
					Storage.setPrize(set.getFloat(3));
					Storage.setTown(set.getString(4));
					Storage.setBuilding(set.getString(5));
					Storage.setBuildingNo(set.getString(6));
					Storage.setDescription(set.getString(7));
					Storage.setItemNumber(set.getInt(8));
			
					detailList.add(Storage);//populating the list
				}
				return detailList;
			}
			//*******************************end method *************************
			//******************************display product picture image method offered by staff *************************
			public byte[] DisplayProductImage(String product_Name,String Staff){
				byte[] image =null;
				try {
					Establish_connection();
					String sqla="select product_Picture from Business_Admin where Name=? and Staff_id=? ";
					preparedS=(PreparedStatement) connect.prepareStatement(sqla);
					preparedS.setString(1, product_Name);
					preparedS.setString(2, Staff);
					set=preparedS.executeQuery();
					if(set.next())
					{
						image=set.getBytes(1);
					}//end of else	
				}//end of try 
				catch (SQLException e) 
				{
					e.printStackTrace();
					System.out.println("error happened here");	
				}
				return image;
			}
		//****************************************end of dispalying  piciture of a product method
			//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ method for updating staff service
			//********************************************verify login details*************************************
			public void UpdateStaff_Service(String prod_Name,Float price,String location,String Building,String BuidingNo,String Decription,InputStream input,String StaffId,String ItemNo) throws SQLException 
			{
				Establish_connection();
				String sql="update business_Admin set name=?,price=?,Location=?,building=?,Building_No=?,description=?,product_picture=?  where staff_id='"+StaffId+"' and Item_No='"+ItemNo+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.setString(1,  prod_Name);
				preparedS.setFloat(2,  price);
				preparedS.setString(3,location);
				preparedS.setString(4, BuidingNo);
				preparedS.setString(5, Building);
				preparedS.setString(6,  Decription);
				preparedS.setBinaryStream(7, input);
						
				preparedS.executeUpdate();
			}
			//*************************************end of updating data method***********************************
			//****************************************************************displaying default values when updating staff service
			public List<StorageProfessionalService> displayDefaultService(String Stfnumber) throws SQLException 
			{
				StorageProfessionalService Storage =null;  // object of the image class
				List<StorageProfessionalService> detailList=new ArrayList<StorageProfessionalService>(); //forming an array list of StorageImage class
				Establish_connection();
				String sqla="select name,Staff_id,price,Location,building,Building_No,description from Business_Admin where Staff_id='"+Stfnumber+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sqla);
				set=preparedS.executeQuery();
				
				while(set.next())
				{
					Storage=new StorageProfessionalService();  //creating an object of StorageProfessionalService
					// storing data in StorageImage object
					Storage.setName(set.getString(1));
					Storage.setUsername(set.getString(2));     //username equals staff number
					Storage.setPrize(set.getFloat(3));
					Storage.setTown(set.getString(4));
					Storage.setBuilding(set.getString(5));
					Storage.setBuildingNo(set.getString(6));
					Storage.setDescription(set.getString(7));
					
					detailList.add(Storage);//populating the list
				}
				return detailList;
			}
			//*******************************end method *************************
			//*********************updating staff password**********
			//************************************updating password
			public void UpdateStaffPassword(String password,String staff_Number) throws SQLException 
		    {
		    	Establish_connection();
		    	String sql="update staff_admin set password=? where staff_id='"+staff_Number+"'";
		    	preparedS=(PreparedStatement) connect.prepareStatement(sql);
		    	preparedS.setString(1, password);
		    	preparedS.execute();
		    	
		    }
			//************************************end updating password
			//#########################################################################order methods#############################
			//*************************************oder method    processed by JSP
			public void OderFood(String ItemNo,String Product_name,String Username,String ContactNo,String description,String Status,String contact_Option) throws SQLException 
			{
				Establish_connection();
				String sql="insert into Cafe_Orders(Item_No,P_Name,User,contact_No,Instructions,Status,Contact_Option) values(?,?,?,?,?,?,?)";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.setString(1,ItemNo);
				preparedS.setString(2,  Product_name);
				preparedS.setString(3,  Username);
				preparedS.setString(4,ContactNo);
				preparedS.setString(5, description);
				preparedS.setString(6,Status);
				preparedS.setString(7,contact_Option);
				
				preparedS.executeUpdate();
			}
		   //**************************************end of order method*****************
			public  List<O_Storeroom> Cafeteria_Oder_Status(String StudentId) throws SQLException
			{
				Establish_connection();
				O_Storeroom storage=null;
				List<O_Storeroom> ListOfOrders=new ArrayList<O_Storeroom>();
				String sql="select P_Name,Instructions,Status,id from Cafe_Orders where user='"+StudentId+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				set=preparedS.executeQuery();
				while(set.next())
				{
					storage=new O_Storeroom();
					storage.setProduct_Name(set.getString(1));
					storage.setIntructions(set.getString(2));
					storage.setStatus(set.getString(3));
					storage.setItem_No(set.getInt(4));
					
					ListOfOrders.add(storage);
				}
				return ListOfOrders;
			}
			//***************************************************end of mathod
			//*******************cafeteria admin
			public  List<O_Storeroom> Manage_Oder_Status(String Staff_Id) throws SQLException
			{
				Establish_connection();
				O_Storeroom storage=null;
				List<O_Storeroom> ListOfOrders=new ArrayList<O_Storeroom>();   //an array list of o_storeroom
				String sql="select P_Name,User,Contact_No,Instructions,Status,Contact_Option,id from Cafe_Orders,business_admin  where business_admin.item_no=cafe_orders.item_no  and Staff_id='"+Staff_Id+"'"; //joining tables
				preparedS=(PreparedStatement) connect.prepareStatement(sql); 
				set=preparedS.executeQuery();
				while(set.next())
				{
					storage=new O_Storeroom();
					
					storage.setProduct_Name(set.getString(1));
					storage.setClient(set.getString(2));
					storage.setContactNo(set.getString(3));
					storage.setIntructions(set.getString(4));
					storage.setStatus(set.getString(5));
					storage.setContact_Option(set.getString(6));
					storage.setItem_No(set.getInt(7));
						
					ListOfOrders.add(storage);
				}
								
				return ListOfOrders;
			}
			//end of service provider manage method
			/*update method they use jsp */
			//**************************************************service provider updating details    
			public void updateStatus(String OrderNo,String status) throws SQLException 
			{
				Establish_connection();
				String sql="update  cafe_orders set Status=? where id='"+OrderNo+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.setString(1, status);
				preparedS.executeUpdate();
			}
			//end of method update method
			//**************************************************service provider removing Order details
			public void delet_Processed_Orders(String OrderNo) throws SQLException 
			{
				Establish_connection();
				String sql="delete from cafe_Orders where Id='"+OrderNo+"'";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.executeUpdate();
			}
			
			//end of removing Order details method 
			//**************************************************deleting order details
			//**************************************************service provider removing Order details
			public void Remove_service_offered(String ItemNo ,String Staff_id) throws SQLException 
			{
				Establish_connection();
				String sql="delete from business_admin where Item_No='"+ ItemNo+"' and Staff_id='"+Staff_id+"' ";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.executeUpdate();
			}
			//end of removing Order details method 
			//**************************************************deleting order details
			public void deletMy_Cafe_Oders(String itemNumber,String studentId) throws SQLException 
			{
				Establish_connection();
				String sql="delete from cafe_orders  where Id=? and User=? ";
				preparedS=(PreparedStatement) connect.prepareStatement(sql);
				preparedS.setString(1,itemNumber);
				preparedS.setString(2, studentId);
				preparedS.executeUpdate();
			}
			//end of mathod delete method
			//#########################################################################end of order methods#############################
			
}

package design;


import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.jdbc.*;
import ProffesionalService.StorageProfessionalService;
import orderStoreroom.O_Storeroom;

public class Database extends HttpServlet {
	//instance variable 
		private String username="root";
		private String password="Nxumalo#1";
		private String url="jdbc:mysql://127.0.0.1:3306/login";
		private Connection connect;
		private PreparedStatement preparedS;
		private ResultSet set;
		HttpServletRequest request;
		HttpServletResponse response;

	//##############establishing a connection to a database###########
		public void Establish_connection() throws SQLException 
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connect=(Connection) DriverManager.getConnection(url, username, password);
			    }
			catch (ClassNotFoundException e) 
			     {
				e.printStackTrace();
			    }
		}
		//#############end of connection mathod##################### 
		//##############inserting data to database##############
		public void insert_data(String name,String sur,String department,String password,String SdId,InputStream Input,String faceB,String tweet,String insta,String rep) throws SQLException 
		{
			Establish_connection();
			String sql="insert into registration2 values(?,?,?,?,?,?,?,?,?,?)";
			preparedS=(PreparedStatement) connect.prepareStatement(sql);
			preparedS.setString(1,  name);
			preparedS.setString(2,  sur);
			preparedS.setString(3, department);
			preparedS.setString(4,password);
			preparedS.setString(5, SdId);
			preparedS.setBinaryStream(6,  Input);
			preparedS.setString(7, faceB);
			preparedS.setString(8, tweet);
			preparedS.setString(9, insta);
			preparedS.setString(10, rep);
			
			preparedS.executeUpdate();
		}
		//*************************************end of insert data method***********************************
	//##############################################################################update methods###############################
		//**************************************updating profile pic method********************************
		public void insertDataa(InputStream input,String StNumber) throws SQLException 
	    {
	    	
	    	Establish_connection();
	    	String sql="update registration2 set Picture=? where Student_Number='"+StNumber+"'";
	    	preparedS=(PreparedStatement) connect.prepareStatement(sql);
	    	preparedS.setBinaryStream(1, input);
	    	preparedS.execute();
	    }
		//*************************************end of update method
		//************************************updating price
		public void UpdatePrice(float price,String username) throws SQLException 
	    {
	    	Establish_connection();
	    	String sql="update StudentService set prize=? where username='"+username+"'";
	    	preparedS=(PreparedStatement) connect.prepareStatement(sql);
	    	preparedS.setFloat(1, price);
	    	preparedS.execute();
	    }
		//************************************end updating price
		//**************************************updating profile pic method********************************
				public void updateServiceDetails_pic(String name,String service,String description,String Town,String Building,String Building_No,InputStream input,String username) throws SQLException 
			    {
			    	
			    	Establish_connection();
			    	String sql="update StudentService set Name=?,service=?,description=?,town=?,Building=?,Building_No=?,picture=? where username='"+username+"'";
			    	preparedS=(PreparedStatement) connect.prepareStatement(sql);
			    	preparedS.setString(1,  name);
					preparedS.setString(2,  service);
					preparedS.setString(3, description);
					//*************separate reference table******
					preparedS.setString(4, Town);
					preparedS.setString(5, Building);
					preparedS.setString(6, Building_No);
					//*********************************
					preparedS.setBinaryStream(7,  input);
			    	preparedS.execute();
			    }
				//*************************************end of update method
		//#############################################################################end of update method
		//*************************************Professional service registration
		public void RegistrationService(String username,String name,String service,Float prize,String description,String Town,String Building,String BuildingNo,InputStream input) throws SQLException 
		{
			Establish_connection();
			System.out.println("deos connect");
			String sql="insert into StudentService(username,name,service,prize,description,town,building,Building_No,picture) values(?,?,?,?,?,?,?,?,?)";
			preparedS=(PreparedStatement) connect.prepareStatement(sql);
			
			preparedS.setString(1, username);
			preparedS.setString(2,  name);
			preparedS.setString(3,  service);
			preparedS.setFloat(4,prize);
			preparedS.setString(5, description);
			//*************separate reference table******
			preparedS.setString(6, Town);
			preparedS.setString(7, Building);
			preparedS.setString(8, BuildingNo);
			//*********************************
			preparedS.setBinaryStream(9,  input);

			preparedS.executeUpdate();
		}
	   //**************************************end of professional service registration*****************
		//############################################################################################################################
		//*************************************oder method
				public void OderService(String id,String Product_name,String Username,String ContactNo,String description,String contact_Option,String Status) throws SQLException 
				{
					Establish_connection();
					String sql="insert into orders(Id,P_Name,User,contact_No,Status,Instruction_infor,Contact_Option) values(?,?,?,?,?,?,?)";
					preparedS=(PreparedStatement) connect.prepareStatement(sql);
					
					preparedS.setString(1,id);
					preparedS.setString(2,  Product_name);
					preparedS.setString(3,  Username);
					preparedS.setString(4,ContactNo);
					preparedS.setString(5,Status);
					preparedS.setString(6, description);
					preparedS.setString(7, contact_Option);
			
					preparedS.executeUpdate();
				}
			   //**************************************end of order method*****************
				//***************************************dispalying items ordered
				public  List<O_Storeroom> View_Oder_Status(String StudentId) throws SQLException
				{
					Establish_connection();
					O_Storeroom storage=null;
					List<O_Storeroom> ListOfOrders=new ArrayList<O_Storeroom>();
					String sql="select P_Name,Status,Item_No from Orders where user='"+StudentId+"'";
					preparedS=(PreparedStatement) connect.prepareStatement(sql);
					set=preparedS.executeQuery();
					while(set.next())
					{
						storage=new O_Storeroom();
						
						storage.setProduct_Name(set.getString(1));
						storage.setStatus(set.getString(2));
						storage.setItem_No(set.getInt(3));
								
						ListOfOrders.add(storage);
					}
					return ListOfOrders;
				}
				//***************************************************end of mathod
				//*****************************service provider manage orders mathod
				public  List<O_Storeroom> Manage_Oder_Status(String StudentId) throws SQLException
				{
					Establish_connection();
					O_Storeroom storage=null;
					List<O_Storeroom> ListOfOrders=new ArrayList<O_Storeroom>();
					String sql="select P_Name,User,contact_No,Status,Instruction_infor,Contact_Option,Item_No from Orders,studentservice where studentservice.id=orders.id and username='"+StudentId+"'"; //joining tables
					preparedS=(PreparedStatement) connect.prepareStatement(sql);
					set=preparedS.executeQuery();
					while(set.next())
					{
						storage=new O_Storeroom();
						
						storage.setProduct_Name(set.getString(1));
						storage.setClient(set.getString(2));
						storage.setContactNo(set.getString(3));
						storage.setStatus(set.getString(4));
						storage.setIntructions(set.getString(5));
						storage.setContact_Option(set.getString(6));
						storage.setItem_No(set.getInt(7));
						
						ListOfOrders.add(storage);
					}			
					return ListOfOrders;
				}
				//end of service provider manage method 
				/*update method they use jsp */
				//**************************************************service provider updating details    
				public void updateStatus(String Item_No,String state) throws SQLException 
				{
					Establish_connection();
					String sql="update  Orders set Status=? where Item_No='"+Item_No+"'";
					preparedS=(PreparedStatement) connect.prepareStatement(sql);
					preparedS.setString(1, state);
					preparedS.executeUpdate();
				}
				//end of mathod udate mathod
				//**************************************************service provider deleting detail
				public void deletStatus(String Item_No) throws SQLException 
				{
					Establish_connection();
					String sql="delete from Orders where Item_No='"+Item_No+"' ";
					preparedS=(PreparedStatement) connect.prepareStatement(sql);
					preparedS.executeUpdate();
				}
				
				//end of mathod delete method
				//**************************************************service provider deleting details
				public void deletMyOders(String itemNumber ,String studentId ) throws SQLException 
				{
					Establish_connection();
					String sql="delete from Orders where Item_No=? and  User='"+studentId+"' ";
					preparedS=(PreparedStatement) connect.prepareStatement(sql);
					preparedS.setString(1,itemNumber);
					preparedS.executeUpdate();
				}
				//end of mathod delete method
		//############################################################################################################
		//**************************************Storing details to the storageProfessional class********
		public List<StorageProfessionalService> StoreDetails() throws SQLException 
		{
			Establish_connection();
			StorageProfessionalService Storage =null;  // object of the storage class __storageProjectService class
			List<StorageProfessionalService> ListOfServices=new ArrayList<StorageProfessionalService>(); //forming an array list of storageProjectService class
			
			String sql="select id,username,name,service,prize,description,town,building,Building_No,picture from StudentService";
			preparedS=(PreparedStatement) connect.prepareStatement(sql);
			set=preparedS.executeQuery();
			while(set.next())
			{
				Storage=new StorageProfessionalService();  //creating an object of StorageImage
				// storing data in StorageImage object
				Storage.setItemNumber(set.getInt(1));
				Storage.setUsername(set.getString(2));
				Storage.setName(set.getString(3));
				Storage.setService(set.getString(4));
				Storage.setPrize(set.getFloat(5));
				Storage.setDescription(set.getString(6));
				Storage.setBuilding(set.getString(8));
				Storage.setBuildingNo(set.getString(9));
				Storage.setTown(set.getString(7));
			
				ListOfServices.add(Storage);//populating the list
			}
			return ListOfServices;
		}
		//*******************************end method *************************
		//*******************************method for retriving images to diplay in the main page *************************
		public byte[] RetriveImage(String username){
			byte[] image =null;
			try {
				Establish_connection();
				String sqla="select Picture from StudentService where username=?";
				preparedS=(PreparedStatement) connect.prepareStatement(sqla);
				preparedS.setString(1, username);
				set=preparedS.executeQuery();
				
				if(set.next())
				{
					image=set.getBytes(1);
				}
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return image;
		}
		//******************************* end of retriving method to main  *******************************************************
		//*******************************method for dispalying services offered by a user*************************
				public List<StorageProfessionalService> updateService(String number) throws SQLException 
				{
					StorageProfessionalService Storage =null;  // object of the StorageProfessionalService class
					List<StorageProfessionalService> detailList=new ArrayList<StorageProfessionalService>(); //forming an array list of StorageImage class
					Establish_connection();
					String sqla="select username,name,service,prize,description,town,building,Building_No from StudentService where username='"+number+"'";
					preparedS=(PreparedStatement) connect.prepareStatement(sqla);
					set=preparedS.executeQuery();
					while(set.next())
					{
						Storage=new StorageProfessionalService();  //creating an object of StorageProfessionalService
						// storing data in StorageImage object
						Storage.setUsername(set.getString(1));
						Storage.setName(set.getString(2));
						Storage.setService(set.getString(3));
						Storage.setPrize(set.getFloat(4));
						Storage.setDescription(set.getString(5));
						Storage.setTown(set.getString(6));
						Storage.setBuilding(set.getString(7));
						Storage.setBuildingNo(set.getString(8));
					
						detailList.add(Storage);//populating the list
					}
					return detailList;
				}
				//*******************************end method *************************
				//*******************************Displaying the number of orders offered by a user
				public List<StorageProfessionalService> Number_of_order(String StudentNo) throws SQLException 
				{
					StorageProfessionalService Storage =null;  // object of the StorageProfessionalService class
					List<StorageProfessionalService> NumberOfOrders=new ArrayList<StorageProfessionalService>();
					Establish_connection();
					String sqla=" select count(Item_No) from studentservice, orders where username='"+StudentNo+"';";
					preparedS=(PreparedStatement) connect.prepareStatement(sqla);
					set=preparedS.executeQuery();
					while(set.next())
					{
			        	Storage=new StorageProfessionalService();  //creating an object of StorageProfessionalService
						// storing data in StorageImage object
						Storage.setNumber_Of_Orders(set.getInt(1));
						NumberOfOrders.add(Storage);
					}
					return NumberOfOrders;
				}
				//end of displaying order method
				//******************************display product pic image mathod for user *************************
				public byte[] DisplayProductImage(String studentNumber){
					byte[] image =null;
					try {
						Establish_connection();
						String sqla="select Picture from StudentService where username=?";
						preparedS=(PreparedStatement) connect.prepareStatement(sqla);
						preparedS.setString(1, studentNumber);
						set=preparedS.executeQuery();
						if(set.next())
						{
							image=set.getBytes(1);
						}//end of if
						
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
					return image;
				}
			//****************************************end of dispalying  piciture of a product method
			//******************************ORDER MATHOD***********************************************
}

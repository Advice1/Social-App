package multiImageRetrival;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//#********************************Database class*********************#
public class FriendDatabase {
	private Connection con;
	private PreparedStatement prep;
	private ResultSet set;
	private String url="jdbc:mysql://127.0.0.1:3306/login";
	private String password="Nxumalo#1";
	private String username="root";
	//************************connecting to a database***********
	public void connectionDatabase() throws SQLException 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	//*******************************end of connection method *************************
	//*******************************method for retriving Data ******************************************
	public List<Student> GetData() throws SQLException 
	{
		Student Storage =null;  // object of the image class
		List<Student> DetailList=new ArrayList<Student>(); //forming an array list of StorageImage class
		connectionDatabase();
		String sql="select * from registration2";
		prep=con.prepareStatement(sql);
		set=prep.executeQuery();
		while(set.next())
		{
			Storage=new Student();  //creating an object of StorageImage
			// storing data in StorageImage object
			Storage.setName(set.getString(1));
			Storage.setSurname(set.getString(2));
			Storage.setDepartment(set.getString(3));
			Storage.setStdNumber(set.getString(5));
			Storage.setFacebook(set.getString(7));
			Storage.setInstagram(set.getString(8));
			Storage.setTweeter(set.getString(9));
			//Storage.setPicture(set.getBytes(10)); //picture section
			
			DetailList.add(Storage);//populating the list
		}
		return DetailList;
	}
	//*******************************end method *************************
	//*******************************method for retriving images *************************
	public byte[] getImage(String name){
		byte[] image =null;
		try {
			connectionDatabase();
			String sqla="select Picture from registration2 where Name=?";
			prep=con.prepareStatement(sqla);
			prep.setString(1, name);
			set=prep.executeQuery();
			if(set.next())
			{
				image=set.getBytes(1);
			}
		} //end of try
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return image;
	}
	//******************************* end of retriving method  *******************************************************
	//#####
	//counting the number of regiserrd students
	public List<Student> countingS() throws SQLException 
	{
		connectionDatabase();
		Student Storage =null;  // object of the storage class __Admin class
		List<Student> count=new ArrayList<Student>(); //forming an array list of student class
		String sql="select COUNT(Student_Number) FROM registration2";
		prep=(PreparedStatement) con.prepareStatement(sql);
		set=prep.executeQuery();
		while(set.next())
		    {
			Storage=new Student();  //creating an object of student
			// storing data in Storage object
			Storage.setTweeter(set.getString(1));    //storang the number of registered users
			count.add(Storage);
			}
		return count;	
	}
	//end of counting method
	//####
	//*******************************method for dispalying profile pic Data *************************
		public List<Student> updateProfile(String number) throws SQLException 
		{
			Student Storage =null;  // object of the image class
			List<Student> detailList=new ArrayList<Student>(); //forming an array list of Student class
			connectionDatabase();
			String sql="select * from registration2  where Student_Number='"+number+"'";
			prep=con.prepareStatement(sql);
			set=prep.executeQuery();
			while(set.next())
			{
				Storage=new Student();  //creating an object of Student
				// storing data in StorageImage object
				Storage.setName(set.getString(1));
				Storage.setSurname(set.getString(2));
				Storage.setDepartment(set.getString(3));
				Storage.setStdNumber(set.getString(5));
				Storage.setFacebook(set.getString(7));
				Storage.setInstagram(set.getString(8));
				Storage.setTweeter(set.getString(9));
				detailList.add(Storage);//populating the list
			}
			return detailList;
		}
		//*******************************end method *************************
		//******************************display profile pic image mathod*************************
		public byte[] DisplayProfileImage(String studentNumber){
			byte[] image =null;
			try {
				connectionDatabase();
				String sqla="select Picture from registration2 where Student_Number=?";
				prep=con.prepareStatement(sqla);
				prep.setString(1, studentNumber);
				set=prep.executeQuery();
				if(set.next())
				{
					image=set.getBytes(1);
					
				}
				
			}//end of try
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			return image;
		}
	//****************************************end of dispalying profile pic method
	//************************************************************* search methods**********************************
		//searching other details
		public List<Student> SearchData(String name) throws SQLException 
		{
			Student DetailSearch =null;  // object of the image class
			List<Student> ImageList=new ArrayList<Student>(); //forming an array list of StorageImagE class
			connectionDatabase();
			String sql="select * from registration2 where Name='"+name+"'or name LIKE '"+name+"%' or department='"+name+"' or Student_Number='"+name+"'";
			prep=con.prepareStatement(sql);
			set=prep.executeQuery();
			
			while(set.next())
			{
				DetailSearch=new Student();   //creating an object of StorageImage
				
				DetailSearch.setName(set.getString(1));
				DetailSearch.setSurname(set.getString(2));
				DetailSearch.setDepartment(set.getString(3));
				DetailSearch.setStdNumber(set.getString(5));
				DetailSearch.setFacebook(set.getString(7));
				DetailSearch.setInstagram(set.getString(8));
				DetailSearch.setTweeter(set.getString(9));
				//DetailSearch.setPicture(set.getBytes(10));
			
				ImageList.add(DetailSearch);
			}
			return ImageList;
		}
		//searching imanges
		public byte[] SearchImage(String name){
			byte[] image =null;
			try {
				connectionDatabase();
				String sql="select Picture from registration2 where name=?";
				prep=con.prepareStatement(sql);
				prep.setString(1, name);
				set=prep.executeQuery();
				
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
		//*************************************************************end of search methods**********************************
		//
		public List<Student> StorageMessage(String user1,String user2) throws SQLException 
		{
			Student Storage =null;  // object of the image class
			List<Student> DetailList=new ArrayList<Student>(); //forming an array list of StorageImage class
			connectionDatabase();
			String sql="select * from registration2 where user1='"+user1+"' and user2='"+user1+"'";
			prep=con.prepareStatement(sql);
			set=prep.executeQuery();
			while(set.next())
			{	
				Storage=new Student();  //creating an object of StorageImage
				Storage.setStdNumber(set.getString(5));
			
				DetailList.add(Storage);//populating the list
			}
			return DetailList;
		}
		//*******************************end method *************************
		//***************************************************************************************ADMINS CODE****************************************
		//****************************meassage from manager*********************
		public void Message(String messag,String name) throws SQLException
		{
			connectionDatabase();
			String sql="update registration2 set Notification='"+messag+"' where Student_Number=?";
			prep=con.prepareStatement(sql);
			prep.setString(1, name);
			prep.executeUpdate();
			
		}
		//****************************end meassage from manager*********************
		//****************************Deleting users by manager*********************
				public void DeletingUser(String name) throws SQLException
				{
					connectionDatabase();
					String sql="delete from registration2 where Student_Number=?";
					prep=con.prepareStatement(sql);
					prep.setString(1, name);
					prep.executeUpdate();
				}
	  //****************************end Deleting users by manager*********************
		public String name(String sql)
		{
		return sql;
		}
}
